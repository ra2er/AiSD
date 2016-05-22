import java.lang.*;

public class BinaryTree<T extends Comparable> {
  public Node<T> root;
  public final Comparator<T> comparator;
  public int level;

  public BinaryTree(Comparator<T> comparator) {
    this.comparator = comparator;
  }

  public void add(T value) {
    Node<T> n;
    if (this.root == null) {
      n = new Node<T>(value, null);
      this.root = n;
      this.level = n.getLevel();
    }
    else {
      Node<T> root = this.root;
      Node<T> next;
      if (this.compare(value, root.value) < 0) {
        next = this.root.leftChild;
      }
      else {
        next = this.root.rightChild;
      }
      while (next != null) {
        root = next;
        if (this.compare(value, root.value) < 0) {
          next = root.leftChild;
        }
        else {
          next = root.rightChild;
        }
      }
      if (this.compare(value, root.value) < 0) {
        n = root.setLeftChild(value);
      }
      else {
        n = root.setRightChild(value);
      }
      int currentLevel = n.getLevel();
      if (this.level < currentLevel) {
        this.level = currentLevel;
      }
    }
  }

  public Node<T> delete(T val, Node<T> root) {
    Node<T> node = this.search(val, root);
    if (node == null) {
      return node;
    }
    if (node.leftChild == null && node.rightChild == null) {
      Node<T> parent = node.parent;
      if (parent.leftChild == node) { parent.leftChild = null; }
      else { parent.rightChild = null; }
    }
    else if (node.leftChild != null && node.rightChild != null) {
      Node<T> next = this.successor(node.value);
      T tmp = next.value;
      next.value = node.value;
      node.value = tmp;
      this.delete(next.value, next);
    }
    else {
      Node<T> child = node.leftChild!=null?node.leftChild:node.rightChild;
      Node<T> parent = node.parent;
      if (parent.leftChild == node) { parent.leftChild = child; }
      else { parent.rightChild = child; }
    }
    return node;
  }

  public int compare(T first, T second) {
    if (this.comparator == null) {
      // natural comparator
      int cmp = first.compareTo(second);
      return cmp;
    }
    int cmp = this.comparator.compare(first, second);
    return cmp;
  }

  public Node<T> max() {
    if (this.root == null) throw new NullPointerException("Drzewo jest puste");
    Node<T> max = root;
    while(max.rightChild != null) {
      max = max.rightChild;
    }
    return max;
  }

  public Node<T> min() {
    if (this.root == null) throw new NullPointerException("Drzewo jest puste");
    Node<T> min = root;
    while(min.leftChild != null) {
      min = min.leftChild;
    }
    return min;
  }

  public Node<T> search(T val, Node<T> root) {
    if (root == null) {
      root = this.root;
    }
    if (root == null) throw new NullPointerException("Drzewo jest puste");
    Node<T> next = root;
    int cmp = this.compare(next.value, val);
    while (cmp != 0 && next != null) {
      next = cmp > 0?next.leftChild:next.rightChild;
      if (next == null) {
        break;
      }
      cmp = this.compare(next.value, val);
    }
    return next;
  }

  public Node<T> predecessor(T val) {
    Node<T> node = this.search(val, null);
    if (node != null) {
      if (node.leftChild != null) {
        return node.leftChild.rightChild==null?node.leftChild:node.leftChild.rightChild;
      } else {
        Node<T> parent = node.parent;
        Node<T> grandParent = parent.parent;
        if (grandParent.leftChild == parent) {
          return parent;
        }
        else {
          return grandParent;
        }
      }
    }
    return node;
  }

  public Node<T> successor(T val) {
    Node<T> node = this.search(val, null);
    if (node != null) {
      if (node.rightChild != null) {
        Node<T> next = node.rightChild.leftChild;
        while (next != null) {
          next = next.leftChild;
        }
        return next==null?(node.rightChild.leftChild==null?node.rightChild:node.rightChild.leftChild):next;
      }
      else {
        return node.parent.parent;
      }
    }
    return node;
  }

  public void walkInOrder() {
    Node<T> root = this.root;
    if (root != null) {
      root.walkInOrder();
    }
  }

  public void walkPreOrder() {
    Node<T> root = this.root;
    if (root != null) {
      root.walkPreOrder();
    }
  }

  public void walkPostOrder() {
    Node<T> root = this.root;
    if (root != null) {
      root.walkPostOrder();
    }
  }

  @SuppressWarnings("rawtypes")
  public String toString() {
    String s = "";
    int level = this.level;
    int treeMaxSize = 1;
    while (level != 0) {
      treeMaxSize += Math.pow(2, level);
      level--;
    }
    Node[] nodeList = new Node[treeMaxSize];
    Node<T> root = this.root;
    int n = 0;
    nodeList[0] = root;
    for (int i=0; i<nodeList.length; i++) {
      @SuppressWarnings("unchecked")
      Node<T> node = nodeList[i];
      if (node != null) {
        Node<T> leftChild = node.leftChild;;
        if (leftChild != null) {
          nodeList[2*i+1] = leftChild;
        }
        Node<T> rightChild = node.rightChild;
        if (rightChild != null) {
          nodeList[2*i+2] = rightChild;
        }
      }
    }
    int i = 0;
    int k = 0;
    int l = 0;
    int spacing;
    int count = nodeList.length;
    String space = String.format("%2s", " ");
    while(i <= this.level) {
      int levelCount = (int)Math.pow(2, i);
      spacing = (count - 1) / 2;
      for (int j=k; j<levelCount+l; j++) {
        Node node = nodeList[j];
        if (node != null) {
          String element = new String(new char[spacing]).replace("\0", space)
            + String.format("%2s", node.toString())
            + new String(new char[spacing]).replace("\0", space) + space;
          s += element;
        }
        else {
          String element = new String(new char[spacing]).replace("\0", space)
            + space + new String(new char[spacing]).replace("\0", space) + space;
          s += element;
        }
        k = j;
      }
      k++;
      l = k;
      i++;
      count = (count - 1) / 2;
      s += "\n";
    }
    return s;
  }
}
