package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "192.168.10.22";
	private static final int SERVER_PORT = 9999;

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;

		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);

			// 2. socket 생성
			socket = new Socket();

			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

			// 4. reader/writer 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			// 5. join 프로토콜
			while (true) {
				System.out.print("닉네임>>");
				String nickname = scanner.nextLine();
				if (!"".equals(nickname)) {
					pw.println("join:" + nickname);
					break;
				}
				System.out.println("닉네임을 입력해주세요.");
			}

			// 6. ChatClientReceiveThread 시작
			new ChatClientThread(br).start();

			// 7. 키보드 입력 처리
			while (true) {
				System.out.print(">>");
				String input = scanner.nextLine();

				if ("".equals(input)) {
					System.out.println("메세지를 입력해주세요.");
				} else if ("quit".equals(input)) {
					// 8. quit 프로토콜 처리
					pw.println("quit");
				} else {
					// 9. 메시지 처리
					pw.println("message:" + input);
				}
			}
		} catch (IOException e) {
			log("error:" + e);
		} finally {
			// 10. 자원정리
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	public static void log(String log) {
		System.out.println("[Chat Client] " + log);
	}
}