import java.util.*;
import java.text.SimpleDateFormat;

public class Book implements Comparable {

    public String author;
    public String title;
    public int isbn;
    public Date issueDate;

    public String generateRandomString() {
        char[] letters = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        Random r = new Random();
        String s = "";
        for (int i=0; i<10; i++) {
            s += letters[r.nextInt(letters.length)];
        }
        return s;
    }

    public int randRange(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

    public Date generateRandomDate() {
        Random r = new Random();
        long ms = 946681200000L + (Math.abs(r.nextLong()) % (1L * 365)) * 24 * 60 * 60 * 1000;
        return new Date(ms);
    }

    public Book() {
        this.author = generateRandomString();
        this.title = generateRandomString();
        Random r = new Random();
        this.isbn = r.nextInt(1000000);
        this.issueDate = generateRandomDate();
    }

    public int compareTo(Comparable other) throws TypeError {
        if (!(other instanceof Book)) {
            throw new TypeError("Incopatible types!");
        }
        int authorComparsion = this.author.compareTo(((Book)other).author);
        return authorComparsion!=0?authorComparsion:this.title.compareTo(((Book)other).title);
    }

    public String toString() {
        return String.format("%10s - %10s, ISBN: %10d, Issue date: %10s", author, title, isbn, new SimpleDateFormat("yyyy-MM-dd").format(issueDate));
    }
}
