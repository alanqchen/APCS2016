/**
 * Alan Chen - APCompSci 2017
 * Project: Linked Lists
 * Date started: 1/21/2017
 * TODO: Document and test
 */
public class RingBuffer {
	//private variables
	private char[] characters;
	private int front;
	private int rear;
	//creates the ring buffer
	RingBuffer(int capacity) {
		characters = new char[capacity + 1];
		front = 0;
		rear = 0;
	}
	//returns if the ring buffer is empty or not
	public boolean isEmpty() {
		if (front == rear)
			return true;
		return false;
	}
	//makes the ring buffer empty
	public void flush() {
		front = 0;
		rear = 0;
	}
	//adds a char at rear
	public boolean add(char ch) {
		//System.out.println(characters.length);
		//should be a series of if loops, cases for wraped, non-wraped, empty, non-empty, and more.
		//first 2 if statments check if the rung buffer is full or not
		if (rear - front == characters.length - 1) {
			return false;
		} else if (front - rear == 1) {
			return false;
		}
		//adds to char at the rear index
		characters[rear] = ch;
		//increments counter
		rear++;
		//sets rear to the begining if it is over the ring buffer length
		if (rear == characters.length) {
			rear = 0;
		}
		//characters[rear] = ch;
		//rear++;
		return true;
	}
	//removes the char at the front(by incrementing the front)
	public char remove() {
		//tests if the ring buffer is empty or not. returns a space if it is
		if(isEmpty()) {
			return ' ';
		}
		//gets the char value to return later
		char temp = characters[front];
		front++;
		//for if the ring buffer is wraped
		if(front == characters.length) {
			front = 0;
		}
		//returns the char that was "removed"
		return temp;
	}
	//returns the char at the front
	public char peek() {
		//tests if the ring buffer is empty or not. returns a "!" if it is
		if(isEmpty()) {
			return '!';
		}
		//returns the char
		return characters[front];
	}
	//returns the int value of the front
	public int getFront() {
		return front;
	}
	//returns the int value of the rear
	public int getRear() {
		return rear;
	}
	//method used for testing/debugging
	/*
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
	*/
}
