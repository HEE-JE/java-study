package prob5;

public class MyStack {
	private int top = -1;
	private String[] stack;

	public MyStack(int num) {
		stack = new String[num];
	}

	public int size() {
		return top + 1;
	}

	public void resize(int num) {
		String[] temp = new String[num];
		for (int i = 0; i < stack.length; i++) {
			temp[i] = stack[i];
		}
		stack = temp;
	}

	public void push(String str) {
		if (size() == stack.length) {
			resize(stack.length + 1);
		}
		stack[++top] = str;
	}

	public String pop() throws MyStackException {
		if(top == -1) {
			throw new MyStackException();
		}
		String str = stack[top];
		stack[top] = null;
		top--;
		return str;

	}

	public boolean isEmpty() {
		return (top == -1);
	}
}