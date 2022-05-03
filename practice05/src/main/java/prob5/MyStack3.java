package prob5;

@SuppressWarnings("unchecked")
public class MyStack3<T> {
	private int top = -1;
	private T[] stack;

	public MyStack3(int num) {
		stack = (T[]) new Object[num];
	}

	public void resize() {
		T[] newStack = (T[]) new Object[stack.length * 2];
		System.arraycopy(stack, 0, newStack, 0, top);
		stack = newStack;
	}

	public void push(T str) {
		if (top + 1 == stack.length) {
			resize();
		}
		stack[++top] = str;
	}

	public T pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException("stack is empty");
		}
		T str = stack[top];
		stack[top--] = null;
		return str;
	}

	public boolean isEmpty() {
		return (top == -1);
	}
}