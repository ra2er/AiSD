public class Element {

    Object value;
    Element next;
    Element previous;

    public Element(Object val) {
        this.next = null;
        this.previous = null;
        this.value = val;
    }

    public String toString() {
        return String.format("%s", this.value.toString());
    }
}
