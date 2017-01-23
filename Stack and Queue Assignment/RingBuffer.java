
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
		
	}
}
