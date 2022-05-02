package chapter04;

public class WrapperClassTest01 {

	public static void main(String[] args) {
		Integer i = new Integer(10); // deprecated = 곧 없어질 것
		Character c = new Character('c'); // deprecated = 곧 없어질 것
		Boolean b = new Boolean(true); // deprecated = 곧 없어질 것

		// Auto Boxing
		Integer j1 = 10;
		Integer j2 = 10;

		System.out.println(j1 == j2);
		System.out.println(j1.equals(j2));

		// Auto Unboxing
		// int m = j1.intValue() + 10;
		int m = j1 + 10;
	}
}