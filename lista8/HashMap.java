import java.util.*;

public class HashMap {

  public LinkedList[] array;
  public int size;

  private long _hash(Object value) throws UnhashableType {
    if (value instanceof Integer) {
      value = value.toString();
    }
    if (value instanceof Long) {
      value = value.toString();
    }
    if (value instanceof String) {
      if (value == null) {
        return 0;
      }
    }
    else {
      throw new UnhashableType();
    }
    String s = (String)value;
    long val = (int) s.charAt(0) << 7;
    for (int i=0; i<s.length(); i++) {
      char c = s.charAt(i);
      int l = (int) c;
      val = (val * 6328883) ^ l;
    }
    return val;
  }

  public int getIndex(Object key, int mask) {
    try {
      long hash = this._hash(key);
      int index = (int) (hash & mask);
      return index;
    }
    catch (UnhashableType e) {
      System.out.println("Nie potrafię zahashować tego klucza");
    }
    return 0;
  }

  @SuppressWarnings("rawtypes")
  public void rewriteArray() {
    LinkedList[] tmp = new LinkedList[this.array.length * 2];
    for (int i=0; i<this.array.length; i++) {
      LinkedList l = this.array[i];
      if (l != null) {
        ListIterator iter = l.listIterator();
        LinkedList n = new LinkedList();
        while (iter.hasNext()) {
          Element next = (Element) iter.next();
          Object key = next.key;
          int index = this.getIndex(key, tmp.length - 1);
          if (tmp[index] == null) {
            tmp[index] = n;
          }
          tmp[index].add(next);
        }
      }
    }
  }

  @SuppressWarnings("rawtypes")
  public void set(Object key, Object value) {
    boolean exists = false;
    int index = this.getIndex(key, this.array.length - 1);
    if (this.array[index] == null) {
      this.array[index] = new LinkedList();
      this.size++;
    }
    LinkedList l = this.array[index];
    ListIterator iter = l.listIterator();
    while (iter.hasNext()) {
      Element next = (Element) iter.next();
      String key1 = next.key.toString();
      String key2 = key.toString();
      if (key1.equals(key2)) {
        exists = true;
      }
    }
    if (!exists) {
      this.array[index].add(new Element(key, value));
      if (this.array.length % size <= 8) {
        this.rewriteArray();
      }
    }
  }

  public Element get(Object key) {
    int index = this.getIndex(key, this.array.length - 1);
    if (this.array[index] == null) {
      return null;
    }
    LinkedList l = this.array[index];
    ListIterator iter = l.listIterator();
    while (iter.hasNext()) {
      Element next = (Element) iter.next();
      String key1 = next.key.toString();
      String key2 = key.toString();
      if (key1.equals(key2)) {
        return next;
      }
    }
    return null;
  }

  @SuppressWarnings("rawtypes")
  public HashMap() {
    //this.array = new LinkedList[1024];
    // do testów zwiększyłem od razu pojemność 
    // słownika do miliona, ponieważ algorytm przepisywania jest 
    // nieefektywny, rozważamy problem wyszukiwania w słowniku a nie szybkość tworzenia
    this.array = new LinkedList[1000000];
    this.size = 0;
  }
}
