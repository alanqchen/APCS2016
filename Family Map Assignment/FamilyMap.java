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
import java.util.Set;
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
				System.out.print("Please enter first name #" + count + ": ");
			first = input.next();
			if (!first.equals("!")) {
				//System.out.println("Added " + first);
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
		if (test1 == null && test2 == null) {
			result = "ERROR: There are no family's with the last names " + test1 + " and " + test2 + "!";
			return result;
		} else if(test1 == null) {
			result = "ERROR: There is no family with the last name " + test1 + "!";
			return result;
		} else if(test2 == null) {
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
	public String[] commonFirst(String famname1,String famname2) {
		String [] result;
		TreeSet<String> test1 = fm.get(famname1);
		TreeSet<String> test2 = fm.get(famname2);
		if (test1 == null && test2 == null) {
			System.out.println("ERROR: There are no family's with the last names " + famname1 + " and " + famname2 + "!");
			return null;
		} else if(test1 == null) {
			System.out.println("ERROR: There is no family with the last name " + test1 + "!");
			return null;
		} else if(test2 == null) {
			System.out.println("ERROR: There is no family with the last name " + test2 + "!");
			return null;
		}
		int size1 = test1.size();
		int size2 = test2.size();
		TreeSet<String> test3;
		TreeSet<String> test4;
		TreeSet<String> test5 = new TreeSet<String>();
		if (size1 >= size2) {
			test3 = test1;
			test4 = test2;
		} else {
			test3 = test2;
			test4 = test1;
		}
		test4.retainAll(test3);
		result = new String[test4.size()];
		int count = 0;
		for (String first : test4) {
			result[count] = first;
			count++;
		}
		return result;
	}
	public String[] longestName(String famname) {
		String[] result;
		TreeSet<String> test = fm.get(famname);
		if (test == null) {
			System.out.println("ERROR: There is no family with the last name " + test + "!");
			return null;
		}
		int length;
		int store = 0;
		for (String a : test) {
			length = a.length();
			if (length > store) {
				store = length;
			}
		}
		int count = 0;
		for (String a : test) {
			length = a.length();
			if (length == store) {
				count++;
			}
		}
		result = new String[count];
		int counter = 0;
		for (String a : test) {
			length = a.length();
			if (length == store) {
				result[counter] = a;
				count++;
			}
		}
		return result;
	}
	public String[] listAll() {
		ArrayList<String> list = new ArrayList<String>();
		String[] result;
		TreeSet<String> keyset = (TreeSet<String>) fm.keySet();
		TreeSet<String> valueset;
		String name;
		for (String last : keyset) {
			valueset = fm.get(last);
			for (String first : valueset) {
				name = last + ", " + first;
				list.add(name);
			}
		}
		result = new String[list.size()];
		int count = 0;
		for (String a : list) {
			result[count] = a;
			count++;
		}
		return result;
	}
	public boolean exists(String famname) {
		if (fm.get(famname) == null)
			return false;
		else
			return true;
	}
	public void display() {
		Set<String> list = fm.keySet();
		for (String a : list) {
			System.out.println("|Key: " + a + " |Value: " + fm.get(a) + " |");
		}
	}
}
