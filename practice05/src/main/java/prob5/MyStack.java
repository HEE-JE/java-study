package prob5;

public class MyStack {
	private int top = -1;
	private String[] stack;

	public MyStack(int num) {
		stack = new String[num];
	}

	public void resize() {
		String[] newStack = new String[stack.length * 2];
		System.arraycopy(stack, 0, newStack, 0, top);
		stack = newStack;
	}

	public void push(String str) {
		if (top + 1 == stack.length) {
			resize();
		}
		stack[++top] = str;
	}

	public String pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException("stack is empty");
		}
		String str = stack[top];
		stack[top--] = null;
		return str;
	}

	public boolean isEmpty() {
		return (top == -1);
	}
}