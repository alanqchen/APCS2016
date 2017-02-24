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
		display = tree.preOrder();
		System.out.println(display);
		display = tree.inOrder();
		System.out.println(display);
		display = tree.postOrder();
		System.out.println(display);
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
			System.out.println("|5. Remove a node (Coming Soon)                             |");
			System.out.println("|6. Quit                                                    |");
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
			if (menu == 5)
				System.out.println("Removal coming soon!");
		} while (menu != 6);
	}

}
