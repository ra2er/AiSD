public class Element {

    Object value;
    Element next;

    public Element(Object val) {
        this.next = null;
        this.value = val;
    }

    public String toString() {
        return String.format("%s", this.value.toString());
    }
}
