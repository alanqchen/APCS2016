import java.util.LinkedList;

public class StackList<E> {
	private LinkedList<E> list = new LinkedList<E>();
	public void push(E x) {
		list.addFirst(x);
	}
	public <E> E pop() {
		return (E) list.removeFirst();
	}
	public <E> E peek() {
		return (E) list.get(0);
	}
	public boolean isEmpty() {
		if (list.size() == 0)
			return true;
		else
			return false;
	}
}
