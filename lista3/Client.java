import java.util.Random;

public class Client {

    private int id;
    private int time;
    public int remaining;

    public Client(int id) {
        Random r = new Random();
        this.time = r.nextInt(10) + 1;
        this.remaining = this.time;
        this.id = id;

    }

    public int getTime() {
        return this.time;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        return String.format("Klient %d - czas obsługi %d", this.id, this.time);
    }

    public void setRemaining(int time) {
        this.remaining -= time;
    }
}
