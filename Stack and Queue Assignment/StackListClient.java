
import java.util.Scanner;
public class StackListClient {
	private static StackList list = new StackList();
	private static Scanner input = new Scanner(System.in); 
	public static void main(String[] args) {
		int menu=0;
		do {
			System.out.println("#======= Stack List Client =======#");
			System.out.println("|1. Enter Sentence                |");
			System.out.println("|2. McKeen's Test Case            |");
			System.out.println("|3. Quit                          |");
			System.out.println("#=================================#");
			System.out.print("Please choose a selection: ");
			menu = input.nextInt();
				if (menu == 1) {
					String convert;
					String split = "";
					System.out.print("Enter a sentence: ");
					//consumes line
					input.nextLine();
					String s1 = input.nextLine();
					//System.out.println(s1);
					for (int i = 0; i < s1.length(); i++) { 
						convert = String.valueOf(s1.charAt(i));
						if (convert.equals(" ") || convert.equals(".")) {
							list.push(split);
							split = "";
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
					System.out.print("Please enter the word to be found: ");
					String find = input.next();
					System.out.print("Please enter the replacement word: ");
					String replace = input.next();
					String test;
					StackList temp = list;
					StackList newlist = new StackList();
					while (!temp.isEmpty()) {
						if (temp.isEmpty())
							break;
						test = (String) temp.pop();
						//System.out.println("Testing " + test + " with " + find);
						if (test.equals(find)) {
							//System.out.println("Added " + replace);
							newlist.push(replace);
						} else {
							//System.out.println("Added " + test);
							newlist.push(test);
						}
					}
					String display = "";
					while (!newlist.isEmpty()) {
						display += newlist.pop();
						if (!newlist.isEmpty())
							display += " ";
						else
							display += ".";
					}
					System.out.println("The new sentence: " + display);
				} else if (menu == 2) {
          
				}
		}while (menu != 3);
	}
}
