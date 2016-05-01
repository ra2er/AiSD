import java.util.*;

public class StackPriorityQueue<T extends Comparable> {

    public LinkedList<T> list;
    public Comparator<T> comparator;

    int compares = 0;
    int swaps = 0;

    // l: 2n+1
    // r: 2n+2

    public StackPriorityQueue(Comparator<T> comparator) {
        this.comparator = comparator;
        this.list = new LinkedList<T>();
    }

    protected int compare(T first, T second) {
        if (this.comparator == null) {
            // natural comparator
            int cmp = first.compareTo(second);
            this.compares++;
            return cmp;
        }
        int cmp = this.comparator.compare(first, second);
        this.compares++;
        return cmp;
    }

    public void enqueue(T object) {
        this.list.add(object);
        this.swim(object);
    }

    public T dequeue() {
        T root = this.list.getFirst();
        T last = this.list.removeLast();
        if (last == root) {
            return root;
        }
        this.list.set(0, last);
        this.sink(last);
        return root;
    }

    public ListIterator<T> iterator() {
        return this.list.listIterator();
    }

    public void swim(T object) {
        int index = this.list.indexOf(object);
        boolean isRoot = index == 0;
        boolean isLeftChild = !isRoot && index % 2 == 1;
        boolean isRightChild = !isRoot && index % 2 == 0;
        int parentIndex = -1;
        if (isLeftChild) {
            parentIndex = (index-1)/2;
        } else {
            parentIndex = (index-2)/2;
        }
        if (parentIndex != -1) {
            T parent = this.list.get(parentIndex);
            if(this.compare(object, parent) > 0 && !isRoot) {
                T tmp = parent;
                this.list.set(parentIndex, object);
                this.list.set(index, tmp);
                this.swaps++;
                this.swim(object);
            }
        }
    }

    public void sink(T object) {
        while(this.leftChild(object) != null) {
            int index = this.list.indexOf(object);
            int n = index;
            T left = this.leftChild(object);
            if (this.compare(object, this.leftChild(object)) < 0) {
                n = this.list.indexOf(left);
                T right = this.rightChild(object);
                if (right != null) {
                    if (this.compare(left, right) < 0) {
                        n = this.list.indexOf(right);
                    }
                }
            }
            if (n == index) {
                break;
            }
            T tmp = this.list.get(n);
            this.list.set(n, object);
            this.list.set(index, tmp);
            this.swaps++;
            object = this.list.get(n);
        }
    }

    public T leftChild(T object) {
        int index = this.list.indexOf(object);
        if (index != -1) {
            try {
                return this.list.get(index * 2 + 1);
            }
            catch (IndexOutOfBoundsException e) {
                return null;
            }
        }
        return null;
    }

    public T rightChild(T object) {
        int index = this.list.indexOf(object);
        if (index != -1) {
            try {
                return this.list.get(index * 2 + 2);
            }
            catch (IndexOutOfBoundsException e) {
                return null;
            }
        }
        return null;
    }
}
