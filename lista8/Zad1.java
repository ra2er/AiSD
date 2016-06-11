import java.util.Random;

public class Zad1 {
  public static void main(String[] args) {
    HashMap map = new HashMap();
    for (int i=0; i<950000; i++) {
      map.set(i, i);
    }
    Random r = new Random();
    for (int i=0; i<20; i++) {
      long start = System.nanoTime();
      Element e = map.get(r.nextInt(950000));
      long end = System.nanoTime();
      System.out.println(e.value);
      System.out.println(String.format("Czas wyszukiwania elementu w słowniku = %s ms", (end - start)/1000000.0));
    }
  }
}
