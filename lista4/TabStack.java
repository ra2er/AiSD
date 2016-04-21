public class TabStack implements Stack {

    public Object[] stack;
    public int head;

    public TabStack(int stackSize) {
        this.stack = new Object[stackSize];
        this.head = 0;
    }

    public void push(Object val) {
        this.stack[head] = val;
        if (head < this.stack.length - 1) {
            this.head++;
        }
    }

    public Object pop() {
        Object o = this.stack[head];
        if (head > 0) {
            this.head--;
        }
        return o;
    }

    public Object peek() {
        return this.stack[head];
    }

    public int size() {
        return this.head;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void clear() {
        for (Object o: this.stack) {
            this.pop();
        }
    }

    public String toString() {
        String s = "";
        for (Object o: this.stack) {
            s += o.toString();
        }
        return s;
    }

    public int capacity() {
        return this.stack.length;
    }
}
