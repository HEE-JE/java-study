package chapter03;

public class SwapTest03 { // call by Reference

	public static void main(String[] args) {
		Value a = new Value(10);
		Value b = new Value(20);

		System.out.println(a + ":" + b);

		/* swap */
		swap(a, b);

		System.out.println(a + ":" + b);
	}

	public static void swap(Value p, Value q) {
		/* swap */
		int temp = p.val;
		p.val = q.val;
		q.val = temp;
	}
}