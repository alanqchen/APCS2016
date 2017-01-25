
public class RingBufferRunner {
	private static RingBuffer ring;
	public static void main(String[] args) {
		/*
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
		System.out.println(ring.add('f'));
		ring.display();
		ring.remove();
		ring.remove();
		ring.remove();
		ring.remove();
		ring.display();
		*/
		ring = new RingBuffer(1);
		ring.add('a');
		System.out.println(ring.add('f'));
		ring.remove();
		System.out.println(ring.add('b'));
		System.out.println(ring.add('c'));
		ring.remove();
		System.out.println(ring.add('e'));
		ring.display();
	}

}
