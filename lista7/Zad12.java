import java.util.*;

public class Zad12 {
  public static void main(String[] args) {
    BinaryTree<Number> tree = new BinaryTree<>(new NumberComparator());
    Number zero = new Number(0);
    Number one = new Number(1);
    Number five = new Number(5);
    Number six = new Number(6);
    Number ten = new Number(10);
    Number eleven = new Number(11);
    Number twelve = new Number(12);
    Number fifteen = new Number(15);
    tree.add(ten);
    tree.add(five);
    tree.add(six);
    tree.add(fifteen);
    tree.add(eleven);
    tree.add(twelve);
    tree.add(one);

    // test
    System.out.println(tree.root.value.equals(ten));
    System.out.println(tree.root.leftChild.value.equals(five));
    System.out.println(tree.root.rightChild.value.equals(fifteen));
    System.out.println(tree.root.leftChild.rightChild.value.equals(six));
    System.out.println(tree.root.leftChild.leftChild.value.equals(one));
    System.out.println(tree.root.rightChild.leftChild.value.equals(eleven));
    System.out.println(tree.root.rightChild.rightChild == null);
    System.out.println(tree.root.rightChild.leftChild.leftChild == null);
    System.out.println(tree.root.rightChild.leftChild.rightChild.value.equals(twelve));

    System.out.println(tree);

    System.out.println(tree.max());
    System.out.println(tree.min());

    System.out.println(tree.search(new Number(10), null));
    System.out.println(tree.search(new Number(1), null));
    System.out.println(tree.search(new Number(5), null));
    System.out.println(tree.search(new Number(99), null));

    System.out.println("Predecessors");
    System.out.println(String.format("5 -> %s", tree.predecessor(new Number(5)))); // 1
    System.out.println(String.format("6 -> %s", tree.predecessor(new Number(6)))); // 5
    System.out.println(String.format("11 -> %s", tree.predecessor(new Number(11)))); // 11


    System.out.println("Successors");
    System.out.println(String.format("5 -> %s", tree.successor(new Number(5)))); // 6
    System.out.println(String.format("6 -> %s", tree.successor(new Number(6)))); // 10
    System.out.println(String.format("10 -> %s", tree.successor(new Number(10)))); // 11
    System.out.println(String.format("12 -> %s", tree.successor(new Number(12)))); // 15

    System.out.println("Walk in order");
    tree.walkInOrder();
    System.out.println("Walk pre order");
    tree.walkPreOrder();
    System.out.println("Walk post order");
    tree.walkPostOrder();

    tree.delete(new Number(10), null);
    System.out.println(tree);
    tree.delete(new Number(1), null);
    System.out.println(tree);
  }
}
