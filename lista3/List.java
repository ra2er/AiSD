import java.lang.*;

public interface List {

    public int size();
    public void insert(int index, Object obj);
    public void add(Object obj);
    public Object set(int index, Object obj) throws IndexOutOfBoundsException;
    public Object get(int index) throws IndexOutOfBoundsException;
    public boolean contains(Object obj);
    public Object delete(Object obj) throws NullPointerException;
    //public int indexOf(Object obj);
    //public boolean isEmpty();

}
