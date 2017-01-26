/**
 * Alan Chen - APCompSci 2017
 * Project: Linked Lists
 * Date started: 1/20/2017
 * Notes: This is a BONUS assignment!
 * TODO: DONE
 */
import java.util.LinkedList;
//First in, Last out
public class StackList<E> {
	//list that stores the data
	private LinkedList<E> list = new LinkedList<E>();
	//adds data at the top of the stack
	public void push(E x) {
		list.addFirst(x);
	}
	//removes the data at the top of the stack
	public <E> E pop() {
		return (E) list.removeFirst();
	}
	//returns the data at the top of the list
	public <E> E peek() {
		return (E) list.get(0);
	}
	//returns if the stack is empty or not
	public boolean isEmpty() {
		if (list.size() == 0)
			return true;
		else
			return false;
	}
}
