public class Element {

    Object value;
    Element next;

    public Element(Object val) {
        this.next = null;
        this.value = val;
    }
}
