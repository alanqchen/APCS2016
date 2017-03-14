
public class HeapPriorityQueueRunner {
	static HeapPriorityQueue main = new HeapPriorityQueue(5);
	public static void main(String[] args) {
		System.out.println("COUNT: " + main.getCount());
		main.add(4);
		main.add(6);
		main.add(3);
		main.add(5);
		main.add(8);
		System.out.println(main.add(10));
		System.out.println(main.isFull());
		System.out.println(main.peekMax());
		System.out.println("COUNT: " + main.getCount());
		System.out.println(main.toString());
		main.removeMax();
		System.out.println(main.toString());
		main.removeMax();
		System.out.println(main.toString());
		main.removeMax();
		System.out.println(main.toString());
		main.removeMax();
		System.out.println(main.toString());
		main.removeMax();
		System.out.println(main.toString());
		main.removeMax();
		System.out.println(main.toString());
		main.add(13);
		System.out.println(main.toString());
		main.add(2);
		System.out.println(main.toString());
		main.add(7);
		System.out.println(main.toString());
		main.add(18);
		System.out.println(main.toString());
		System.out.println(main.isFull());
		System.out.println(main.peekMax());
		System.out.println("COUNT: " + main.getCount());
		main.removeMax();
		System.out.println(main.toString());
		main.removeMax();
		System.out.println(main.toString());
		main.removeMax();
		System.out.println(main.toString());
		main.removeMax();
		System.out.println(main.toString());
		main.removeMax();
		System.out.println(main.toString());
		System.out.println(main.peekMax());
		System.out.println("COUNT: " + main.getCount());
		System.out.println(main.isFull());
	}

}

