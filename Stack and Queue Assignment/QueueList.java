/**
 * Alan Chen - APCompSci 2017
 * Project: Linked Lists
 * Date started: 1/20/2017
 * TODO: DONE
 */
import java.util.LinkedList;
//First in, First out
public class QueueList<E> {
	//Linked List that stores the data
	private LinkedList<E> list = new LinkedList<E>();
	//Adds the data to the back
	public boolean add (E x) {
		list.addLast(x);
		return true;
	}
	//Removes the data at the front
	public <E> E remove() {
		return (E) list.removeFirst();
	}
	//returns the data at the front
	public <E> E peek() {
		return (E) list.getFirst();
	}
	//returns if the queue is empty or not
	public boolean isEmpty() {
		if (list.size() == 0)
			return true;
		else
			return false;
	}
}
