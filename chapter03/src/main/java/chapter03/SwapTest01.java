package chapter03;

public class SwapTest01 { // call by Value

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		System.out.println(a + ":" + b);
		
		/* swap */
		int temp = a;
		a = b;
		b = temp;
		
		System.out.println(a + ":" + b);
	}
}