public class SinkingStack implements Stack {

    public Element first;
    public Element head;
    public int length;
    public int capacity;

    public SinkingStack(int capacity) {
        this.capacity = capacity;
    }

    public void push(Object val) {
        Element e = new Element(val);
        if (this.head == null) {
            this.head = e;
            this.first = e;
            this.length++;
        }
        else {
            e.previous = this.head;
            this.head.next = e;
            this.head = e;
            if (this.length==this.capacity) {
                Element first = this.first;
                Element next = first.next;
                this.first = next;
                this.first.previous = null;
            } else {
                this.length++;
            }
        }
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
        this.first = null;
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
