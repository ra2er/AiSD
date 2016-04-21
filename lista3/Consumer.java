public class Consumer {

    private String name;
    public Client currentClient;
    public SimpleQueue clientQueue;

    public Consumer(String name, SimpleQueue clientQueue) {
        this.name = name;
        this.clientQueue = clientQueue;
    }

    public String getName() {
        return this.name;
    }

    public void serve() {
        if (this.currentClient == null) {
            try {
                Element e = (Element)this.clientQueue.dequeue();
                this.currentClient = (Client)e.value;
                System.out.println(String.format("%s -> %2s", this.currentClient.toString(), this.name));
            } catch (EmptyQueueException e) {
                System.out.println(String.format("Urzędnik %s czeka na klientów.", this.name));
            }
        } else {
            this.currentClient.setRemaining(1);
            if (this.currentClient.remaining == 0) {
                this.currentClient = null;
            }
        }
    }
}
