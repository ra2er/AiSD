public class BookDateComparator extends BookComparator {

    public int compare(Book first, Book second) {
        return first.issueDate.compareTo(second.issueDate);
    }
}
