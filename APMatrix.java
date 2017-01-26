
import java.util.Scanner;
public class APMatrix {
	//Scanner for input
	private static Scanner input = new Scanner(System.in);
	//this is the Main Matrix (hence the name) that will be used for most of the work
	private int [] [] MainMatrix;
	//constructor
	public APMatrix(int R, int C, boolean enter) {
		if (R >= 0 && C >=0) {
			MainMatrix = new int [R] [C];
		}
		else {
			System.out.println("Invalid row and column values");
		}
		//loops through for the user to enter values
		if (enter == true) {
			for (int i = 0; i < MainMatrix.length; i++) {
				for (int j = 0; j < MainMatrix [0].length; j++) {
					System.out.print("Enter the number to enter into row " + (i + 1) + ", column " + (j + 1) + ": ");
					MainMatrix [i] [j] = input.nextInt();
				}
			}
		}
		else {
			//does nothing
		}
	}
	//copy a matrix the the main matrix (2d array->APMatrix)
	public APMatrix(int [] [] copyMe) {
		MainMatrix = new int [copyMe.length] [copyMe [0].length];
		for (int i = 0; i < MainMatrix.length; i++) {
			for (int j = 0; j < MainMatrix [0].length; j++) {
				MainMatrix [i] [j] = copyMe [i] [j];
			}
		}
	}
	//Displays the number of rows
	public int getRows() {
		return MainMatrix.length;
	}
	//Displays the number of columns
	public int getColumns() {
		if (MainMatrix.length > 0) {
			return MainMatrix [0].length;
		}
		else {
			return 0;
		}
	}
	//Displays the whole Matrix
	public String toString() {
		String s1 = "";
		for (int i = 0; i < MainMatrix.length; i++) {
			s1 += "|";
			for (int j = 0; j < MainMatrix [0].length; j++) {
				s1 += "\t" + MainMatrix [i] [j];
			}
			s1 += "\t|\n";
		}
		return s1;
	}
	//Multiplies the Matrix
	public APMatrix matrixMultiply(APMatrix m1) {
		//checks if the matrices can be multiplied
		if (this.MainMatrix [0].length == m1.MainMatrix.length) {
			//creates new matrix
			APMatrix result = new APMatrix(this.getRows(), m1.getColumns(), false);
			//loops through the matrices
			for (int i = 0; i < this.getRows(); i++) { 
			    for (int j = 0; j < m1.getColumns(); j++) { 
			        for (int k = 0; k < this.getColumns(); k++) { 
			        	//multiplies and add the value to the new matrix
			            result.MainMatrix [i] [j] += this.MainMatrix [i] [k] * m1.MainMatrix [k] [j];
			        }
			    }
			}
			return result;
		}
		else {
			//displays error message and returns null
			System.out.println("The matrices cannot be multiplied");
			return null;
		}
	}
	//Sums the specified cross in the Matrix
	public int sumCross(int r, int c) {
		int sum = 0;
		//error trapping
		if ((r-1) < this.getRows() && (r-1) >= 0) {
			if ((c-1) < this.getColumns() && (c-1) >= 0) {
				for (int i = 0; i < MainMatrix.length; i++) {
					if (i == (r-1)) {
						for (int j = 0; j < MainMatrix [i].length; j++) {
							sum += MainMatrix [i] [j];
						}
					}
				}
			}
			else {
				System.out.println("The sum cannot be calculated");
				sum = -1;
				return sum;
			}
			for  (int k = 0; k < MainMatrix.length; k++) {
				for (int l = 0; l <MainMatrix [k].length; l++) {
					if (l == (c-1)) {
						sum += MainMatrix [k] [l];
					}
				}
			}
			int cross = MainMatrix [r-1] [c-1];
			return (sum - cross);
		}
		else {
			System.out.println("The sum cannot be calculated");
			sum = -1;
			return sum;
		}
	}
	//Removes the specified cross in the Matrix
	public APMatrix removeCross(int r, int c) {
		//stores number of rows and columns
		 int rows = this.getRows();
	     int columns = this.getColumns();
	     //creates a smaller 2-d array
	     APMatrix finalmatrix = new APMatrix(rows-1,columns-1,false);
	     //stores row to be removed
	     int rr = r-1;
	     //stored column to be removed
	     int rc = c-1;
	     //acts as a counter
	     int p = 0;
	     //starts cycling through the rows of the 2-d array
	     for( int i = 0; i < rows; ++i) {
	     if ( i == rr)
	    	 //skips to the next iteration if true
	    	 continue;
	     	//acts as a counter
	        int q = 0;
	        //cycles through the columns
	        for( int j = 0; j < columns; ++j) {
	            if ( j == rc)
	            	//skips to the next iteration if true
	               continue;
	            //copy values to new matrix
	            finalmatrix.MainMatrix[p][q] = MainMatrix[i][j];
	            //adds to counter
	            ++q;
	        }
	        	//adds to counter
	            ++p;
	    }
	     //returns result
	    return finalmatrix;
	}
}
