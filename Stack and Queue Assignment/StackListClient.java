import java.util.Scanner;
public class StackListClient {
	private static Scanner input = new Scanner(System.in); 
	public static void main(String[] args) {
		int menu=0;
		do {
			System.out.println("#======= Stack List Client =======#");
			System.out.println("|1. Enter Sentence                |");
			System.out.println("|2. Find a word and replace it    |");
			System.out.println("|3. Display the sentence          |");
			System.out.println("|4. McKeen's test case            |");
			System.out.println("|5. Quit                          |");
			System.out.println("#=================================#");
			System.out.print("Please choose a selection: ");
			menu = input.nextInt();
				if (menu == 1) {
          
        } else if (menu == 2) {
          
        } else if (menu == 3) {
          
        } else if (menu == 4) {
          
        } else if (menu == 5) {
          
        }
      }while (menu != 8);
}
