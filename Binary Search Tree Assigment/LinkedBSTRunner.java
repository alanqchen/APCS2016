import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class BSTRunner {
    private static Scanner input = new Scanner(System.in); 
	public static void main(String[] args) {
		List display = new ArrayList();
		LinkedBST tree = new LinkedBST();
		/*
		tree.addNode(7);
		tree.addNode(4);
		tree.addNode(12);
		tree.addNode(9);
		tree.addNode(19);
		tree.addNode(2);
		tree.addNode(6);
		tree.addNode(3);
		tree.addNode(5);
		tree.addNode(8);
		tree.addNode(11);
		tree.addNode(20);
		tree.addNode(15);
		*/
    	int menu = 0;
		do {
			//display menu
			System.out.println("");
			System.out.println("#=================== Binary Search Tree ====================#");
			System.out.println("|1. Add a node                                              |");
			System.out.println("|2. Preorder Traversal                                      |");
			System.out.println("|3. Inorder Traversal                                       |");
			System.out.println("|4. Postorder Traversal                                     |");
			System.out.println("|5. Remove a node                                           |");
			System.out.println("|6. Search the tree for a node                              |");
			System.out.println("|7. Count the number of leafs in the tree                   |");
			System.out.println("|8. Find Path                                               |");
			System.out.println("|9. Hard-Coded Test Case                                    |");
			System.out.println("|10. Quit                                                   |");
			System.out.println("#===========================================================#");
			System.out.println("");
			System.out.print("Please choose a selection: ");
			menu = input.nextInt();
			if (menu == 1) {
				System.out.print("Please enter the value of the node: ");
				String s1 = input.next();
				boolean value = tree.addNode(s1);
				if (value == true)
					System.out.println("Added the node successfully! (true)");
				else
					System.out.println("Failed to add the node! (false)");
			}
			if (menu == 2)
				System.out.println("Preorder: " + tree.preOrder());
			if (menu == 3) 
				System.out.println("Inorder: " + tree.inOrder());
			if (menu == 4) 
				System.out.println("Postorder: " + tree.postOrder());
			if (menu == 5) {
				System.out.println("Please enter the value to remove");
				String s1 = input.next();
				boolean value = tree.removeNode(s1);
				if (value == true)
					System.out.println("Removed the node successfully! (true)");
				else
					System.out.println("Failed to remove the node! (false)");
			}
			if (menu == 6) {
				System.out.println("What is the value you want to find?");
				String s2 = input.next();
				boolean result = tree.search(s2);
				if (result == true)
					System.out.println("The value \"" + s2 + "\" was found in the tree!");
				else
					System.out.println("The value \"" + s2 + "\" was not found in the tree!");
			}
			if (menu == 7) {
				int result = tree.countLeaf();
				System.out.println("The tree has " + result + " leaf(s).");
			}
			if (menu == 8) {
				System.out.println("Please enter the node to go twoards");
				String s3 = input.next();
				int result = tree.findPath(s3);
				System.out.println("Number of branches crossed: " + result);
			}
			if (menu == 9) {
				tree.addNode("17");
				tree.addNode("14");
				tree.addNode("22");
				tree.addNode("19");
				tree.addNode("29");
				tree.addNode("12");
				tree.addNode("16");
				tree.addNode("13");
				tree.addNode("15");
				tree.addNode("18");
				tree.addNode("21");
				tree.addNode("30");
				tree.addNode("25");
				System.out.println("Added nodes");
			}
		} while (menu != 10);
	}

}
