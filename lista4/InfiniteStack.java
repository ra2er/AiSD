public class InfiniteStack implements Stack {

    public Element head;
    public int length;

    public void push(Object val) {
        Element e = new Element(val);
        if (this.head == null) {
            this.head = e;
        }
        else {
            e.previous = this.head;
            this.head = e;
        }
        this.length++;
    }

    public Element pop() {
        Element e = this.head;
        Element prev = e.previous;
        this.head = prev;
        this.length--;
        return e;
    }

    public Element peek() {
        return this.head;
    }

    public int size() {
        return this.length;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void clear() {
        this.head = null;
    }

    public String toString() {
        String s = "";
        Element e = this.head;
        while (e!=null) {
            s+= e.toString();
            e = e.previous;
        }
        return s;
    }
}
