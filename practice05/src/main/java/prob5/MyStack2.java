package prob5;

public class MyStack2 {
	private int top = -1;
	private Object[] stack;

	public MyStack2(int num) {
		stack = new Object[num];
	}

	public void resize() {
		Object[] newStack = new Object[stack.length * 2];
		System.arraycopy(stack, 0, newStack, 0, top);
		stack = newStack;
	}

	public void push(Object str) {
		if (top + 1 == stack.length) {
			resize();
		}
		stack[++top] = str;
	}

	public Object pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException("stack is empty");
		}
		Object str = stack[top];
		stack[top--] = null;
		return str;
	}

	public boolean isEmpty() {
		return (top == -1);
	}
}