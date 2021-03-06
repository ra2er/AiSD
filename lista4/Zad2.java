public class Zad2 {

    public static void main(String[] args) {
        int n = 100;
        InfiniteStack stack = new InfiniteStack();
        for (int i=0; i<n; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        while (!stack.isEmpty()) {
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
        for (int i=0; i<n; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        stack.clear();
        System.out.println("Empty after clear:");
        System.out.println(stack.isEmpty());
    }
}

