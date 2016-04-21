import java.io.*;

public class Zad1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Gige me N of elements to sort:");
        int N;
        try {
            N = Integer.parseInt(br.readLine());
        }
        catch (NumberFormatException e) {
            N = 100;
        }
        ArraySorter<Book> complexSorter = new ArraySorter<>(new BookComplexComparator());
        ArraySorter<Book> isbnSorter = new ArraySorter<>(new BookISBNComparator());
        ArraySorter<Book> dateSorter = new ArraySorter<>(new BookDateComparator());
        ArraySorter<Book> sorter = new ArraySorter<>();
        Book[] books = new Book[N];
        System.out.println("######################################## Unsorted:");
        for (int i=0; i<N; i++) {
            Book b = new Book();
            books[i] = b;
            System.out.println(b);
        }

        System.out.println("#################### Bubble sort, natural sorting:");
        Book[] sorted = sorter.bubbleSort(books.clone());
        for (Book b: sorted) {
            System.out.println(b);
        }

        System.out.println("####################### Bubble sort, ISBN sorting:");
        sorted = isbnSorter.bubbleSort(books.clone());
        for (Book b: sorted) {
            System.out.println(b);
        }

        System.out.println("################# Bubble sort, issue date sorting:");
        sorted = dateSorter.bubbleSort(books.clone());
        for (Book b: sorted) {
            System.out.println(b);
        }

        System.out.println("################# Bubble sort, complex comparator:");
        sorted = complexSorter.bubbleSort(books.clone());
        for (Book b: sorted) {
            System.out.println(b);
        }


        System.out.println("#################### Select sort, natural sorting:");
        sorted = sorter.selectSort(books.clone());
        for (Book b: sorted) {
            System.out.println(b);
        }

        System.out.println("####################### Select sort, ISBN sorting:");
        sorted = isbnSorter.selectSort(books.clone());
        for (Book b: sorted) {
            System.out.println(b);
        }

        System.out.println("################# Select sort, issue date sorting:");
        sorted = dateSorter.selectSort(books.clone());
        for (Book b: sorted) {
            System.out.println(b);
        }

        System.out.println("################# Select sort, complex comparator:");
        sorted = complexSorter.selectSort(books.clone());
        for (Book b: sorted) {
            System.out.println(b);
        }

        System.out.println("#################### Insert sort, natural sorting:");
        sorted = sorter.insertSort(books.clone());
        for (Book b: sorted) {
            System.out.println(b);
        }

        System.out.println("####################### Insert sort, ISBN sorting:");
        sorted = isbnSorter.insertSort(books.clone());
        for (Book b: sorted) {
            System.out.println(b);
        }

        System.out.println("################# Insert sort, issue date sorting:");
        sorted = dateSorter.insertSort(books.clone());
        for (Book b: sorted) {
            System.out.println(b);
        }

        System.out.println("################# Insert sort, complex comparator:");
        sorted = complexSorter.insertSort(books.clone());
        for (Book b: sorted) {
            System.out.println(b);
        }
    }
}
