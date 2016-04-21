import java.util.Random;


public class Zad3 {

    public static void main(String[] args) {
        int workingTime = 8 * 60;
        SimpleQueue clients = new SimpleQueue();
        int i = 0;
        for (int n = 0; n < 20; n++) {
            Client client = new Client(n);
            clients.enqueue(client);
            i = n;
        }
        Consumer a = new Consumer("A", clients);
        Consumer b = new Consumer("B", clients);
        Consumer c = new Consumer("C", clients);
        Random r = new Random();
        while (!clients.isEmpty() && workingTime > 0) {
            int rand = r.nextInt(11);
            boolean add = rand > 5;
            a.serve();
            b.serve();
            c.serve();
            workingTime--;
            if (add) {
                i++;
                Client client = new Client(i);
                clients.enqueue(client);
            }
            if (workingTime == 0) {
                System.out.println("Koniec pracy urzędu");
            }
        }
    }
}
