package prob5;

public class MainApp {

	public static void main(String[] args) {
		try {
			MyStack stack = new MyStack(3);
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
			stack.push("java");
			stack.push(".");

			while (stack.isEmpty() == false) {
				String s = stack.pop();
				System.out.println( s );
			}

			System.out.println("======================================");

			stack = new MyStack(3);
			stack.push("Hello");

			System.out.println(stack.pop());
			System.out.println(stack.pop());
			
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex);
			// getMessage(, getLocalizedMessage  Index -1 out of bounds for length 3
			// getClass() class java.lang.ArrayIndexOutOfBoundsException
		}

	}

}
