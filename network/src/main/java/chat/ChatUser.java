package chat;

import java.io.PrintWriter;

public class ChatUser {
	private PrintWriter printWriter;
	private String name;
	private boolean role = false; // true = 반장, false = 일반

	public ChatUser(PrintWriter printWriter) {
		this.printWriter = printWriter;
	}

	public PrintWriter getPrintWriter() {
		return printWriter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}
}