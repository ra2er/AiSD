public class BookComplexComparator extends BookComparator {

    Comparator[] comparators = {new BookDateComparator(), new BookISBNComparator()};

    public int compare(Book first, Book second) {
        // issue date then ISBN then author - title
        for (Comparator c: this.comparators) {
            int cmp = c.compare(first, second);
            if (cmp!=0) {
                return cmp;
            }
        }
        return first.compareTo(second);
    }
}

