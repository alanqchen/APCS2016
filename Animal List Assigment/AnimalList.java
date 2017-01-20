/**
 * Alan Chen - APCompSci 2017
 * Project: Linked Lists
 * Date started: 1/9/2017
 * BONUS: Display the name before and after when removing/adding(in one line) Ex. Added: Cow | Before: NONE | After: Bear 
 * TODO: Document and possibly optimize code
 */
public class AnimalList {
	//instance variables
	private ListNode head;
	private int numAddRemove;
	//adds animal alphabetically
	public void addAnimal(Comparable addValue) {
	    ListNode temp = new ListNode(addValue, null);
	    ListNode current = head;
	    ListNode prev = head;
	    /* Case 1: Is the list empty? */
	    if(head == null){
	        head = temp;
	        System.out.println("\n| Added: " + addValue.toString() + " | Before: NONE | After: NONE |");
	    /* Case 2: Are we adding infront of the first in the list? */
	    } else if (addValue.compareTo(current.getValue()) < 0) {
	    	temp.setNext(head);
	    	head = temp;
	    	System.out.println("\n| Added: " + addValue.toString() + " | Before: NONE | After: " + temp.getNext().getValue().toString() + " |");
	    /* Case 3: Adding in the middle or end */
	    }else{
	    	while ( current != null ) {
	    		//cycle until it's negative
	    		if ( current.getValue() != null && addValue.compareTo(current.getValue()) < 0 ) {
	    			break;              
	    		}
	    		prev = current;
	    		current = current.getNext();
	    	}
	    	temp.setNext( prev.getNext() );
	    	prev.setNext(temp);
	    	String after;
	    	//If last in the list
	    	if (current == null) {
	    		after = "NONE";
	    	//if middle in the list
	    	} else {
	    		after = current.getValue().toString();
	    	}
	    	System.out.println("\n| Added: " + addValue.toString() + " | Before: " + prev.getValue().toString() + " | After: " + after + " |");
	    }
	    //increment counter
	    numAddRemove++;
	}
	//removes the first instance of the animal searchValue
	public boolean removeAnimal(Comparable searchValue) {
	    /* Traverse/Removal */
	    //Case 1: Is the list empty?
        if (head == null) 
        	return false;
        //status int to remeber if it passed the second if statment(also too lazy to change code to if-else)
		int status = 0;
		//starts the boolean
		boolean result = false;
		//point to the node after prev
        ListNode current = head;
        //points to the node before current
        ListNode prev;
        //since prev is changed later on
        ListNode storage = current.getNext();
        //Case 2: Is the first instance the first item in the list?
        if (current.getValue().equals(searchValue)) {
            head = current.getNext();
	    	numAddRemove++;
            result = true;
            status = 1;
        }
        //Case 3: Middle or End
        prev = current;
        while ((current = current.getNext()) != null) {
            if (current.getValue().equals(searchValue)) {
                prev.setNext(current.getNext());
                numAddRemove++;
                result = true;
                break;
            }
            prev = current;
        }
        /* Bonus String Selector */
        //Did it find it?
        if (result != false) {
        	String after;
        	//if it's at the end of the list
        	if (current == null || current.getNext() == null) {
        		after = "NONE";
        	//if it's in the middle 
        	} else {
        		after = current.getNext().getValue().toString();
        	}
        	//Case 1: Not the first
        	if (status != 1)
        		System.out.println("\n| Removed: " + searchValue.toString() + " | Before: " + prev.getValue().toString() + " | After: " + after + " |");
        	//Case 2: First and not the only one in the list
        	if (status == 1 && storage != null)
        		System.out.println("\n| Removed: " + searchValue.toString() + " | Before: NONE | After: " + storage.getValue().toString() + " |");
        	//Case 3: Only one in the list
        	if (status == 1 && storage == null) 
        		System.out.println("\n| Removed: " + searchValue.toString() + " | Before: NONE | After: NONE |");
        }
        //returns the result
        return result;
	}
    //attractively displays the list of animal names
	public void displayList() {
	    //counter for "1.","2.", etc.
		int counter = 1;
		//header
		String s1 = "\n" + "#====================== Animal List ======================#";
		//Case 1: Is the list not empty?
		if (head != null) {
			ListNode current = head;
			//traverse the list
			while (current != null) {
			    //adds "| (counter). (value)"
				s1 += "\n" + "| " + counter + ". " + current.getValue();
				//gets the length of the value, and adds spaces to the string until it reaches the set number of characters
				for ( int i = current.getValue().toString().length(); i <= 51; i++) {
					s1 += " ";
				}
				//if the number is larger than 10, doesn't add the extra space to compensate
				if (counter >= 10)
					s1 += "|";
				else
					s1 += " |";
				//increments counter
				counter++;
				//traverses
				current = current.getNext();
			}
	    //Case 2: Empty List
		} else {
			s1 += "\n" + "| The list is empty!                                      |";
		}
		//footer
		s1 += "\n" + "#=========================================================#" + "\n";
		//display
		System.out.println(s1);
	}
	//returns the number of successful additions/removals
	public int getnumAddRemove() {
	    // 
	    return numAddRemove;    
	}
}
