public class FilterIterator implements Iterator {

    public final StudentIterator iterator;
    public final Predicate predicate;

    public FilterIterator(StudentIterator iterator, Predicate predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
        this.iterator.first();
    }

    public void forwardFilter() {
        while (!this.iterator.isDone() && !this.predicate.accept(this.iterator.current())) {
            this.iterator.next();
        }
    }

    public void backwardFilter() {
        while (!this.iterator.isDone() && !this.predicate.accept(this.iterator.current())) {
            this.iterator.previous();
        }
    }

    public void first() {
        this.iterator.first();
        this.forwardFilter();
    }

    public void last() {
        this.iterator.last();
        this.backwardFilter();
    }

    public void next() {
        this.iterator.next();
        this.forwardFilter();
    }

    public void previous() {
        this.iterator.previous();
        this.backwardFilter();
    }

    public boolean isDone() {
        return this.iterator.isDone();
    }

    public Student current() {
        return this.iterator.current();
    }
}
