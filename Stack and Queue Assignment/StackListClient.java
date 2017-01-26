/**
 * Alan Chen - APCompSci 2017
 * Project: Linked Lists
 * Date started: 1/21/2017
 * TODO: Document
 */
import java.util.Scanner;
public class StackListClient {
	//stacklist
	private static StackList list = new StackList();
	//scanner for input
	private static Scanner input = new Scanner(System.in); 
	public static void main(String[] args) {
		//menu
		int menu=0;
		do {
			System.out.println("#======= Stack List Client =======#");
			System.out.println("|1. Enter Sentence/Replace Word   |");
			System.out.println("|2. McKeen's Test Case            |");
			System.out.println("|3. Quit                          |");
			System.out.println("#=================================#");
			System.out.print("Please choose a selection: ");
			menu = input.nextInt();
				//1. Enter Sentence/Replace Word
				if (menu == 1) {
					//convert contains the letter
					String convert;
					//split contains the word
					String split = "";
					System.out.print("Enter a sentence(ended with a period): ");
					//consumes line
					input.nextLine();
					//stores the sentence
					String s1 = input.nextLine();
					//System.out.println(s1);
					//adds the letters of the words one-by-one
					for (int i = 0; i < s1.length(); i++) { 
						//gets the char at index i
						convert = String.valueOf(s1.charAt(i));
						//if the char is a space or period, it adds split to the list, and makes split empty again
						if (convert.equals(" ") || convert.equals(".")) {
							list.push(split);
							split = "";
						//else, adds the letter to the current word
						} else {
							split += convert;
							//System.out.println(split);
						}
					}
					 //Print the list(testing only) 
					/*
					System.out.println("BREAK");
					while (!list.isEmpty()) {
						System.out.println(list.pop());
					}
					*/
					//Gets the inputs for the replacement
					System.out.print("Please enter the word to be found(case sensitive): ");
					String find = input.next();
					System.out.print("Please enter the replacement word(case sensitive): ");
					String replace = input.next();
					//test is the string that will be tested with the input find word
					String test;
					//temp copies list
					StackList temp = list;
					//this will contain the words of the new sentence
					StackList newlist = new StackList();
					//loops through the list, while it's not empty
					while (!temp.isEmpty()) {
						//test if it empty again(needed?)
						if (temp.isEmpty())
							break;
						//sets test to the first temp value
						test = (String) temp.pop();
						//System.out.println("Testing " + test + " with " + find);
						//if the two words are the same, it is replaced by adding the replacement word to the new stack instead
						if (test.equals(find)) {
							//System.out.println("Added " + replace);
							newlist.push(replace);
						//if not the same, the original word is added to the new stack
						} else {
							//System.out.println("Added " + test);
							newlist.push(test);
						}
					}
					//display will hold the sentence
					String display = "";
					//takes the words out of the new stack and forms a sentence
					while (!newlist.isEmpty()) {
						//adds the word at the top of the stack to the display string
						display += newlist.pop();
						//adds a space inbetween the words
						if (!newlist.isEmpty())
							display += " ";
						//adds a period at the end of the sentence
						else
							display += ".";
					}
					//displays the sentence
					System.out.println("The new sentence: " + display);
				//2. McKeen's Test Case
				} else if (menu == 2) {
					/*
					 * ENTER CODE HERE
					 * 
					 * 
					 */
				}
		}while (menu != 3);
	}
}
