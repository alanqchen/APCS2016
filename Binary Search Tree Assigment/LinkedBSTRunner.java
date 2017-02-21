import java.util.ArrayList;
import java.util.List;

public class LinkedBSTRunner {

	public static void main(String[] args) {
		List display = new ArrayList();
		LinkedBST tree = new LinkedBST();
		tree.addNode("C");
		tree.addNode("A");
		tree.addNode("D");
		tree.addNode("E");
		tree.addNode("B");
		display = tree.preOrder();
		System.out.println(display);
	}

}
