public class BookISBNComparator extends BookComparator {

    public int compare(Book first, Book second) {
        return first.isbn > second.isbn?1:first.isbn==second.isbn?0:-1;
    }
}
