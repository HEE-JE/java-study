package chat;

import java.io.BufferedReader;
import java.io.IOException;

public class ChatClientThread extends Thread {
	private BufferedReader bufferedReader;

	public ChatClientThread(BufferedReader br) {
		bufferedReader = br;
	}

	@Override
	public void run() {
		/* reader를 통해 읽은 데이터 콘솔에 출력하기 (message 처리) */
		try {
			while (true) {
				String data = bufferedReader.readLine();
				if (data == null) {
					break;
				}
				System.out.println(data);
			}
		} catch (IOException e) {
			ChatClient.log("error:" + e);
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}