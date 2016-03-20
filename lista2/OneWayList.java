import java.lang.*;

class OneWayList implements List {

    public Element list;
    public int length;
    public Element firstObj;
    public Element lastObj;

    public OneWayListIterator iterator() {
        return new OneWayListIterator(this);
    }

    public int size() {
        return this.length;
    }

    public void insert(int index, Object obj) {
        if (this.list == null || this.length <= index) {
            this.add(obj);
        } else {
            Element newElement = new Element(obj);
            OneWayListIterator iter = this.iterator();
            int i = 0;
            for (iter.first(); i < index - 1; iter.next()) {
                i += 1;
                continue;
            }
            Element current = iter.current();
            //System.out.println((Integer)current.value);
            iter.next();
            current.next = newElement;
            Element next = iter.current();
            newElement.next = next;
            this.length += 1;
        }
    }

    public void add(Object obj) {
        if (this.list == null) {
            Element newElement = new Element(obj);
            this.list = newElement;
            this.firstObj = newElement;
            this.lastObj = newElement;
            this.length = 1;
        }
        else {
            Element newElement = new Element(obj);
            this.lastObj.next = newElement;
            this.lastObj = newElement;
            this.length += 1;
        }
    }

    public Element get(int index) throws IndexOutOfBoundsException {
        if (this.list == null || this.length <= index) {
            throw new IndexOutOfBoundsException();
        } else {
            OneWayListIterator iter = this.iterator();
            int i = 0;
            for (iter.first(); i == index; iter.next()) {
                i += 1;
                continue;
            }
            Element current = iter.current();
            return current;
        }
    }

    public Element set(int index, Object obj) throws IndexOutOfBoundsException {
        if (this.list == null || this.length <= index) {
            throw new IndexOutOfBoundsException();
        } else {
            OneWayListIterator iter = this.iterator();
            int i = 0;
            for (iter.first(); i < index - 1; iter.next()) {
                i += 1;
                continue;
            }
            Element previous = iter.current(); // n -1
            Element newElement = new Element(obj); // nowy
            iter.next();
            Element current = iter.current();  // do zmiany //
            previous.next = newElement;
            iter.next();
            Element next = iter.current();  // następny
            newElement.next = next;
            return current;
        }
    }

    public Element delete(Object obj) throws NullPointerException {
        OneWayListIterator iter = this.iterator();
        iter.first();
        Element first = iter.current();
        iter.next();
        Element second = iter.current();
        if (first.value.equals(obj)) {
            this.firstObj = second;
            return first;
        }
        while (!iter.isDone()) {
            Element previous = iter.current(); // drugi element
            iter.next();
            Element current = iter.current();
            if (current.value.equals(obj)) {
                iter.next();
                Element next = iter.current();
                previous.next = next;
                if (current.next == null) {
                    this.lastObj = current;
                }
                return current;
            }
        }
        throw new NullPointerException();
    }

    public String toString() {
        String s = "";
        OneWayListIterator iter = this.iterator();
        for (iter.first(); !iter.isDone(); iter.next()) {
            Element o = iter.current();
            s += String.format("%s%n", o.value.toString());
        }
        return s;
    }

}
