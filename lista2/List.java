import java.lang.*;

public interface List {

    public int size();
    public void insert(int index, Object obj);
    public void add(Object obj);
    public Object set(int index, Object obj) throws IndexOutOfBoundsException;
    public Object get(int index) throws IndexOutOfBoundsException;

}
