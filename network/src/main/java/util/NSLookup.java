package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		Scanner scanner = null;
		InetAddress[] IP = null;
		try {
			scanner = new Scanner(System.in);
			while (true) {
				System.out.print("> ");
				String domain = scanner.nextLine();
				if ("exit".equals(domain)) {
					break;
				}

				IP = InetAddress.getAllByName(domain);
				for (InetAddress ip : IP) {
					System.out.println(ip.getHostName() + " : " + ip.getHostAddress());
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}