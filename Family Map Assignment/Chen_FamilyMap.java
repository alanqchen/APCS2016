import java.util.ArrayList;
import java.util.Arrays;

public class Chen_FamilyMap {

	public static void main(String[] args) {
		/* Add family */		
		System.out.println("ADD FAMILY TEST - NO PARAM");
		FamilyMap fm = new FamilyMap();
		/*
		fm.addFamily();
		fm.display();
		*/
		System.out.println("ADD FAMILY TEST - PARAM");
		ArrayList<String> fam1 = new ArrayList(Arrays.asList("james", "john","thomas"));
		fm.addFamily("Smith",fam1);
		fm.display();
		/* Remove family */
		System.out.println("REMOVE FAMILY TEST");
		boolean test = fm.removeFamily("Smith");
		System.out.println(test);
		fm.display();
		/*  Add Smith Again */
		System.out.println("ADD SMITH AGAIN");
		fm.addFamily("Smith",fam1);
		fm.display();
		/* Get first names */
		System.out.println("GET FIRST NAMES");
		String[] list = fm.getFirstnames("Smith");
		for(String a : list) {
			System.out.println(a);
		}
		/* Get surnames */
		System.out.println("GET SURENAMES");
		String[] list2 = fm.getSurnames();
		for(String a : list2) {
			System.out.println(a);
		}
		/* More Members */
		ArrayList<String> fam2 = new ArrayList(Arrays.asList("alex", "lizabeth","john","pierce","james"));
		fm.addFamily("Jones",fam2);
		ArrayList<String> fam7 = new ArrayList();
		fm.addFamily("Hill",fam7);
		System.out.println("MORE MEMBERS");
		String test3 = fm.moreMembers("Smith", "Jones");
		String test4 = fm.moreMembers("Smith", "Smith");
		System.out.println(test3);
		System.out.println("MORE MEMBERS - EQUAL");
		System.out.println(test4);
		/* Common first */
		System.out.println("COMMON FIRST");
		
		String[] list3 = fm.commonFirst("Smith", "Jones");
		for(String a : list3) {
			System.out.println(a);
		}
		//fm.display();
		System.out.println("COMMON FIRST - EMPTY");
		String[] list4 = fm.commonFirst("Smith", "Hill");
		for(String a : list4) {
			System.out.println(a);
		}
		/* Longest name */
		ArrayList<String> fam3 = new ArrayList(Arrays.asList("alex","jill","df","jack"));
		fm.addFamily("LaBarge",fam3);
		System.out.println("LONGEST FIRST - SINGLE");
		String[] list5 = fm.longestName("Jones");
		for(String a : list5) {
			System.out.println(a);
		}
		System.out.println("LONGEST FIRST - MULTIPLE");
		String[] list6 = fm.longestName("LaBarge");
		for(String a : list6) {
			System.out.println(a);
		}
		/* List all */
		System.out.println("LIST ALL");
		String[] list7 = fm.listAll();
		for(String a : list7) {
			System.out.println(a);
		}
		/* Stupid errors */
		System.out.println("REMOVE FAMILY TEST - FAKE");
		test = fm.removeFamily("FFAAAKKKEEE");
		System.out.println(test);
		System.out.println("GET FIRST NAMES - FAKE");
		fm.getFirstnames("FAKEE");
		System.out.println("MORE MEMBERS - FAKE(DOUBLE)");
		fm.moreMembers("FAKKE", "FFAAAKE");
		System.out.println("MORE MEMBERS - FAKE(SINGLE1)");
		fm.moreMembers("Smith", "FAAKEE");
		System.out.println("MORE MEMBERS - FAKE(SINGLE2)");
		fm.moreMembers("FAAAAKE", "Jones");
		System.out.println("COMMON FIRST - FAKE(DOUBLE)");
		fm.moreMembers("FAKKE", "FFAAAKE");
		System.out.println("COMMON FIRST - FAKE(SINGLE1)");
		fm.moreMembers("Smith", "FAAKEE");
		System.out.println("COMMON FIRST - FAKE(SINGLE2)");
		fm.moreMembers("FAAAAKE", "LaBarge");
		System.out.println("LONGEST NAME - FAKE");
		fm.longestName("FAAKE");
		/* Final Display */
		fm.display();
		System.out.print("-= DONE TESTING! =-");
	}

}
