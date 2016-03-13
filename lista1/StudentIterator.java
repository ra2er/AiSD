public class StudentIterator implements Iterator {

    final Student[] students;
    final int firstIndex;
    final int lastIndex;
    int currentIndex = -1;

    public StudentIterator(Student[] students) {
        this.students = students;
        this.firstIndex = 0;
        this.lastIndex = students.length - 1;
    }

    public void first() {
        this.currentIndex = this.firstIndex;
    }

    public void last() {
        this.currentIndex = this.lastIndex;
    }

    public void next() {
        this.currentIndex += 1;
    }

    public void previous() {
        this.currentIndex += 1;
    }

    public boolean isDone() {
        return this.currentIndex < this.firstIndex || this.currentIndex > this.lastIndex;
    }

    public Student current() {
        return this.students[this.currentIndex];
    }
}
