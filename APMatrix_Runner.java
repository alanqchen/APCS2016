import java.util.Scanner;
public class APMatrix_Runner {
	private static APMatrix m1 = new APMatrix(1,1,false);
	private static Scanner input = new Scanner(System.in); 
	public static void main(String[] args) {
		int menu=0;
		do {
			System.out.println("#=======APMatrix Runner=======#");
			System.out.println("|1. Constructors              |");
			System.out.println("|2. Copy Matrix               |");
			System.out.println("|3. Accsessor methods         |");
			System.out.println("|4. toString                  |");
			System.out.println("|5. Multiply                  |");
			System.out.println("|6. Sum Cross                 |");
			System.out.println("|6. Remove Cross              |");
			System.out.println("|7. Quit                      |");
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
					} else {
						APMatrix m1 = new APMatrix(r,c,false);
						System.out.println("Succesfully created Matrix");
					}
				}
				if (menu == 2) {
					int[][] testMatrix = new int[3][5];
						for (int i = 0; i < testMatrix.length; i++) {
						    for (int j = 0; j < testMatrix[0].length; j++) {
						    	testMatrix[i][j] = (i * testMatrix[0].length) + j + 1;
						    }
						}
					APMatrix m1 = new APMatrix(testMatrix);		
				}
				if (menu ==3) {
					int getrow = m1.getRows();
					int getcol = m1.getColumns();
					System.out.println("Rows: " + getrow);
					System.out.println("Columns: " + getcol);
				}
				if (menu ==4) {
					m1.toString();
				}
				if (menu ==5) {
					APMatrix m1 = new APMatrix(2,3,true);
					APMatrix m2 = new APMatrix(3,5,true);
					APMatrix m3 = m1.matrixMultiply(m2);
					m3.toString();
				}
				if (menu == 6) {
					APMatrix m1 = new APMatrix(3,4,true);
					System.out.print("Enter row to sum: ");
					int getrow = input.nextInt();
					System.out.print("Enter column to sum: ");
					int getcol = input.nextInt();
					System.out.println("The sum of row " + getrow + " and column " + getcol + "is " +m1.sumCross(getrow, getcol));
				}
				if (menu == 7) {
					System.out.print("Enter row to remove: ");
					int getrow = input.nextInt();
					System.out.print("Enter column to remove: ");
					int getcol = input.nextInt();
					APMatrix newmatrix = m1.removeCross(getrow, getcol);
				}
		}while (menu != 8);
	}
}
