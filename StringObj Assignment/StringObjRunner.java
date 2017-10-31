public class StringObjRunner {

	public static void main(String[] args) {
		//*****CONSTRUCTER*****
		String str1 = "Rupert";
		StringObj s1 = new StringObj(str1);
		System.out.println(s1); 	//Displays Rupert to the screen
		System.out.println(s1.getNumVowels()); 	//Displays 2 to the screen
		//*****ALPHABETIZED*****
		StringObj s2 = new StringObj("apple"); 
		System.out.println(s2.getNumVowels()); //should display 2
		StringObj s3 = new StringObj("BOB"); //should display 1
		System.out.println(s3.getNumVowels());
		System.out.println(s3);
		System.out.println(s2.areAlphabetized(s3));   // should display true 
		System.out.println(s3.areAlphabetized(s2));
		//*****PALINDROME*****
		System.out.println("PALIDROME");
		StringObj s4 = new StringObj("bob");
		System.out.println(s4.isPalindrome());   // should display true
		StringObj s5 = new StringObj("Madam, I’m Adam.");
		System.out.println(s5.isPalindromeBONUS());
		StringObj p1 = new StringObj("Was it a car or a cat I saw?");
		System.out.println(p1.isPalindrome());
		StringObj p2 = new StringObj("No 'x' in Nixon");
		System.out.println(p2.isPalindrome());
		StringObj p3 = new StringObj("Mr. Owl ate my metal worm");
		System.out.println(p3.isPalindrome());
		StringObj p4 = new StringObj("Go hang a salami, I'm a lasagna hog");
		System.out.println(p4.isPalindrome());
		StringObj p5 = new StringObj("Rise to vote, sir");
		System.out.println(p5.isPalindrome());
		StringObj p6 = new StringObj("Taco cat");
		System.out.println(p6.isPalindrome());
		StringObj p7 = new StringObj("Racecar");
		System.out.println(p7.isPalindrome());
		StringObj p8 = new StringObj("Not a palindrome!");
		System.out.println(p8.isPalindrome()); //should display false
		//*****WORD COUNT*****
		String st1 = "Dog faced Dogbert ran doggedly into the dog house to study endogamous dogma.";
		StringObj sobj = new StringObj(st1);
		String search = "DOG";
		System.out.println("The count is: " + sobj.wordCount(search));  // will display 2
		System.out.println("The count is(Bonus): " + sobj.wordCountBONUS(search));  // will display 6
		String str5 = "green eggs and ham? I do not like them, Sam I am. I do not like green eggs and ham. "
				+ "Would you like them here or there? I would not like them here or there.";
		StringObj sobj2 = new StringObj(str5);
		search = "i";
		System.out.println("The count #2 is: " + sobj2.wordCount(search)); 
		System.out.println("The count #2 is(Bonus): " + sobj2.wordCountBONUS(search)); 
	}
}
