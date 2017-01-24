
public class RingBufferRunner {
	private static RingBuffer ring;
	public static void main(String[] args) {
		ring = new RingBuffer(4);
		ring.add('a');
		ring.add('b');
		ring.add('c');
		ring.add('d');
		ring.display();
		ring.remove();
		ring.display();
		ring.add('e');
		ring.display();
	}

}
