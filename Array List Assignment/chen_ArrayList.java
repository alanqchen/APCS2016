/*  ________  ___  ___  _______   ________      
 * |\   ____\|\  \|\  \|\  ___ \ |\   ___  \    
 * \ \  \___|\ \  \\\  \ \   __/|\ \  \\ \  \   
 *  \ \  \    \ \   __  \ \  \_|/_\ \  \\ \  \  
 *   \ \  \____\ \  \ \  \ \  \_|\ \ \  \\ \  \ 
 *    \ \_______\ \__\ \__\ \_______\ \__\\ \__\
 *     \|_______|\|__|\|__|\|_______|\|__| \|__|
 *     
 * chen_ArrayList.java                                             
 * Used to work with ArrayLists by adding Fractions, inserting Fractions, removing Fractions, etc.                                         
 * Also features sorting the list from smallest to largest
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class chen_ArrayList {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Fraction> flist = new ArrayList<Fraction>();
		int menu=0;
		do {
			System.out.println("#===================ArrayList===================#");
			System.out.println("|1. Display the list of fractions               |");
			System.out.println("|2. Add a fraction to the end of the list       |");
			System.out.println("|3. Insert a fraction at a specific location    |");
			System.out.println("|4. Remove a fraction from a specific location  |");
			System.out.println("|5. Remove a fraction by value                  |");
			System.out.println("|6. Replace a fraction at a specific location   |");
			System.out.println("|7. Display the list from smallest to largest   |");
			System.out.println("|8. Quit                                        |");
			System.out.println("#===============================================#");
			System.out.print("Please choose a selection: ");
			menu = input.nextInt();
				if (menu==1){
					if (flist.size() == 0) {
						System.out.println("The list is empty!");
						Pause();
					} else {
						System.out.println("The list currently contains:");
						for (int i = 0; i < flist.size(); i++) {
							System.out.println((i + 1) + ". " + flist.get(i));
						}
						Pause();
					}
				}
				else if (menu==2){
					System.out.print("Enter the numerator of the fraction to add: ");
			    	int num = input.nextInt();
			    	System.out.print("Enter the denominator of the fraction to add: ");
			    	int denom = input.nextInt();
			    	Fraction fraction = new Fraction(num,denom);
			    	flist.add(fraction);
			    	System.out.println("The fraction " + fraction.toString() + " has been successfully added to the end of the list.\n");
			    	Pause();
				}
				else if (menu==3){
					System.out.print("Enter the location where you would like to enter the fraction: ");
					int location = input.nextInt();
					if (location <= flist.size() + 1) {
						System.out.print("Enter the numerator of the fraction to add: ");
				    	int num = input.nextInt();
				    	System.out.print("Enter the denominator of the fraction to add: ");
				    	int denom = input.nextInt();
				    	Fraction fraction = new Fraction(num,denom);
				    	flist.add((location-1),fraction);
				    	System.out.println("The fraction " + fraction.toString() + " has been inserted in the list at location " + location);
				    	Pause();
					} else {
						System.out.println("Error: The location " + location + " is not avaliable!");
						Pause();
					}
				}
				else if (menu==4){
					System.out.print("Enter the location of the fraction to remove: ");
					int location = input.nextInt();
					System.out.println("The fraction " + flist.remove((location - 1)) + " was removed from location " + location);
					Pause();
				}
				else if (menu==5){
					int location = 0;
					boolean error = true;
					System.out.print("Enter the numerator of the fraction to remove: ");
			    	int num = input.nextInt();
			    	System.out.print("Enter the denominator of the fraction to remove: ");
			    	int denom = input.nextInt();
			    	Fraction fraction = new Fraction(num,denom);
			    	for (int i = 0; i < flist.size(); i++) {
			    		if (fraction.compareTo(flist.get(i)) == 0) {
			    			flist.remove(i);
			    			location = i + 1;
			    			error = false;
			    		} 
			    	}
			    	if (error == false) {
			    		System.out.println("The fraction " + fraction + " has been removed from location " + location);
			    		Pause();
			    	} else {
			    		System.out.println("The fraction " + fraction + " is not in the list");
			    		Pause();
			    	}
				}
				else if (menu==6){
					System.out.print("Enter the location of the fraction to replace: ");
					int location = input.nextInt();
					if (location <= flist.size()) {
						System.out.print("Enter the numerator of the new fraction: ");
				    	int num = input.nextInt();
				    	System.out.print("Enter the denominator of the new fraction: ");
				    	int denom = input.nextInt();
				    	Fraction fraction = new Fraction(num,denom);
				    	System.out.println("The fraction " + flist.set((location - 1),fraction) + "has been replaced with the fraction " + flist.get(location));
				    	Pause();
					} else {
						System.out.println("Error: The location " + location + " is not avaliable!");
						Pause();
					}
				}
				else if (menu==7){
					if (flist.size() == 0) {
						System.out.println("The list is empty!");
						Pause();
					} else {
						int num = 0;
						int denom = 1;
						ArrayList<Fraction> storage = new ArrayList<Fraction>();
				    	Fraction fraction = new Fraction(num,denom);
						ArrayList<Double> dsort = new ArrayList<Double>();
						for (int i = 0; i < flist.size(); i++) {
							storage.add(flist.get(i));
							fraction = flist.get(i);
							dsort.add(fraction.toDouble());
							//for debugging and error-trapping
//							System.out.println(storage);
//							System.out.println(dsort);
						}
						for (int i = 0; i < dsort.size(); i++) {
						    for (int j = dsort.size() - 1; j > i; j--) {
						        if (dsort.get(i) > dsort.get(j)) {
						        	Fraction tempsort = new Fraction();		
						        	tempsort = storage.get(i);
						            double temp = dsort.get(i);
						            dsort.set(i,dsort.get(j));
						            dsort.set(j,temp);
						            storage.set(i,storage.get(j));
						            storage.set(j,tempsort);
//						            System.out.println(storage);
//						            System.out.println(dsort);
						        }
						    }						    
						}
						System.out.println("The list sorted smallest to largest:");
						for (int k = 0; k < storage.size(); k++) {
							System.out.println((k + 1) + ". " + storage.get(k));				
						}
						Pause();
					}
				}
				else {
					break;
				}
			
		}while (menu != 0);

	}
	private static void Pause() {
		System.out.println("Press ENTER to continue...");
		try {
			System.in.read();
		} catch (IOException e) {
		}
	}

}
