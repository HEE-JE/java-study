package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ChatServerThread extends Thread {
	private Socket socket;
	List<ChatUser> listUsers;

	public ChatServerThread(Socket socket, List<ChatUser> listUsers) {
		this.socket = socket;
		this.listUsers = listUsers;
	}

	@Override
	public void run() {
		try {
			// 1. Remote Host Information

			// 2. 스트림 얻기
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			ChatUser user = new ChatUser(
					new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true));

			// 3. 요청 처리
			while (true) {
				String request = br.readLine();
				if (request == null) {
					ChatServer.log("클라이언트로 부터 연결 끊김");
					doQuit(user);
					break;
				}

				// 4. 프로토콜 분석
				String[] tokens = request.split(":");
				if ("join".equals(tokens[0])) {
					if (listUsers.size() == 0) {
						user.setRole(true);
					}
					join(tokens[1], user);
				} else if ("message".equals(tokens[0])) {
					if (tokens.length == 1) {
						user.getPrintWriter().println("메세지를 입력하세요.");
					} else {
						doMessage(tokens[1], user);
					}
				} else if ("change".equals(tokens[0])) {
					if (!user.isRole()) {
						user.getPrintWriter().println("반장이 아닙니다.");
					} else {
						user.getPrintWriter().println("닉네임을 입력하세요.");
						String nickName = br.readLine();
						doChange(nickName, user);
					}
				} else if ("kick".equals(tokens[0])) {
					if (!user.isRole()) {
						user.getPrintWriter().println("반장이 아닙니다.");
					} else {
						user.getPrintWriter().println("닉네임을 입력하세요.");
						String nickName = br.readLine();
						doKick(nickName, user);
					}
				} else if ("quit".equals(tokens[0])) {
					doQuit(user);
					break;
				} else {
					ChatServer.log("에러:알수 없는 요청(" + tokens[0] + ")");
				}
			}
		} catch (IOException e) {
			ChatServer.log("error:" + e);
		} finally {
			try {
				if (socket != null && !socket.isClosed())
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void join(String nickName, ChatUser user) {
		user.setName(nickName);

		String data = nickName + "님이 입장하였습니다.";
		broadcast(data);

		/* writer pool에 저장 */
		addUser(user);

		// ack
		user.getPrintWriter().println("정상적으로 입장되었습니다." + (user.isRole() ? "(반장)" : ""));
	}

	private void doChange(String nickName, ChatUser user) {
		user.setRole(false);
		boolean check = false;
		user.getPrintWriter().println("반장을 양도하셨습니다.");
		for (ChatUser chatUser : listUsers) {
			if (chatUser.getName().equals(nickName)) {
				check = true;
				chatUser.setRole(true);
				chatUser.getPrintWriter().println("반장을 양도받으셨습니다.");
				break;
			}
		}
		if (!check) {
			user.getPrintWriter().println("유저가 없습니다.");
		}
	}

	private void doKick(String nickName, ChatUser user) {
		boolean check = false;

		if (nickName.equals(user.getName())) { // kick시 반장 닉네임을 입력할 경우
			user.getPrintWriter().println("quit를 이용해주세요.");
		} else {
			for (ChatUser chatUser : listUsers) {
				if (chatUser.getName().equals(nickName)) {
					check = true;
					removeUser(chatUser);
					String data = chatUser.getName() + "님이 강퇴되었습니다.";
					broadcast(data);
					chatUser.getPrintWriter().println("강퇴되었습니다.");
					chatUser.getPrintWriter().close();
					break;
				}
			}
			if (!check) {
				user.getPrintWriter().println("유저가 없습니다.");
			}
		}
	}

	private void doMessage(String data, ChatUser user) {
		broadcast(user.getName() + " : " + data);
	}

	private void doQuit(ChatUser user) {
		if (user.isRole()) { // 반장이 나갈 시 반장 가장 일찍 들어온 사람에게 반장 양도
			for (ChatUser chatUser : listUsers) {
				if (chatUser != user) {
					chatUser.setRole(true);
					chatUser.getPrintWriter().println("반장을 양도받으셨습니다.");
					break;
				}
			}
		}

		removeUser(user);

		String data = user.getName() + "님이 퇴장하였습니다.";
		broadcast(data);
	}

	private void removeUser(ChatUser user) {
		/* 잘 구현 해보기 */
		synchronized (listUsers) {
			listUsers.remove(user);
		}
	}

	private void addUser(ChatUser user) {
		synchronized (listUsers) {
			listUsers.add(user);
		}
	}

	private void broadcast(String data) {
		synchronized (listUsers) {
			for (ChatUser chatUser : listUsers) {
				chatUser.getPrintWriter().println(data);
			}
		}
	}
}