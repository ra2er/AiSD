public class FIFOBuffer implements Queue{

    private int bufforSize;
    private int writePosition;
    private int readPosition;
    private Element[] buffor;

    public FIFOBuffer(int size) {
        this.bufforSize = size;
        this.buffor = new Element[size];
        this.writePosition = 0;
        this.readPosition = 0;
    }

    public int size() {
        if (this.buffor[this.writePosition] != null) {
            return this.bufforSize;
        }
        else {
            if (this.writePosition > this.readPosition) {
                return writePosition - readPosition;
            }
            else if (this.writePosition < this.readPosition) {
                return this.bufforSize - this.readPosition + this.writePosition;
            }
            else {
                return 0;
            }
        }
    }

    public void enqueue(Object value) {
        Element e = new Element(value);
        this.buffor[writePosition] = e;
        if (writePosition == this.bufforSize - 1) {
            this.writePosition = 0;
        }
        else {
            this.writePosition++;
        }
    }

    public Element dequeue() throws EmptyQueueException{
        if (this.size() < 1) {
            throw new EmptyQueueException();
        }
        else {
            Element e = this.buffor[this.readPosition];
            if (e == null) {
                throw new EmptyQueueException();
            }
            this.buffor[this.readPosition] = null;
            if (this.readPosition == this.bufforSize - 1) {
                this.readPosition = 0;
            }
            else {
                this.readPosition++;
            }
            return e;
        }
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void clear() {
        for (Object o: this.buffor) {
            o = null;
        }
    }

    public int getBufforSize() {
        return this.bufforSize;
    }
}
