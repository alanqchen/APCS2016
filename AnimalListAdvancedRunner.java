import java.util.Scanner;

public class AnimalListAdvancedRunner {
	static AnimalList list = new AnimalList();
	private static Scanner input = new Scanner(System.in); 
	public static void main(String[] args) {
		int menu=0;
		do {
			System.out.println("");
			System.out.println("#============== Animal List AR ===============#");
			System.out.println("|1. Add animal to list                        |");
			System.out.println("|2. Remove animal from list                   |");
			System.out.println("|3. Display the list                          |");
			System.out.println("|4. Display number of successful adds/removes |");
			System.out.println("|5. Quit                                      |");
			System.out.println("#=============================================#");
			System.out.println("");
			System.out.print("Please choose a selection: ");
			menu = input.nextInt();
				if (menu == 1) {
					String in;
					System.out.print("Please enter the animal you would like to add: ");
					in = input.next();
					list.addAnimal(in);
				}
				if (menu == 2) {
					boolean result;
					String in;
					System.out.print("Please enter the animal you would like to remove(case-sensitive): ");
					in = input.next();
					result = list.removeAnimal(in);
					if (result == false)
						System.out.println("The animal \"" + in + "\" was not found, and could not be removed.");
				}
				if (menu == 3) {
					list.displayList();
				}
				if (menu == 4) {
					System.out.println("Number of successful additions and removals: " + list.getnumAddRemove());
				}
		} while (menu != 5);
	}

}
