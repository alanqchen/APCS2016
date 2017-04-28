package alan.chen.compsci;
import java.util.LinkedList;
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
	public int[][] getDiagonals() {
		//result array
		int[][] result;
		//check if it's a square
		if(MainMatrix.length != MainMatrix[0].length) {
			System.out.println("ERROR: Matrix is not a square");
			result = new int[1][1];
			result[0][0] = 1738;
			return result;
		} else {
			result = new int[2][MainMatrix[0].length];
			//top-left to bottom-right diagonal
			for (int i = 0; i < MainMatrix.length; i++) {
				for (int j = 0; j < MainMatrix[0].length; j++) {
					if(i == j)
						result[0][j] = MainMatrix[i][j];
				}
			}
			//top-right to bottom-left diagonal
			int row = 0;
			int col = MainMatrix[0].length - 1;
			while(col >= 0) {
				result[1][row] = MainMatrix[row][col];
				col--;
				row++;
			}
			//return result
			return result;
		}
	}
	public int convertToBase10(int row, int col, int oldBase) {
		//int that store the result
		int result = 0;
		//checks if in bounds
		if (row >= MainMatrix.length || col >= MainMatrix[0].length) {
			return 420;
		}
		//gets value in matrix
		int num = MainMatrix[row][col];
		//creates stack
		LinkedList<Integer> stack = new LinkedList<Integer>();
		//splits the number into digits and places them into a stack
		while (num > 0) {
		    stack.push( num % 10 );
		    num = num / 10;
		}
		//moves digits to a array
		int[] array = new int[stack.size()];
		int index = 0;
		while (!stack.isEmpty()) {
		    array[index] = stack.pop();
		    index++;
		}
		//converts to base 10
		for (int a : array) {
			//checks if old base is possible
			if (a > oldBase) {
				return -1;
			}
		}
		//adds up the result
		for(int i = array.length - 1; i >= 0; i--)
		{
		    result += array[i] * Math.pow(oldBase, array.length-i-1); 
		}
		return result;
	}
	public void makeMeLaugh() {
		String jokeS = "";
		jokeS += "\n";
		jokeS += "SHORT JOKE";
		jokeS += "\n";
		jokeS += "===========================";
		jokeS += "\n";
		jokeS += "\n";
		jokeS += "\"[\"hip\",\"hip\"]\"";
		jokeS += "\n";
		jokeS += "(hip hip array!)";
		jokeS += "\n";
		System.out.println(jokeS);
		
		String jokeL = "";
		jokeL += "LONG JOKE";
		jokeL += "\n";
		jokeL += "===========================";
		jokeL += "\n";
		jokeL+= "\n";
		jokeL += "A man flying in a hot air balloon suddenly realizes he’s lost. He reduces height and spots a man down below. He lowers the balloon further and shouts to get directions, \"Excuse me, can you tell me where I am?\"";
		jokeL += "\n";
		jokeL += "\n";
		jokeL += "The man below says: \"Yes. You're in a hot air balloon, hovering 30 feet above this field.\"";
		jokeL += "\n";
		jokeL += "\n";
		jokeL += "\"You must work in Information Technology,\" says the balloonist.";
		jokeL += "\n";
		jokeL += "\n";
		jokeL += "\"I do\" replies the man. \"How did you know?\"";
		jokeL += "\n";
		jokeL += "\n";
		jokeL += "\"Well,\" says the balloonist, \"everything you have told me is technically correct, but it's of no use to anyone.\"";
		jokeL += "\n";
		jokeL += "\n";
		jokeL += "The man below replies, \"You must work in management.\"";
		jokeL += "\n";
		jokeL += "\n";
		jokeL += "\"I do,\" replies the balloonist, \"But how'd you know?\"";
		jokeL += "\n";
		jokeL += "\n";
		jokeL += "\"Well\", says the man, \"you don’t know where you are or where you’re going, but you expect me to be able to help. You’re in the same position you were before we met, but now it’s my fault.\"";
		jokeL += "\n";
		System.out.println(jokeL);
		System.out.println("\n***Disclamer: not original jokes***\n");
	}
}


