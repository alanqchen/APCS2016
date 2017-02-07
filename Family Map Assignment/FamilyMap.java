/**
 * Alan Chen - APCompSci 2017
 * Project: Linked Lists
 * Date started: 2/3/2017
 * BONUS: Don't Do
 * TODO: DONE!
 */
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
public class FamilyMap {
	/* Private Variables */
	private TreeMap<String,TreeSet<String>> fm;
	private static Scanner input = new Scanner(System.in); 
	/* Basic Constructor */
	public FamilyMap() {
		fm = new TreeMap<String,TreeSet<String>>();
	}
	/* Adds a family to the map by having the user enter the last name, and the the first names manually */
	public void addFamily() {
		//Asks the user to enter the last name
		System.out.print("Please enter the last name: ");
		//stores user input
		String last =  input.next();
		//Asks the user to enter the first names
		System.out.print("Please enter the first name #1(enter \"!\" when done): ");
		//Creates the String var which will store the user inputs 
		String first = "filler";
		//counter for the number in the String below
		int count = 1;
		//Creates the set to store the user input first names
		TreeSet<String> fs = new TreeSet<String>();
		//loops until the user enters "!"
		while (!first.equals("!")) {
			if (count != 1)
				System.out.print("Please enter first name #" + count + ": ");
			//stores user input
			first = input.next();
			if (!first.equals("!")) {
				//Adds to the set and increments the counter up 1
				fs.add(first);
				count++;
			}
		}
		//adds the family to the map
		fm.put(last, fs);
	}
	/* Adds the family to the map with the last name and ArrayList of first names given*/
	public void addFamily(String surname, ArrayList<String> firstnames) {
		//creates the set to store the values
		TreeSet<String> fs = new TreeSet<String>();
		//transfers the first names from the arraylist to the set
		for (String first : firstnames) {
			fs.add(first);
		}
		//adds the family to the map
		fm.put(surname, fs);
	}
	/* Attempts to remove the given family from the map */
	public boolean removeFamily(String surname) {
		//attempts to remove
		TreeSet<String> test = fm.remove(surname);
		//checks if it's null
		if (test == null) {
			System.out.println("ERROR: There is no family with the last name " + surname + "!");
			return false;
		}
		return true;
	}
	/* Returns an array with all the first names in the given family */
	public String[] getFirstnames(String surname) {
		//creates the empty string array for the null case
		String[] empty = new String[0];
		//creates a set to store the values of the family
		TreeSet<String> test = fm.get(surname);
		//checks if it's null
		if (test == null) {
			System.out.println("ERROR: There is no family with the last name " + surname + "!");
			return empty;
		}
		for(String a : test) {
			System.out.println(a);
		}
		//creates the "Family Array" with the set size
		String[] fa = new String[test.size()];
		//transfers values to the array from the set
		int count = 0;
		for (String first : test) {
			fa[count] = first;
			count++;
		}
		//returns the array
		return fa;
	}
	/* Returns all the surnames in the map */
	public String[] getSurnames() {
		//Creates a set to store the keys of the map
		Set<String> test = fm.keySet();
		//transfers the keys from a set to a array
		int count = 0;
		String[] fa = new String[test.size()];
		for (String last : test) {
			fa[count] = last;
			count++;
		}
		//returns the array
		return fa;
	}
	/* Returns the name of the family of the two given that has the most members in it */
	public String moreMembers(String famname1, String famname2) {
		//creates the result String
		String result;
		//creates the sets to store the values of the family's
		TreeSet<String> test1 = fm.get(famname1);
		TreeSet<String> test2 = fm.get(famname2);
		//checks if either or both of the family's are null
		if (test1 == null && test2 == null) {
			System.out.println("ERROR: There are no family's with the last names " + famname1 + " and " + famname2 + "!");
			return result = "";
		} else if(test1 == null) {
			System.out.println("ERROR: There is no family with the last name " + famname1 + "!");
			return result = "";
		} else if(test2 == null) {
			System.out.println("ERROR: There is no family with the last name " + famname2 + "!");
			return result = "";
		}
		//stores the size of the set
		int size1 = test1.size();
		int size2 = test2.size();
		//checks which set is larger and sets the result accordingly
		if (size1 > size2) {
			result = famname1;
			return result;
		} else if (size1 < size2) {
			result = famname2;
			return result;
		} else {
			result = "Both family's have " + size1 + " members!";
			return result;
		}
	}
	/* Returns an array with the common first names between the two family's given */
	public String[] commonFirst(String famname1,String famname2) {
		//creates the result array
		String [] result;
		//creates the sets to store the values of the family's
		TreeSet<String> test1 = fm.get(famname1);
		TreeSet<String> test2 = fm.get(famname2);
		//checks if either or both of the family's are null
		if (test1 == null && test2 == null) {
			System.out.println("ERROR: There are no family's with the last names " + famname1 + " and " + famname2 + "!");
			return result = new String[0];
		} else if(test1 == null) {
			System.out.println("ERROR: There is no family with the last name " + famname1 + "!");
			return result = new String[0];
		} else if(test2 == null) {
			System.out.println("ERROR: There is no family with the last name " + famname2 + "!");
			return result = new String[0];
		}
		//stores the size of the set
		int size1 = test1.size();
		int size2 = test2.size();
		//creates a copy of each set to handle pointers going crazy
		TreeSet<String> copy1 = new TreeSet<String>();
		for (String a : test1) {
			copy1.add(a);
		}
		TreeSet<String> copy2 = new TreeSet<String>();
		for (String a : test2) {
			copy2.add(a);
		}
		//creates the sets that will be used in retainAll
		TreeSet<String> test3;
		TreeSet<String> test4;
		//checks which set is larger and sets the pointers accordingly
		if (size1 >= size2) {
			test3 = test1;
			test4 = test2;
		} else {
			test3 = test2;
			test4 = test1;
		}
		//uses the retainAll method to only keep what's in both sets
		test4.retainAll(test3);
		//Sets the result array size
		result = new String[test4.size()];
		//transfers the result to the result array
		int count = 0;
		for (String first : test4) {
			result[count] = first;
			count++;
		}
		//sets the pointers back(needed????)
		test1 = copy1;
		test2 = copy2;
		//re-creates the key and values to fix pointer issues
		fm.put(famname1, test1);
		fm.put(famname2, test2);
		//returns the result
		return result;
	}
	/* Returns the longest name in the given family */
	public String[] longestName(String famname) {
		//Creates a array to store the result
		String[] result;
		//creates a set to store the values of the family
		TreeSet<String> test = fm.get(famname);
		//checks if it's null
		if (test == null) {
			System.out.println("ERROR: There is no family with the last name " + famname + "!");
			return result = new String[0];
		}
		/* Part 1 - Finds the longest length and stores it in int length */
		int length;
		int store = 0;
		for (String a : test) {
			length = a.length();
			if (length > store) {
				store = length;
			}
		}
		/* Part 2 - Finds the number of the words that are the longest length and stores it in int count */
		int count = 0;
		for (String a : test) {
			length = a.length();
			if (length == store) {
				count++;
			}
		}
		/* Part 3 - Uses the number from part 2 and creates the array of that size, and then adds the names that match the length from part 1 */
		result = new String[count];
		int counter = 0;
		for (String a : test) {
			length = a.length();
			if (length == store) {
				result[counter] = a;
				counter++;
			}
		}
		return result;
	}
	/* Lists all names in the Map */
	public String[] listAll() {
		//creates an arraylist and an array for results
		ArrayList<String> list = new ArrayList<String>();
		String[] result;
		//gets all the keys in the map
		Set<String> keyset = fm.keySet();
		//creates an set for the values
		TreeSet<String> valueset;
		//creates a string for the names
		String name;
		//loops through all the keys, and the values of the keys in the map
		for (String last : keyset) {
			valueset = fm.get(last);
			for (String first : valueset) {
				//constructs the name and adds it to the arraylist
				name = last + ", " + first;
				list.add(name);
			}
		}
		//creates the size of the result array
		result = new String[list.size()];
		int count = 0;
		//moves the strings from the arralist to the result array
		for (String a : list) {
			result[count] = a;
			count++;
		}
		//returns result
		return result;
	}
	/* A display method for testing purposes */
	public void display() {
		Set<String> list = fm.keySet();
		for (String a : list) {
			System.out.println("|Key: " + a + " |Value: " + fm.get(a) + " |");
		}
	}
}
