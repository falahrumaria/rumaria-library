package rumaria.library.ds;

public class BinaryTree<T> extends Tree<T> {

  private BinaryTree<T> leftChild;
  private BinaryTree<T> rightChild;

  public BinaryTree(T value) {
    super(value);
  }

  public BinaryTree(T value, BinaryTree<T> leftChild, BinaryTree<T> rightChild) {
    super(value, leftChild, rightChild);
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }

  public T getValue() {
    return this.root.getValue();
  }

  public BinaryTree<T> getLeftChild() {
    return this.leftChild;
  }

  public BinaryTree<T> getRightChild() {
    return this.rightChild;
  }
}
