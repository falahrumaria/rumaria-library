package rumaria.library.data_structure;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {

	private T value;
	private boolean hasParent;
	private List<TreeNode<T>> children;
	
	public TreeNode(T value) {
		if (value == null) {
			throw new IllegalArgumentException("cannot insert null value");
		}
		this.value = value;
		this.children = new ArrayList<TreeNode<T>>();
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public boolean isHasParent() {
		return hasParent;
	}

	public void setHasParent(boolean hasParent) {
		this.hasParent = hasParent;
	}

	public List<TreeNode<T>> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode<T>> children) {
		this.children = children;
	}

	public int getChildrenCount() {
		return this.children.size();
	}
	
	public void addChild(TreeNode<T> child) {
		if (child == null) {
			throw new IllegalArgumentException("cannot insert null value!");
		}
		if (child.hasParent) {
			throw new IllegalArgumentException("the node already has a parent!");
		}
		this.children.add(child);
		child.hasParent = true;
	}
	
	public TreeNode<T> getChild(int index) {
		return this.children.get(index);
	}
}
