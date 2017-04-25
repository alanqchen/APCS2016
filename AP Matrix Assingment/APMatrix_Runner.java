package alan.chen.compsci;
import java.io.IOException;
import java.util.Scanner;
public class APMatrix_Runner {
	private static Scanner input = new Scanner(System.in); 
	public static void main(String[] args) {
		APMatrix current = new APMatrix(1,1,false);
		int menu=0;
		do {
			System.out.println("#=======APMatrix Runner=======#");
			System.out.println("|1. Constructors              |");
			System.out.println("|2. Copy Matrix               |");
			System.out.println("|3. Accsessor methods         |");
			System.out.println("|4. toString                  |");
			System.out.println("|5. Multiply                  |");
			System.out.println("|6. Sum Cross                 |");
			System.out.println("|7. Remove Cross              |");
			System.out.println("|8. Get Diagonals             |");
			System.out.println("|9. Convert to base           |");
			System.out.println("|10. Quit                     |");
			System.out.println("#=============================#");
			System.out.print("Please choose a selection: ");
			menu = input.nextInt();
				if (menu == 1) {
					System.out.print("# of Columns: ");
					int c = input.nextInt();
					System.out.print("# of Rows: ");
					int r = input.nextInt();
					System.out.print("Would you like to enter values? 1=y, 2=n: ");
					int choice = input.nextInt();
					if (choice == 1) {
						APMatrix m1 = new APMatrix(r,c,true);
						current = m1;
					} else {
						APMatrix m1 = new APMatrix(r,c,false);
						current = m1;
						System.out.println("Succesfully created Matrix");
					}
					Pause();
				}
				if (menu == 2) {
					int[][] testMatrix = {{1,2,3},{4,5,9}};
//						for (int i = 0; i < testMatrix.length; i++) {
//						    for (int j = 0; j < testMatrix[0].length; j++) {
//						    	testMatrix[i][j] = (i * testMatrix[0].length) + j + 1;
//						    }
//						}
					APMatrix m1 = new APMatrix(testMatrix);		
					System.out.println(m1.toString());
					Pause();
				}
				if (menu ==3) {
					int getrow = current.getRows();
					int getcol = current.getColumns();
					System.out.println("Rows: " + getrow);
					System.out.println("Columns: " + getcol);
					Pause();
				}
				if (menu ==4) {
					String print;
					print = current.toString();
					System.out.println(print);
					Pause();
				}
				if (menu ==5) {
					String print;
					int [] [] test1 = {{1,2,3},{4,5,6}};
					int [] [] test2 = {{7},{8},{9}};
					APMatrix m1 = new APMatrix(test1);
					APMatrix m2 = new APMatrix(test2);
					APMatrix m3 = m1.matrixMultiply(m2);
					if (m3 == null) {
					} else {
						print = m3.toString();
						System.out.println(print);	
					}
					Pause();
				}
				if (menu == 6) {
					int [] [] test4 = {{77,22,1,33},{5,3,10,4},{66,44,2,55}};
					APMatrix m1 = new APMatrix(test4);
					System.out.print("Enter row to sum: ");
					int getrow = input.nextInt();
					System.out.print("Enter column to sum: ");
					int getcol = input.nextInt();
					System.out.println("The sum of row " + getrow + " and column " + getcol + " is " +m1.sumCross(getrow, getcol));
					Pause();
				}
				if (menu == 7) {
					int [] [] cross = {{11,22,33,5,44,55},{22,33,44,6,55,66},{4,5,6,7,8,9},{33,44,55,8,66,77},{44,55,66,9,77,88}};
					System.out.print("Enter row to remove: ");
					int getrow = input.nextInt();
					System.out.print("Enter column to remove: ");
					int getcol = input.nextInt();
					APMatrix test3  = new APMatrix(cross);
					APMatrix newmatrix = test3.removeCross(getrow, getcol);
					System.out.println(newmatrix.toString());
					Pause();
				}
				if (menu == 8) {
					int [] [] cross = {{11,22,33,5,44},{22,33,44,6,55},{4,5,6,7,8},{33,44,55,8,66},{44,55,66,9,77}};
					APMatrix test1 = new APMatrix(cross);
					int[][] test2 = test1.getDiagonals();
					
					for(int i = 0; i < test2.length; i++) {
						for(int j = 0; j < test2[0].length; j++) {
							System.out.println(test2[i][j]);
						}
					}
					
					System.out.println(test2.toString());
				}
		}while (menu != 10);
	}
	private static void Pause() {
		System.out.println("Press ENTER to continue...");
		try {
			System.in.read();
		} catch (IOException e) {
		}
	}
}
