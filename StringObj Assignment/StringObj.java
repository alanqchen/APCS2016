import java.util.ArrayList;

/*  ________  ___  ___  _______   ________      
 * |\   ____\|\  \|\  \|\  ___ \ |\   ___  \    
 * \ \  \___|\ \  \\\  \ \   __/|\ \  \\ \  \   
 *  \ \  \    \ \   __  \ \  \_|/_\ \  \\ \  \  
 *   \ \  \____\ \  \ \  \ \  \_|\ \ \  \\ \  \ 
 *    \ \_______\ \__\ \__\ \_______\ \__\\ \__\
 *     \|_______|\|__|\|__|\|_______|\|__| \|__|
 * StringObj.java                                             
 * Does stuff with Strings :)                                        
 * 
 */
public class StringObj {
	private String s;
	private int vowel;
	public StringObj(String s1) {
		s = s1;
		vowel = getNumVowels();
	}
	//returns the string
	public String toString() {
		String s1 = s;
		return s1;
	}
	//returns the number of vowels
	public int getNumVowels() {
		vowel = 0;
		String s1 = this.toString();
		for(int i=0;i <s1.length();i++){
			//checking for vowels by looping through each character
	        if((s1.toLowerCase().charAt(i) == 'a') || 
	           (s1.toLowerCase().charAt(i) == 'e') ||
	           (s1.toLowerCase().charAt(i) == 'i') || 
	           (s1.toLowerCase().charAt(i) == 'o') || 
	           (s1.toLowerCase().charAt(i) == 'u')) {
	            vowel++;
	        }
	    }
		return vowel;
	}
	//returns a boolean that tells the user if the strings are alphabetized
	public boolean areAlphabetized(StringObj str) {
		//creates strings that are all lower case
		String temp2 = str.toString().toLowerCase();
		String temp = this.toString().toLowerCase();
		//compare is set to the value of the compareTo method
		int compare = temp.compareTo(temp2);
		//checks what the value of compare to determine if they are alphabetical
		if (compare < 0){
		    return true;
		}
		else if (compare > 0) {
		    return false;
		}
		//the words must be the same
		else {
		    return true;
		}
	}
	//Calls the bonus method(same code)
	public boolean isPalindrome() {
		return this.isPalindromeBONUS(); 
	}
	//Returns a boolean that tells the user if the string is a palindrome
	public boolean isPalindromeBONUS() {
		//"\\W" matches any non-character, and removes it by replacing it with nothing (regex character class)
		String s2 = this.toString().toLowerCase().replaceAll("\\W", "");
		//System.out.println(s2);
		int j=0;
        int k = s2.length() - 1;
        //only loops through half of the string
        while(j < s2.length() / 2) {
        	//checks if the opposite letters are equal to each other
            if (s2.charAt(j++) != s2.charAt(k--)) {
            	//returns false if one of them is not equal
                return false;
            }
        }
        return true;
	}
	//Tells the user the number of times their word appears in the String by itself
	public int wordCount(String str){
		String test = str.toLowerCase();
	    int wordCount = 0;
	    String[] words = this.newsplit(" ");
	    //loops through the whole array, removing any non characters 
	    for (int i = 0; i < words.length; i++) {
	        words[i] = words[i].toLowerCase().replaceAll("\\W", "");
	    }
	    //loops through the whole array, looking for equality
	    for (int i = 0; i < words.length; i++) {
	    	if (words[i].equals(test)) {
	    		wordCount++;
	    	}
	    }
	    return wordCount;
	}
	//Tells the number of times their word appears in the String, including if it's within a word
	public int wordCountBONUS(String str) {
		//turns the string into all lowercase(creates new string "test")
		String test = str.toLowerCase();
		//saves the string length in a int
		int testlength = test.length();
		//initializes counter
		int wordCount = 0;
		//splits the sentence into a array of words
		String[] words = this.newsplit(" ");
		//loops through the whole array, removing any non characters("\\W" matches any non-character, and removes it by remplacing it by nothing-"") 
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].toLowerCase().replaceAll("\\W", "");
		}
		//System.out.println("END SPLITTER");
		//takes the length of "test" and uses that to check that many characters in each word.
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j + testlength< words [i].length() + 1; j++) {
				if (words [i].substring(j, j+testlength).equals(test)) {
					//increment word count
					wordCount++;
				}
			}
		}
		return wordCount;
	}
	public String[] newsplit(String tester) {
		//ArrayList that stores the end result
	    ArrayList<String> result = new ArrayList<String>();
	    //the string to be split
	    String s1 = this.toString();
	    //start counter
	    int start = 0;
	    //finds the first index of the tester string
	    int location = s1.indexOf(tester);
	    while (location >= start) {
	    	//splits the word
	        if (location > start) {
	            result.add(s1.substring(start,location));
	        }
	        //adds the length of the word to the start counter
	        start = location + tester.length();
	        result.add(tester);
	        location = s1.indexOf(tester,start); 
	    }
	    if (start<s1.length()) {
	        result.add(s1.substring(start));
	    }
	    String[] array = result.toArray(new String[0]);
	    return array;
	}
}
