package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {

	public static void main(String[] args) {
		BufferedOutputStream bos = null;
		try {
			// 기반 스트림
			FileOutputStream fos = new FileOutputStream("test.txt");

			// 보조 스트림
			bos = new BufferedOutputStream(fos);
		} catch (FileNotFoundException e) {
			System.out.println("Can`t Open:" + e);
		} finally {
			try {
				if (bos != null) {
					bos.close(); // 보조 스트림만 close 해주면 된다.
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}