package prob01;

public class Printer {
//	public void println(int num) {
//		System.out.println(num);
//	}
//
//	public void println(boolean bol) {
//		System.out.println(bol);
//	}
//
//	public void println(double num) {
//		System.out.println(num);
//	}
//
//	public void println(String str) {
//		System.out.println(str);
//	}

	// Generic 메소드로 해결
	public <T> void println(T t) {
		System.out.println(t);
	}

	public int sum(int... nums) { // nums는 배열을 의미
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		return sum;
	}

	public <T> void printlnGeneric(T... print) { // nums는 배열을 의미
		for (T i : print) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}