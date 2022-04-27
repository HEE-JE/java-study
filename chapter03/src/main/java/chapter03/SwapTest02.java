package chapter03;

public class SwapTest02 { // call by Value

	public static void main(String[] args) {
		int a = 10;
		int b = 20;

		System.out.println(a + ":" + b);

		/* swap */
		swap(a, b);

		System.out.println(a + ":" + b);
	}

	public static void swap(int p, int q) {
		/* swap */
		int temp = p;
		p = q;
		q = temp;
	}
}