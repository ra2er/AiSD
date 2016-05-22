public class Node<T extends Comparable> {

  public Node<T> parent;
  public Node<T> leftChild;
  public Node<T> rightChild;
  public T value;

  public Node(T value, Node<T> parent) {
    this.parent = parent;
    this.value = value;
  }

  public Node(T value, Node<T> parent, Node<T> leftChild, Node<T> rightChild) {
    this.parent = parent;
    this.value = value;
  }

  public Node<T> setLeftChild(T value) {
    Node<T> node = new Node<T>(value, this);
    this.leftChild = node;
    return node;
  }

  public Node<T> setRightChild(T value) {
    Node<T> node = new Node<T>(value, this);
    this.rightChild = node;
    return node;
  }

  public int getLevel() {
    int level = 0;
    Node<T> parent = this.parent;
    while (parent != null) {
      level++;
      parent = parent.parent;
    }
    return level;
  }

  public void walkInOrder() {
    this.walkInOrder(this.leftChild);
    System.out.println(this);
    this.walkInOrder(this.rightChild);
  }

  public void walkInOrder(Node<T> node) {
    if (node != null) {
      node.walkInOrder(node.leftChild);
      System.out.println(node);
      node.walkInOrder(node.rightChild);
    }
  }

  public void walkPreOrder() {
    System.out.println(this);
    this.walkPreOrder(this.leftChild);
    this.walkPreOrder(this.rightChild);
  }

  public void walkPreOrder(Node<T> node) {
    if (node != null) {
      System.out.println(node);
      node.walkPreOrder(node.leftChild);
      node.walkPreOrder(node.rightChild);
    }
  }

  public void walkPostOrder() {
    this.walkPostOrder(this.leftChild);
    this.walkPostOrder(this.rightChild);
    System.out.println(this);
  }

  public void walkPostOrder(Node<T> node) {
    if (node != null) {
      node.walkPostOrder(node.leftChild);
      node.walkPostOrder(node.rightChild);
      System.out.println(node);
    }
  }

  public String toString() {
    return this.value.toString();
  }
}
