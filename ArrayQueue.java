/*
 * @author rraju
 * 9/28/17
 * 
 */

public class ArrayQueue implements Queue {

	Object[] queue = new Object[10];
	int size = 10;
	int tail = 0;
	int content = 0;

	@Override
	public Object dequeue() {
		if (empty()) {
			System.out.println("QUEUE EMPTY");
			return null;
		}
		Object temp = queue[0];
		for (int i = 0; i < content - 1; i++) {
			queue[i] = queue[i + 1];
		}
		tail--;
		content--;
		return temp;

	}

	@Override
	public void enqueue(Object item) {

		if (isFull()) {
			resize();
		}

		if (empty()) {
			queue[tail] = item;
			tail++;
			content++;
		} else {
			queue[tail] = item;
			tail++;
			content++;
		}
	}

	public void getContent() {
		System.out.println(content);
	}

	public boolean isFull() {
		if (tail < size - 1) {
			return false;
		}
		return true;
	}

	public boolean empty() {

		if (content == 0) {
			return true;
		}
		return false;

	}

	public void resize() {
		this.size = size * 2;
		Object[] temp = new Object[size];
		for (int i = 0; i < queue.length; i++) {
			temp[i] = queue[i];
		}
		queue = temp;
	}

}
