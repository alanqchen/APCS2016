
public class HeapPriorityQueueRunner {
	static HeapPriorityQueue main = new HeapPriorityQueue(5);
	public static void main(String[] args) {
		/*
		 *           5
		 *          / \
		 *         4   3
		 *        / \  
		 *       3   4
		 *      /
		 *     2
		 *    /    
		 *   1    
		 *     
		 */
		main.add(4);
		main.add(6);
		main.add(3);
		main.add(5);
		main.add(8);
		main.add(10);
		main.toStringBONUS();
	}

}

