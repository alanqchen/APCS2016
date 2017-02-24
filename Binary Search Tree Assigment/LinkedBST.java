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
	public LinkedBST() {
		root = null;
	}
	public boolean addNode(Comparable obj) {
		if (root == null) {
			System.out.println("Setting root to: " + obj);
			root = new TreeNode(obj);
			return true;
		}
		return add(obj, root);
	}
	private boolean add(Comparable obj, TreeNode node) {
		if (obj == node.getValue())
			return false;
		if (obj.compareTo(node.getValue()) < 0) {
			System.out.println("Going left with: " + obj);
			if (node.getLeft() == null) {
				System.out.println("added: " + obj);
				node.setLeft(new TreeNode(obj));
				return true;
			}
			return add(obj, node.getLeft());
		}
		if (obj.compareTo(node.getValue()) > 0) {
			System.out.println("Going right with: " + obj);
			if (node.getRight() == null) {
				System.out.println("added: " + obj);
				node.setRight(new TreeNode(obj));
				return true;
			}
			return add(obj, node.getRight());
		}
		return false;
	}
	public List<Object> preOrder() {
		List<Object> list1 = new ArrayList<Object>();
		preOrderTraverse(root, list1);
		return list1;
	}
	private void preOrderTraverse(TreeNode current, List<Object> list) {
		if (current != null) {
			list.add(current.getValue());
			preOrderTraverse(current.getLeft(),list);
			preOrderTraverse(current.getRight(),list);
		}
	}
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
