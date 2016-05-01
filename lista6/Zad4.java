import java.io.*;
import java.util.ListIterator;

public class Zad4 {

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

        StackPriorityQueue<Book> books = new StackPriorityQueue<Book>(new BookDateComparator());

        for (int i=0; i<N; i++) {
            Book b = new Book();
            books.enqueue(b);
            System.out.println(b);
        }
        System.out.println("*********************");

        while(books.list.size() > 0) {
            Book b = books.dequeue();
            System.out.println(b);
        }
        System.out.println(String.format("Comparsions: %d, Swaps: %d", books.compares, books.swaps));
    }
}
