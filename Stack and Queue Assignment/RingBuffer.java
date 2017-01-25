/**
 * Alan Chen - APCompSci 2017
 * Project: Linked Lists
 * Date started: 1/21/2017
 * TODO: Document and test
 */
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
		//System.out.println(characters.length);
		//should be a series of if loops, cases for wraped, non-wraped, empty, non-empty, and more.
		if (rear - front == characters.length - 1) {
			return false;
		} else if (front - rear == 1) {
			return false;
		}
		characters[rear] = ch;
		rear++;
		if (rear == characters.length) {
			rear = 0;
		}
		//characters[rear] = ch;
		//rear++;
		return true;
	}
	public char remove() {
		if(isEmpty()) {
			return ' ';
		}
		char temp = characters[front];
		front++;
		if(front == characters.length) {
			front = 0;
		} 
		return temp;
	}
	public char peek() {
		if(isEmpty()) {
			return '!';
		}
		return characters[front];
	}
	public int getFront() {
		return front;
	}
	public int getRear() {
		return rear;
	}
	public void display() {
		String s1 = "";
		String s2 = "";
		for (char a : characters) {
			s1 += String.valueOf(a) + " | ";
		}
		s2 += "Front: " + getFront() + "\nRear: " + getRear();
		System.out.println(s1);
		System.out.println(s2);
	}
}
