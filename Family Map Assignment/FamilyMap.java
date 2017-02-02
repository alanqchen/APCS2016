/**
 * Alan Chen - APCompSci 2017
 * Project: Linked Lists
 * Date started: 2/3/2017
 * BONUS:
 * TODO: 
 */
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Scanner;
public class FamilyMap {
	private TreeMap<String,TreeSet<String>> fm;
	private static Scanner input = new Scanner(System.in); 
	public FamilyMap() {
		fm = new TreeMap<String,TreeSet<String>>();
	}
	public void addFamily() {
		System.out.print("Please enter the last name: ");
		String last =  input.next();
		System.out.print("Please enter the first name #1(enter \"!\" when done): ");
		String first = "filler";
		int count = 1;
		TreeSet<String> fs = new TreeSet<String>();
		while (!first.equals("!")) {
			if (count != 1)
				System.out.print("Please enter first name #" + count);
			first = input.next();
			if (!first.equals("!")) {
				System.out.println("Added " + first);
				fs.add(first);
				count++;
			}
		}
		fm.put(last, fs);
	}
	public void addFamily(String surname, ArrayList<String> firstnames) {
		TreeSet<String> fs = new TreeSet<String>();
		for (String first : firstnames) {
			fs.add(first);
		}
		fm.put(surname, fs);
	}
	public boolean removeFamily(String surname) {
		TreeSet<String> test = fm.remove(surname);
		if (test.equals(null)) {
			System.out.println("ERROR: There is no family with the last name " + surname + "!");
			return false;
		}
		return true;
	}
	public String[] getFirstnames(String surname) {
		TreeSet<String> test = fm.get(surname);
		if (test.equals(null)) {
			System.out.println("ERROR: There is no family with the last name " + surname + "!");
			return null;
		}
		String[] fa = new String[test.size()];
		int count = 0;
		for (String first : test) {
			fa[count] = first;
			count++;
		}
		return fa;
	}
	public String[] getSurnames() {
		TreeSet<String> test = (TreeSet<String>) fm.keySet();
		int count = 0;
		String[] fa = new String[test.size()];
		for (String last : test) {
			fa[count] = last;
			count++;
		}
		return fa;
	}
	public String moreMembers(String famname1, String famname2) {
		String result;
		TreeSet<String> test1 = fm.get(famname1);
		TreeSet<String> test2 = fm.get(famname1);
		if (test1.equals(null) && test2.equals(null)) {
			result = "ERROR: There are no family's with the last names " + test1 + " and " + test2 + "!";
			return result;
		} else if(test1.equals(null)) {
			result = "ERROR: There is no family with the last name " + test1 + "!";
			return result;
		} else if(test2.equals(null)) {
			result = "ERROR: There is no family with the last name " + test2 + "!";
			return result;
		}
		int size1 = test1.size();
		int size2 = test2.size();
		if (size1 > size2) {
			result = "famename1";
			return result;
		} else if (size1 < size2) {
			result = "famename2";
			return result;
		} else {
			result = "Both family's have " + size1 + "members!";
			return result;
		}
	}
	public String[] commonFirst(String famname1,String famename2) {
		TreeSet<String> test1 = fm.get(famname1);
		TreeSet<String> test2 = fm.get(famname1);
		if (test1.equals(null) && test2.equals(null)) {
			System.out.println("ERROR: There are no family's with the last names " + test1 + " and " + test2 + "!");
			return null;
		} else if(test1.equals(null)) {
			System.out.println("ERROR: There is no family with the last name " + test1 + "!");
			return null;
		} else if(test2.equals(null)) {
			System.out.println("ERROR: There is no family with the last name " + test2 + "!");
			return null;
		}
		int size1 = test1.size();
		int size2 = test2.size();
		if (size1 >= size2) {
			for (String first : test1) {
				
			}
		} else {
			
		}
	}
}
