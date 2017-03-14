/**
 * Alan Chen - APCompSci 2017
 * Project: Heap Priority Queue
 * Date started: 3/8/2017
 * TODO: DONE!
 */
public class HeapPriorityQueue implements MaxPriorityQueue{
	//private variables
	private Comparable [] heaparray;
	private int count;
	private int maxsize;
	/* CONSTRUCTOR */
	// Takes 1 parameter (size) and then creates an array with the param + 1, and also initializes the private variables
	public HeapPriorityQueue(int max) {
		maxsize = max;
		heaparray = new Comparable[maxsize + 1];
		count = 0;
	}
	/* isEmpty */
	// Returns true is the array is empty, false if not.
	public boolean isEmpty() {
		if (count == 0)
			return true;
		return false;
	}
	/* ADD */
	// Adds x to the array
	public boolean add(Comparable x) {
		//checks if the array is full
		if (count != maxsize) {
			//increments count
			count++;
			//adds the value at the end of the array
			heaparray[count] = x;
			//stores an index value to manipulate
			int index = count;
			//keeps swapping until the parent node is not smaller that the child
	        while (index > 1 && compare(index/2, index)) {
	        	//swaps
	            swap(index, index/2);
	            //changes index value to parent index value
	            index = index/2;
	        }
	        return true;
		}
		return false;
	}
	/* REMOVE */
	// Removes the max value in the array
	public Comparable removeMax() {
		//checks if the array is empty and displays error message if true
		if (isEmpty()) {
			System.out.println("ERROR: Heap is empty!");
			return null;
		}
		//stores the result to be returned later
		Comparable result = heaparray[1];
		//swaps the index 1 value with the value at count, and then count is incremented down 1
		swap(1, count--);
		//stores index value for manipulation
		int index = 1;
		//loops through the children nodes
        while (index * 2 <= count) {
        	//stores temp value
            int temp = index * 2;
            //tests if temp is still in bounds, and if the left child is less than the right one
            if (temp < count && compare(temp, temp + 1)) {
            	temp++;
            } if (!compare(index, temp)) {
            	break;	
            }
            //swaps the values with the set child
            swap(index, temp);
            //sets the temp value to the new index
            index = temp;
        }
        //sets the value to null
        heaparray[count + 1] = null;
        return result;
	}
	/* peekMax */
	//returns the max value
	public Comparable peekMax() {
		if (maxsize >= 1)
			return heaparray[1];
		return null;
	}
	/* isFull */
	//returns true is the array is full
	public boolean isFull() {
		if (count >= maxsize)
			return true;
		return false;
	}
	/* getCount */
	//returns the value of count
	public int getCount() {
		return count;
	}
	/* swap */
	//Helper method that swaps the values in the indexes a and b
	private void swap(int a, int b) {
		Comparable temp = heaparray[a];
		heaparray[a] = heaparray[b];
		heaparray[b] = temp;
	}
	/* compare */
	//returns true or false based on whether the value at a is less than the value at b
	private boolean compare(int a, int b) {
		return heaparray[a].compareTo(heaparray[b]) < 0;
	}
	/* toString */
	//returns a string of the array
	public String toString() {
		String s1 = "";
		//storage HPQ
		HeapPriorityQueue store = new HeapPriorityQueue(count);
		//builds the string
		while(!isEmpty()) {
			Comparable temp = removeMax();
			s1 += temp;
			store.add(temp);
			if(!isEmpty())
				s1 += ", ";
		}
		//adds the values back into the original array
		while(!store.isEmpty()) {
			add(store.removeMax());
		}
		return s1;
	}
}

