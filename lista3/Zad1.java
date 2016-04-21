public class Zad1 {
    public static void main(String[] args) {
        SimpleQueue q = new SimpleQueue();
        for (int i=0; i < 10; i++) {
            Element e = new Element(i);
            q.enqueue(e);
        }
        while (!q.isEmpty()) {
            try {
                Element e = (Element)q.dequeue();
                System.out.println(e);
            } catch (EmptyQueueException e) {
                System.out.println("Koniec kolejki");
            }
        }
        q.clear();
        System.out.println(q.size());
    }
}
