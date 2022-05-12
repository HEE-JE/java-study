package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import chat.ChatUser;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private TextArea textList;
	private Socket socket;
	BufferedReader br = null;
	PrintWriter pw = null;
	private boolean kickCheck = false;
	private boolean changeCheck = false;
	List<String> lists = new ArrayList<String>();

	public ChatWindow(String name, Socket socket) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		textList = new TextArea(30, 10);
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

		// List
//		list.setEditable(false);
		frame.add(BorderLayout.EAST, textList);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();

		/*
		 * 2. IOStream (pipeline established)
		 */
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			/*
			 * 3. Chat Client Thread 생성 및 실행
			 */
			new ChatClientThread().start();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void sendMessage() {
		String message = textField.getText();
		if ("quit".equals(message)) {
			finish();
		} else if ("change".equals(message)) {
			pw.println("change");
			changeCheck = true;
		} else if (changeCheck) {
			pw.println(message);
			changeCheck = false;
		} else if ("kick".equals(message)) {
			pw.println("kick");
			kickCheck = true;
		} else if (kickCheck) {
			pw.println(message);
			kickCheck = false;
		} else {
			pw.println("message:" + message);
		}
		textField.setText("");
		textField.requestFocus();
	}

	private void updateListArea(List<String> lists) {
		textList.setText("<명단>\n");
		for (String name : lists) {
			textList.append(name);
			textList.append("\n");
		}
	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}

	private void finish() {
		pw.println("quit");
		System.exit(0);
	}

	private class ChatClientThread extends Thread {
		@Override
		public void run() {
			try {
				while (true) {
					String data = br.readLine();
					if (data == null) {
						break;
					}
					if (data.charAt(0) == '`') {
						data = data.substring(1, data.length());
//						System.out.println(data);
						String[] tokens = data.split("`");
						for (int i = 0; i < tokens.length; i++) {
//							System.out.println(tokens[i]);
							lists.add(tokens[i]);
						}
						updateListArea(lists);
						lists.clear();
					} else {
						updateTextArea(data);
					}
				}
			} catch (IOException e) {
				// Stream closed
			} finally {
				try {
					if (br != null) {
						br.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}