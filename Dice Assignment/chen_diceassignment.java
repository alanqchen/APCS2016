
/*Alan Chen	
 * chen_diceassignment
 * Program that gives the user the option to roll 2 dice for a certain number of times, roll a dice 10k time and see how many times
 * a number was rolled, play Craps, see the probability of winning and losing in different cases though simulating the game being
 * played 100k times, and finally an option for the user to terminate the program
 */
//imports scanner
import java.util.Scanner;
import java.text.DecimalFormat;
public class chen_diceassignment {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		//menu
		int menu=0;
		do {

			System.out.println("=============Dice=============");
			System.out.println("|1. Roll a dice              |");
			System.out.println("|2. Roll a dice 10,000 times |");
			System.out.println("|3. Game of Craps            |");
			System.out.println("|4. Craps Probability        |");
			System.out.println("|5. Quit                     |");
			System.out.println("==============================");
			System.out.println("Please choose a selection");
			menu = input.nextInt();
				if (menu==1){
					rolldice();
				}
				else if (menu==2){
					rolldice2();
				}
				else if (menu==3){
					craps();
				}
				else if (menu==4){
					probability();
				}
				else {
					break;
				}
		}while (menu != 0);
		
	}
	public static void rolldice() {
		//creates 2 6-sided die
		Dice dice1 = new Dice (6);
		Dice dice2 = new Dice (6);
		//initializes the variables for storing the die value
		int diceroll1 = 0;
		int diceroll2 = 0;
		//initializing the variable for storing the number of times the user wants to roll
		int count = 0;
		//initializing the variable for if the user wants to roll again.
		//assigning it to y  that the while loop will be run at least once 
		char choice = 'y';
		while (choice != 'n') {
			//asks the user how many times they want the dice to be rolled
			System.out.println("How many times do you want the dice to be rolled?");
			//records the number of times the user wants to roll the dice
			count = input.nextInt();
			for (int i =0; i < count; i++){
				diceroll1 = dice1.roll();
				diceroll2 = dice2.roll();
				//displays the dices values, and the sum or each roll
				System.out.println("Roll #" + (i+1) + ":\t" + diceroll1 + " + " + diceroll2 + " = " + (diceroll1 + diceroll2));
				System.out.println("Press Enter to continue . . .");
  				Scanner scanner = new Scanner(System.in);
 				scanner.nextLine();
			}
			//prompts the user if they want to roll again
			System.out.println("Would you like to roll again? (y/n)\t");
			choice = input.next().charAt(0);
		}
	}
	public static void rolldice2() {
		//tells that there are 6 sides to the die
		Dice dice1 = new Dice(6);
		int roll = 0;
		//this will act as a "counter" for the times each side is rolled
		int[] dicearray = new int [6];
		for (int i = 0; i < 10000; i++) {
			roll = dice1.roll();
			//if the dice rolls a 1, add 1 to the count
			if (roll ==1) {
				dicearray[0]++;
			}
			//if the dice rolls a 2, add 1 to the count
			else if (roll == 2) {
				dicearray[1]++;
			//if the dice rolls a 3, add 1 to the count
			}
			else if (roll == 3) {
				dicearray[2]++;
			}
			//if the dice rolls a 4, add 1 to the count
			else if (roll == 4) {
				dicearray[3]++;
			}
			//if the dice rolls a 5, add 1 to the count
			else if (roll == 5) {
				dicearray[4]++;
			}
			//if the dice doesn't roll a 1,2,3,4, or 5, then it must be six.
			else {
				dicearray[5]++;
			}
		}
		for (int i = 0; i < dicearray.length; i++) {
			System.out.println("Number of times " + (i+1) + " was rolled: \t" + dicearray[i]);
		}
	}
	public static void craps() {
		//choice is for checking if the player would like to play again
		//assigning it to 'y' ensures that it will run at least once
		char choice = 'y';
		Dice dice1 = new Dice(6);
		Dice dice2 = new Dice(6);
		//plays the game when the player types "y" for if they want to play again.
		while (choice == 'y') {
			//initializes the variables for the point, and dice values
			int point = 0;
			int diceroll1 = 0;
			int diceroll2 = 0;
			int diceroll3 = 0;
			int diceroll4 = 0;
			//rolls the die
			diceroll1 = dice1.roll();
			diceroll2 = dice2.roll();
			//assigns the point value as the sum of the rolls
			point = (diceroll1 + diceroll2);
			//Displays to the user what they rolled
			System.out.println("Player rolled a " + diceroll1 + "+" + diceroll2 + "= " + (diceroll1 + diceroll2));
			//checks to see if they rolled a 7 or a 11 for an instant win
			if ((diceroll1 + diceroll2) == 7 || (diceroll1 + diceroll2) == 11) {
				System.out.println("Player wins!");
				System.out.println("Play again? (y/n)\t");
				choice = input.next().charAt(0);
			}
			//then checks if the player rolled a 2,3, or 12 for an instant lose.
			else if ((diceroll1 + diceroll2) == 2 || (diceroll1 + diceroll2) == 3 || (diceroll1 + diceroll2) == 12) {
				System.out.println("Player loses. :(");
				System.out.println("Play again? (y/n)\t");
				choice = input.next().charAt(0);
			}
			//if the player did not roll to any of the previous conditions, the game continues
			else {
				//The players previous roll sum is displayed as the point
				System.out.println("Point is " + point);
				//keeps rolling until point is made from the sums
				while (point != (diceroll3+diceroll4)) {
					diceroll3 = dice1.roll();
					diceroll4 = dice2.roll();
					//displays the users roll
					System.out.println("Player rolled a " + diceroll3 + "+" + diceroll4 + "= " + (diceroll3 + diceroll4));
					//if the point is made, it then displays if the user wants to play again, and then exits the loop.
					if (point == (diceroll3 + diceroll4)) {
						System.out.println("Player wins!");
						System.out.println("Play again? (y/n)\t");
						choice = input.next().charAt(0);
						//exits the loop
						break;
					}
					//if the player's roll equals 7, then they lose instantly(after the first set of rolls)
					if ((diceroll3 + diceroll4) == 7) {
						//displays that the playe loses, and asks if they want to play again.
						System.out.println("Player loses. :(");
						System.out.println("Play again? (y/n)\t");
						choice = input.next().charAt(0);
						//exits the loop
						break;
					}
				}
			}
		}
	}
	public static void probability() {
		//declares the two sided sided dice
		Dice dice1 = new Dice(6);
		Dice dice2 = new Dice(6);
		//initializes the variables to store the value of the dice
		int diceroll1 = 0;
		int diceroll2 = 0;
		int diceroll3 = 0;
		int diceroll4 = 0;
		int point = 0;
		//initializes the doubles for storing the times each case is reached, and then displaying the probability of each case
		double wins = 0;
		double firstwins = 0;
		double pointwins = 0;
		double loses = 0;
		double firstloses = 0;
		double pointloses = 0;
		//starts playing the game of craps 100,000 times
		for (int i = 0; i < 100000; i++) {
			diceroll1 = dice1.roll();
			diceroll2 = dice2.roll();
			//assigns the point value
			point = (diceroll1 + diceroll2);
			//if rolled a 7 or 11, on the first roll, then add 1 to the "first roll wins" count and overall win count
			if ((diceroll1 + diceroll2) == 7 || (diceroll1 + diceroll2) == 11) {
				firstwins++;
				wins++;
			}
			//if rolled a 2, 3, or 12 on the first roll, then  add 1 to the "first roll loses" and overall loses count 
			else if ((diceroll1 + diceroll2) == 2 || (diceroll1 + diceroll2) == 3 || (diceroll1 + diceroll2) == 12) {
				firstloses++;
				loses++;
			}
			//if the game did not meet any of the above conditions, continue playing
			else {
				while (point != (diceroll3+diceroll4)) {
					diceroll3 = dice1.roll();
					diceroll4 = dice2.roll();
					//if the roll equals the point, add 1 to the "wins by point" and overall wins count
					if (point == (diceroll3 + diceroll4)) {
						pointwins++;
						wins++;
						//prevents adding 1 to the loses
						break;
					//if the roll equals 7, then add 1 to the "loses by not reaching the point" and overall loses count
					}
					if ((diceroll3 + diceroll4) == 7) {
						pointloses++;
						loses++;
						//prevents it going through the other loop
						break;
					}
				}
			}
		}
		//for formatting to show only 4 decimal points
		DecimalFormat decimal = new DecimalFormat("#.####");
		//displays the probabilities to the user
		System.out.println("Probability of winning overall is " + (decimal.format(wins/100000)));
		System.out.println("Probability of losing overall is " + (decimal.format(loses/100000)));
		System.out.println("The probability of winning on the first roll is " + (decimal.format(firstwins/100000)));
		System.out.println("The probability of losing on the first roll is " + (decimal.format(firstloses/100000)));
		System.out.println("The probability of winning by rolling a point is " + (decimal.format(pointwins/100000)));
		System.out.println("The probability of losing by not rolling a point is " + (decimal.format(pointloses/100000)));
	}
}
