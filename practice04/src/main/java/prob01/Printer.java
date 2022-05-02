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
//
//	public <T> void println(T t) {
//		System.out.println(t);
//	}

	public int sum(Integer... nums) {
		int sum = 0;
		for (Integer i : nums) {
			sum += i;
		}
		return sum;
	}

	public <T> void println(T... ts) {
		for (T t : ts) {
			System.out.println(t);
		}
	}
}