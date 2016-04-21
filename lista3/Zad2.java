import java.util.Random;

public class Zad2 {

    public static void main(String[] args) {
        Random r = new Random();
        int size = 10;
        FIFOBuffer buf = new FIFOBuffer(size);
        for (int i = 0; i < 100; i++) {
            if (buf.size() == buf.getBufforSize()) {
                System.out.println("Kolejka jest pełna, pobieram z kolejki.");
                try {
                    Element e = buf.dequeue();
                    System.out.println(e);
                }
                catch (EmptyQueueException e) {
                    continue;
                }
            } else {
                int num = r.nextInt(100);
                buf.enqueue(num);
                System.out.println(String.format("Wkładam element do kolejki, %d", num));
            }
        }

    }
}
