package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.Socket;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private Socket socket;

	public ChatWindow(String name, Socket socket) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.socket = socket;
	}

	public void show() {
		/*
		 * 1. UI 초기화
		 */

		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(actionEvent -> sendMessage());

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
				System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();

		/*
		 * 2. IOStream (pipeline established)
		 */

		/*
		 * 3. Chat Client Thread 생성 및 실행
		 */
	}

	private void sendMessage() {
		String message = textField.getText();
		System.out.println("메세지 보냄 프로토콜 구현" + message);
		textField.setText("");
		textField.requestFocus();

		// Chat Client Thread에서 서버로 부터 받은 메세지가 있다고 치고~~ (가짜 데이터)
		updateTextArea("마이콜:" + message);
	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}

	private void finish() {
		System.out.println("소켓 닫기 or 방나가기(quit) 프로토콜 구현");
		System.exit(0);
	}

	private class ChatClientThread extends Thread {
		@Override
		public void run() {
			while (true) {

			}
		}
	}
}