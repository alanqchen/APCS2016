import java.util.LinkedList;

public class QueueList<E> {
	private LinkedList<E> list = new LinkedList<E>();
	public boolean add (E x) {
		list.addLast(x);
		return true;
	}
	public <E> E remove() {
		return (E) list.removeFirst();
	}
	public <E> E peek() {
		return (E) list.getFirst();
	}
	public boolean isEmpty() {
		if (list.size() == 0)
			return true;
		else
			return false;
	}
}
