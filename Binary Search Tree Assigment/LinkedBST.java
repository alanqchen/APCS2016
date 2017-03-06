import java.util.ArrayList;
import java.util.List;

/**
 * Alan Chen - APCompSci 2017
 * Project: Linked Lists
 * Date started: 2/20/2017
 * BONUS: Try 1 bonus?
 * TODO: Document code!
 */
public class LinkedBST {
	private TreeNode root;
	/* Constructor */
	public LinkedBST() {
		root = null;
	}
	/* addNode */
	/* Calls the recursive add method
	 * Also checks if the root is null (tree is empty), and sets the value as the root if so.
	 */
	public boolean addNode(Comparable obj) {
		//checks if tree is empty
		if (root == null) {
			//System.out.println("Setting root to: " + obj);
			//sets root to a new node with the value
			root = new TreeNode(obj);
			return true;
		}
		//calls the recursive method if the tree is not empty
		return add(obj, root);
	}
	/* add */
	/* Recursive method that adds the node to the tree
	 * Compares the value to the current node's value and moves left or right.
	 * if the next left/right is empty, sets the next left/right value accordingly
	 */
	private boolean add(Comparable obj, TreeNode node) {
		//checks if the node value is equal to the value t be added (if it's already in the tree)
		if (obj == node.getValue())
			return false;
		//checks if the should be to the left of the node
		if (obj.compareTo(node.getValue()) < 0) {
			//System.out.println("Going left with: " + obj);
			//checks if the node to the left is null
			if (node.getLeft() == null) {
				//System.out.println("added: " + obj);
				//Adds the node to the tree
				node.setLeft(new TreeNode(obj));
				return true;
			}
			//calls itself going left
			return add(obj, node.getLeft());
		}
		//checks if the value should be to the right of the node
		if (obj.compareTo(node.getValue()) > 0) {
			//System.out.println("Going right with: " + obj);
			//checks if the node to the right is null
			if (node.getRight() == null) {
				//System.out.println("added: " + obj);
				//Adds the node to the tree
				node.setRight(new TreeNode(obj));
				return true;
			}
			//calls itself going right
			return add(obj, node.getRight());
		}
		return false;
	}
	public boolean removeNode(Comparable find) {
		//if tree is empty
		if (root == null)
			return false;
		//calls private method
		TreeNode test = delete(root, find);
		if (test == null)
			return false;
		else
			return true;
	}
	private TreeNode delete(TreeNode current, Comparable find) {
	    if (current == null) 
	    	return null;
	    //if found the node to delete
	    if (find.equals(current.getValue())) {
	       //tests if removing node(and empty left & right)
		   if (current.getLeft() == null && current.getRight() == null && current == root) {
			   root = null;
		   	   return current;
		   }
		   //tests if leaf
	       if (current.getLeft() == null && current.getRight() == null) 
	    	   return null;
	       //test cases for 1 child
	       if (current.getLeft() == null) 
	    	   return current.getRight();
	       if (current.getRight() == null) 
	    	   return current.getLeft();
	       //Case for 2 children
	       //finds smallest value of the right subtree
	       TreeNode temp = findSmall(current.getRight());
	       //copy value
	       current.setValue(temp.getValue());
	       //delete temp
	       current.setRight(delete(current.getRight(), (Comparable) temp.getValue()) );
	       return current;
	       
	    }
	    //if to check left
	    else if (find.compareTo(current.getValue()) < 0) {
	        current.setLeft(delete(current.getLeft(), find) );
	        return current;
	    }
	    //check right
	    else {
	        current.setRight(delete(current.getRight(), find) );
	        return current;
	    }
	}
	//finds smallest value of the right subtree
	private TreeNode findSmall(TreeNode current) {
	    if (current.getLeft() == null) 
	    	return current;
	    else 
	    	return findSmall(current.getLeft());
	}
	public boolean search(Comparable Key) {
		boolean result = search(root, Key);
		return result;
	}
	private boolean search(TreeNode current, Comparable Key) {
		if (current == null) 
			return false;
		if (Key.equals(current.getValue()))
			return true;
		if (Key.compareTo(current.getValue()) < 0) 
			return search(current.getLeft(), Key);
		else
			return search(current.getRight(), Key);
	}
	public int countLeaf() {
		int count = countLeaf(root);
		return count;
	}
	private int countLeaf(TreeNode current) {
		//if the node is null, returns 0
		if (current == null)
			return 0;
		else {
			//if it's a leaf, returns 1
			if (current.getLeft() == null && current.getRight() == null)
				return 1;
			//else, looks both left and right for leaves
			else
				return countLeaf(current.getLeft()) + countLeaf(current.getRight());
		}
	}
	public int findPath(Comparable find) {
		//calls the private method
		int result = findPath(root, find);
		//if it's negative, returns -1
		if (result < 0)
			return -1;
		//else, return result
		else
			return result;
	}
	private int findPath(TreeNode current, Comparable find) {
		//test if the node is found
		if (find.equals(current.getValue())) {
			return 0;
		} else if (find.compareTo(current.getValue()) < 0) {
			if (current.getLeft() != null) //tests if in tree
				return 1 + findPath(current.getLeft(), find); //adds 1
			else // node is not in tree
				return -99999;
		} else {
			if (current.getRight() != null) //tests if in tree
				return 1 + findPath(current.getRight(), find); //adds 1
			else //node is not in tree
				return -99999;
		}
	}
	/* preOrder */
	/* Calls the recusive method
	 * Also creats the ArrayList that will store the values
	 */
	public List<Object> preOrder() {
		List<Object> list1 = new ArrayList<Object>();
		preOrderTraverse(root, list1);
		return list1;
	}
	/* Adds to the list values in order of the traversal
	 * 
	 */
	private void preOrderTraverse(TreeNode current, List<Object> list) {
		if (current != null) {
			list.add(current.getValue());
			preOrderTraverse(current.getLeft(),list);
			preOrderTraverse(current.getRight(),list);
		}
	}
	/* inOrder */
	/* Calls the recusive method
	 * Also creats the ArrayList that will store the values
	 */
	public List<Object> inOrder() {
		List<Object> list1 = new ArrayList<Object>();
		inOrderTraverse(root, list1);
		return list1;
	}
	private void inOrderTraverse(TreeNode current, List<Object> list) {
		if (current != null) {
			inOrderTraverse(current.getLeft(),list);
			list.add(current.getValue());
			inOrderTraverse(current.getRight(),list);
		}
	}
	/* postOrder */
	/* Calls the recusive method
	 * Also creats the ArrayList that will store the values
	 */
	public List<Object> postOrder() {
		List<Object> list1 = new ArrayList<Object>();
		postOrderTraverse(root, list1);
		return list1;
	}
	private void postOrderTraverse(TreeNode current, List<Object> list) {
		if (current != null) {
			postOrderTraverse(current.getLeft(),list);
			postOrderTraverse(current.getRight(),list);
			list.add(current.getValue());
		}
	}
}
