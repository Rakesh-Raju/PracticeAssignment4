/*
 * @author rraju
 * 9/28/17
 * 
 */

public class ArrayStack implements Stack {

	Object[] stack = new Object[10];
	int size = 10;
	int top = -1;
	int content = 0;

	@Override
	public void push(Object item) {

		if (isFull()) {
			resize();
		}
		top++;
		stack[top] = item;
		content++;

	}

	@Override
	public Object pop() {

		if (!empty()) {
			Object temp = stack[top];
			stack[top] = null;
			top--;
			content--;
			return temp;
		}

		return null;
	}

	@Override
	public Object peek() {
		return stack[top];
	}

	@Override
	public boolean empty() {
		if (content == 0) {
			return true;
		}

		return false;
	}

	public boolean isFull() {
		if (top == size - 1) {
			return true;
		}

		return false;
	}

	public void resize() {
		size = size * 2;
		Object[] temp = new Object[size];
		for (int i = 0; i < stack.length; i++) {
			temp[i] = stack[i];
		}
		stack = temp;
	}

}
