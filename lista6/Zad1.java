import java.io.*;

public class Zad1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Give me N of elements to sort:");
        int N;
        try {
            N = Integer.parseInt(br.readLine());
        }
        catch (NumberFormatException e) {
            N = 100;
        }

        Book[] books = new Book[N];
        for (int i=0; i<N; i++) {
            Book b = new Book();
            books[i] = b;
        }

        if (N <= 10) {
            System.out.println("####################### Unsorted:");
            for (Book b: books) {
                System.out.println(b);
            }
        }

        ArraySorter<Book> complexSorter = new ArraySorter<>(new BookComplexComparator());

        System.out.println("#################### Insert sort:");
        Book[] sorted = complexSorter.insertSort(books.clone());

        System.out.println("##################### Shell sort:");
        sorted = complexSorter.shellSort(books.clone());
        if (N <= 10) {
            for (Book b: sorted) {
                System.out.println(b);
            }
        }

        System.out.println("##################### Quick sort:");
        sorted = complexSorter.quickSort(books.clone());
        if (N <= 10) {
            for (Book b: sorted) {
                System.out.println(b);
            }
        }

        System.out.println("##################### Merge sort:");
        sorted = complexSorter.mergesort(books.clone());
        if (N <= 10) {
            for (Book b: sorted) {
                System.out.println(b);
            }
        }

        System.out.println("##################### Stack sort:");
        StackPriorityQueue<Book> stack = new StackPriorityQueue<Book>(new BookDateComparator());
        for (Book b: books) {
            stack.enqueue(b);
        }
        while(stack.list.size() > 0) {
            Book b = stack.dequeue();
        }
        System.out.println(String.format("Comparsions: %d, Swaps: %d", stack.compares, stack.swaps));
    }
}
