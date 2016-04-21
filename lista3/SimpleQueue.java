public class SimpleQueue implements Queue {

    public int length = 0;
    public Element first;
    public Element last;

    public int size() {
        return this.length;
    }

    public void enqueue(Object value) {
        Element newElement = new Element(value);
        if (this.first == null) {
            this.first = newElement;
            this.last = newElement;
        }
        else {
            this.last.next = newElement;
            this.last = newElement;
        }
        this.length += 1;
    }

    public Object dequeue() throws EmptyQueueException {
        Element e = this.first;
        if (e == null) {
            throw new EmptyQueueException();
        }
        Element next = e.next;
        this.first = next;
        this.length -= 1;
        return e;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public void clear() {
        Element e = this.first;
        if (e == null) {
            return;
        }
        while (e.next != null) {
            Element next = e.next;
            e.next = null;
            e = next;
        }
    }
}
