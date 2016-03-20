public class OneWayListIterator implements Iterator {

    private OneWayList list;
    private Element currentObj;

    public OneWayListIterator(OneWayList list) {
        this.list = list;
    }

    public void previous() {
    }

    public void next() {
        Element current = this.currentObj;
        this.currentObj = current.next;
    }

    public void first() {
        this.currentObj = this.list.firstObj;
    }

    public void last() {
        this.currentObj = this.list.lastObj;
    }

    public boolean isDone() {
        return this.currentObj == null;
    }

    public Element current() {
        return this.currentObj;
    }

}
