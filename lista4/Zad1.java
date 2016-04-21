public class Zad1 {

    public static void main(String[] args) {
        TabStack stack = new TabStack(10);
        for (int i=0; i<stack.capacity(); i++) {
            stack.push(i);
        }
        System.out.println(stack);
        for (int i=0; i<stack.capacity(); i++) {
            System.out.println("Peek:");
            Object p = stack.peek();
            System.out.println(p);
            System.out.println("Pop:");
            p = stack.pop();
            System.out.println(p);
        }
        System.out.println("Is empty:");
        System.out.println(stack.isEmpty());
        System.out.println("Stack:");
        for (int i=0; i<stack.capacity(); i++) {
            stack.push(i);
        }
        System.out.println(stack);
        stack.clear();
        System.out.println("Empty after clear:");
        System.out.println(stack.isEmpty());
    }
}
