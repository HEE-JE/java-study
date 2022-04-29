package prob5;

public class MyStack {
	private int top = -1;
	private String[] stack;

	public MyStack(int num) {
		stack = new String[num];
	}

	public void resize() {
		if (top + 1 == stack.length) {
			String[] newStack = new String[stack.length * 2];
			System.arraycopy(stack, 0, newStack, 0, top);
			stack = newStack;
		}
	}
	
	public void push(String str) {
		resize();
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