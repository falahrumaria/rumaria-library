package rumaria.library;

import java.util.ArrayList;

public class Tree<T> {

	protected TreeNode<T> root;

	public Tree(T value) {
		if (value == null) {
			throw new IllegalArgumentException("cannot insert null value");
		}
		this.root = new TreeNode<T>(value);
	}

	public Tree(T value, Tree<T>... children) {
		this(value);
		for (Tree<T> child : children) {
			if (child != null)
				this.root.addChild(child.root);
		}
	}

	public TreeNode<T> getRoot() {
		return this.root;
	}

	public void printDFS(TreeNode<T> root, String space) {
		System.out.println(space + root.getValue());
		for (TreeNode<T> child : root.getChildren()) {
			printDFS(child, space + "   ");
		}
	}

	public void traverseDFS() {
		printDFS(this.root, "");
	}

	public static void main(String[] args) {
		// Tree<Integer> tree = new Tree<>(3,
		// new Tree<>(4,
		// new Tree<>(5),
		// new Tree<>(9,
		// new Tree<>(2))),
		// new Tree<>(7,
		// new Tree<>(0,
		// new Tree<>(1),
		// new Tree<>(11)),
		// new Tree<>(8)),
		// new Tree<>(6));
		// tree.traverseDFS();
		//
		// BinaryTree<Integer> bt = new BinaryTree<>(3,
		// new BinaryTree<>(4,
		// new BinaryTree<>(5),
		// new BinaryTree<>(9,
		// new BinaryTree<>(2),
		// null)),
		// new BinaryTree<>(7,
		// new BinaryTree<>(0,
		// new BinaryTree<>(1),
		// new BinaryTree<>(11)),
		// new BinaryTree<>(8)));
		// bt.traverseDFS();
	}
}
