
public class HeapPriorityQueue implements MaxPriorityQueue{
	private Comparable [] heaparray;
	private int count;
	private int maxsize;
	public HeapPriorityQueue(int max) {
		maxsize = max;
		heaparray = new Comparable[maxsize + 1];
		count = 0;
	}
	public boolean isEmpty() {
		if (count == 0)
			return true;
		return false;
	}
	public boolean add(Comparable x) {
		if (count != maxsize) {
			int index = count + 1;
			heaparray[count + 1] = x;
			if (count == 0) {
				System.out.println("added");
				heaparray[1] = x;
				count++;
				for(Comparable a : heaparray) {
					System.out.print(a + " ");	
				}
				System.out.println();
				return true;
			}
			while(index > 1 && x.compareTo(heaparray[index/2]) > 0) {
				int temp = (Integer) heaparray[index/2];
				heaparray[index/2] = x;
				heaparray [index] = temp;
				index = index/2;
			}
			for(Comparable a : heaparray) {
				System.out.print(a + " ");	
			}
			System.out.println();
			count++;
			return true;
		}
		return false;
	}
	public Comparable removeMax() {
		int index = 1;
		Comparable returnvalue = heaparray[1];
		heaparray[1] = heaparray[count];
		heaparray[count] = null;
		count--;
		while (index <= count) {
			if (index * 2 <= count && index * 2 + 1 <= count) {
				if (heaparray[index * 2].compareTo(heaparray[index * 2 + 1]) < 0) {
					if (heaparray[index].compareTo(heaparray[index * 2 + 1]) < 0) {
						Comparable temp = heaparray[index * 2 + 1];
						heaparray[index * 2 + 1] = heaparray[index];
						heaparray[index] = temp;
						index = index * 2 + 1;
					}
				}
			} else if (index * 2 <= count) {
				Comparable temp = heaparray[index * 2];
				heaparray[index * 2] = heaparray[index];
				heaparray[index] = temp;
				index = index * 2;
			} else if (index * 2 + 1 <= count) {
				Comparable temp = heaparray[index * 2 + 1];
				heaparray[index * 2 + 1] = heaparray[index];
				heaparray[index] = temp;
				index = index * 2 + 1;
			}
		}
		return returnvalue;
	}
	public Comparable peekMax() {
		return heaparray[1];
	}
	public boolean isFull() {
		if (count >= maxsize)
			return true;
		return false;
	}
	public int getCount() {
		return 0;
	}
	public void toStringBONUS() {
		int index = 0;
		if (index == 0) {
			System.out.println(heaparray[1]);
			index++;
		}
		while(index <= count) {
			String store = "";
			int begin = (int) Math.pow(2, index);
			int end = (int) (Math.pow(2, index + 1) - 1);
			while (index >= begin && index <= end) {
				store += heaparray[index] + "   ";
				index++;
			}
			System.out.println(store);
			index++;
		}
	}
}

