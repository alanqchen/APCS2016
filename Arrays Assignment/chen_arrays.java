
/*Alan Chen	
 * chen_arrays
 * Program that has two methods that finds the max, min, and average of the array,
 * and another that lists the three highest numbers in a array
 */
import java.util.Scanner;


public class chen_arrays {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int menu=0;
		do {

			System.out.println("============Arrays============");
			System.out.println("1. max-min-avg");
			System.out.println("2. high-values");
			System.out.println("3. Quit");
			System.out.println("Please choose a selection");
			menu = input.nextInt();
				if (menu==1){
					maxminavg();
				}
				if (menu==2){
					highvalues();
				}
				if (menu==3){
					break;
				}
		}while (menu != 0);
		
	}
	//method for finding the max,min,average
	public static void maxminavg () {
		int [] numarray = new int [10];
		    //initialized variables
			int max = 0;
			int min = 0;
			//used to store the latest number the user entered
			int latestnum=0;
			//for storing the sum of the entered values
			int sum = 0;
			
		for (int i=0; i<10; i++) {

			System.out.println("Enter a number: #"+(i+1));
			latestnum = input.nextInt();
			sum += latestnum;
			//loop checks if the latest number the user entered is bigger than the current stored max
			if (max < latestnum) {
				max = latestnum;
			}
			//loop checks if the latest number the user entered is smaller than the current stored max
			if (min > latestnum) {
				min = latestnum;
			}
			//stores all the numbers the user entered into an array
			numarray[i] = latestnum;
		}
		//finds the average
		double avg = (double)sum/10;
		//displays max, min, and average
		System.out.println("The maximum value is: "+ max);
		System.out.println("The minimum value is: "+ min );
		System.out.println("The average of the values is: "+avg);
		System.out.println("The values you entered are: ");
		//displays numbers in the array
		for (int i = 0; i<10; i++) {
			System.out.println(numarray[i]+" ");
		}
	}
	//method the high values
	public static void highvalues () {
		int valuenum = 0;
		System.out.println("How many numbers do you want to enter?");
		valuenum = input.nextInt();
		int [] numarray = new int [valuenum];
		if (numarray.length < 3) {
			System.out.println("");
			return;
		}
		/*sets the maximums to a low number, to make sure there are numbers larger than it
		 * 
		 * initialized sequences ints
		 */
		int maximum1 = -100;
		int maximum2 = -100;
		int maximum3 = -100;
		int sequence1 = 0;
		int sequence2 = 0;
		int sequence3 = 0;
			//assigns numbers into each sequence in the array
			for (int i = 0; i < numarray.length; i++) {
				System.out.println("Enter number " +(i+1)+": ");
				numarray[i] = input.nextInt();
				
			}
			//displays the number entered
			System.out.println("Values:");
				for (int i=0; i < numarray.length; i++) {
					System.out.print(numarray[i]);
					//adds fancy commas
					if (i < (numarray.length-1))
					System.out.println(", ");
				}
			//case for 3 numbers
			if (valuenum == 3) {
				//checks if one of the values is bigger than maximum1
				for (int i = 0; i < numarray.length; i++){
					if (numarray[i] > maximum1) {
						//replaces with new max
						maximum1 = numarray[i];
						//records sequence number
						sequence1 = i;
					}
				}
				//checks if one of the values is bigger than maximum1 and less than maximum2
				for (int i = 0; i < numarray.length; i++) {
					if (numarray[i] > maximum2 && numarray[i] < maximum1) {
						//replaces with new max
						maximum2 = numarray[i];
						//records sequence number
						sequence2 = i;
					}
				}
				//checks if one of the values is bigger than maximum3 and less than maximum2
				for (int i = 0; i < numarray.length; i++) {
					if (numarray[i] > maximum3 && numarray[i] < maximum2) {
						//replaces with new max
						maximum3 = numarray[i];
						//records sequence number
						sequence3 = i;
					}
				}
				//checks if one of the values is bigger than maximum2 and maximum3
				for (int i=0; i < numarray.length; i++) {
					if (numarray[i] > maximum2 && numarray[i] > maximum3) {
						//replaces with new max
						maximum1 = numarray[i];
						//records sequence number
						sequence1 = i;
					}
				}
			}
		else {
			//checks if one of the values is bigger than maximum1
			for (int i = 0; i < numarray.length; i++) {
				if (numarray[i] > maximum1) {
					//replaces with new max
					maximum1 = numarray[i];
					//assigns the sequence number of the first max
					sequence1 = i;
				}
			}
			//checks if one of the values is less than maximum1 and bigger than maximum2
			for (int i = 0; i < numarray.length; i++) {
				if (numarray[i] > maximum2 && numarray[i] < maximum1) {
					//replaces with new max
					maximum2 = numarray[i];
					//assigns the sequence number of the second max
					sequence2 = i;
				}
			}
			//checks if one of the values is less than maximum1 and bigger than maximum3
			for (int i = 0; i < numarray.length; i++) {
				if (numarray[i] > maximum3 && numarray[i] < maximum2) {
					//replaces with new max
					maximum3 = numarray[i];
					//assigns the sequence number of the third max
					sequence3 = i;
				}
			}
			//checks if one of the values is bigger than maximum2 and maximum3
			for (int i = 0; i < numarray.length; i++) {
				if (numarray[i] > maximum2 && numarray[i] > maximum3) {
					//replaces with new max
					maximum1 = numarray[i];
					//assigns the sequence number of the first max
					sequence1 = i;
				}
			}
		}
		//adds one to the sequence number for users
		String displayseq1 = ""+(sequence1+1);	
		String displayseq2 = ""+(sequence2+1);
		String displayseq3 = ""+(sequence3+1);	
		//checks if any value is equal to maximum1
		for (int i = 0; i < numarray.length; i++) {
			if (numarray[sequence1] == numarray[i]){
				if (sequence1 != i) {
					//adds the sequence number of maximum1 to the string
					sequence1 +=(i+1);
				}
			}
		}
		//checks if any value is equal to maximum2
		for (int i = 0; i < numarray.length; i++) {
			if (numarray[sequence2] == numarray[i]){
				if (sequence2 != i) {
					//adds the sequence number of maximum2 to the string
					sequence2 +=(i+1);
				}
			}
		}
		//checks if any value is equal to maximum3
		for (int i = 0; i < numarray.length; i++) {
			if (numarray[sequence3] == numarray[i]){
				if (sequence3 != i) {
					//adds the sequence number of maximum3 to the string
					sequence3 += (i+1);
				}
			}
		}
		//displays the sequence numbers to the user. Spaces added for neatness
		System.out.println("\n"+"\n"+"There were "+numarray.length+" numbers entered."+"\n");
		System.out.println("The highest number is in sequence          #"+displayseq1);
		System.out.println("The second highest number is in sequence   #"+displayseq2);
		System.out.println("The third highest number is in sequence    #"+displayseq3);
	}
}
