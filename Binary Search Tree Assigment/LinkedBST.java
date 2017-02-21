import java.util.ArrayList;
import java.util.List;

/**
 * Alan Chen - APCompSci 2017
 * Project: Linked Lists
 * Date started: 2/20/2017
 * BONUS: Try 1 bonus?
 * TODO: Work on client file and part 2
 */
public class LinkedBST {
	private TreeNode root;
	public LinkedBST() {
		root = null;
	}
	public boolean addNode(Comparable obj) {
		if (root == null) {
			root = new TreeNode(obj);
			return true;
		}
		return add(obj, root);
	}
	private boolean add(Comparable obj, TreeNode node) {
		if (obj == node.getValue())
			return false;
		if (obj.compareTo(node.getValue()) < 0) {
			if (node.getLeft() == null) {
				node.setLeft(new TreeNode(obj));
				return true;
			}
			return add(obj, node.getLeft());
		}
		if (obj.compareTo(node.getValue()) > 0) {
			if (node.getRight() == null) {
				node.setRight(new TreeNode(obj));
				return true;
			}
			return add(obj, node.getRight());
		}
		return false;
	}
	public List preOrder() {
		List list1 = new ArrayList();
		preOrderTraverse(root, list1);
		return list1;
	}
	private void preOrderTraverse(TreeNode current, List list) {
		if (current != null) {
			list.add(current.getValue());
			preOrderTraverse(current.getLeft(),list);
			preOrderTraverse(current.getRight(),list);
		}
	}
}
