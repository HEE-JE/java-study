package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. 서버소켓(서버에서 클라이언트의 요청을 기다리는 소켓) 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩(binding)
			// Socket에 inetSocketAddress(IPAddress + Port)를 바인딩한다.
			// IPAddress(0.0.0.0) : 특정 호스트 IP를 바인딩 하지 않는다.
			// 특정 호스트를 바인딩하면 그 호스트 IP만 서버를 사용할 수 있다.
			// backlog : 요청queue(10)
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 9999), 10);

			// 3. accept
			// 클라이언트로 부터 요청을 기다린다.
			Socket socket = serverSocket.accept(); // blocking

			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = inetSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetSocketAddress.getPort();
			System.out.println("[server] connected by client[" + remoteHostAddress + ":" + remoteHostPort + "]");

			try { // ServerSocket과 dataSocket의 에러를 분리해줄 필요가 있다.
					// 4. IO Stream 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();

				while (true) { // 서버가 끊길때 까지 계속 읽어오기
					// 5. 데이터 읽기
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer); // blocking
					if (readByteCount == -1) {
						// 클라이언트가 정상적으로 종료
						// = 클라이언트가 자신의 socket.close() 호출
						System.out.println("[server] closed by client");
						break;
					}
					// byte로 받은 것을 data로 인코딩
					String data = new String(buffer, 0, readByteCount, "UTF-8");
					System.out.println("[server] received:" + data);

					// 6. 데이터 쓰기
					os.write(data.getBytes("UTF-8"));
				}
			} catch (SocketException e) { // socket.close()하지 않고 비정상 종료
				System.out.println("[server] suddenly closed by client");
			} catch (IOException e) { // dataSocket의 에러
				System.out.println("[server] error:" + e);
			} finally {
				try {
					if (socket != null && !socket.isClosed())
						socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) { // ServerSocket의 에러
			System.out.println("[server] error:" + e);
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}