
public class RingBuffer {
	private char[] characters;
	private int front;
	private int rear;
	RingBuffer(int capacity) {
		characters = new char[capacity + 1];
		front = 0;
		rear = 0;
	}
	public boolean isEmpty() {
		if (front == rear)
			return true;
		return false;
	}
	public void flush() {
		front = 0;
		rear = 0;
	}
	public boolean add(char ch) {
		//should be a series of if loops, cases for wraped, non-wraped, empty, non-empty, and more.
		if (isEmpty()) {
				
		}
		return false
	}
}
