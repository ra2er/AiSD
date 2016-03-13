import java.lang.ArrayIndexOutOfBoundsException;

public class StudentDatabase {

    public Student[] students;
    public StudentIterator iterator;
    public FilterIterator withPositiveGrade;
    public FilterIterator withNegativeGrade;

    public StudentDatabase(Student[] students) {
        this.students = students;
        this.iterator = new StudentIterator(this.students);
        this.withPositiveGrade = new FilterIterator(this.iterator, new ByPositiveGrade());
        this.withNegativeGrade = new FilterIterator(this.iterator, new ByNegativeGrade());
    }

    public void setGrade(int indexNum, int grade) {
        for (this.iterator.first(); !this.iterator.isDone(); this.iterator.next()) {
            Student s = this.iterator.current();
            if (s.indexNum == indexNum) {
                s.grade = grade;
            }
        }
    }

    public void printWithPositiveGrade() {
        for (this.withPositiveGrade.first(); !this.withPositiveGrade.isDone(); this.withPositiveGrade.next()) {
            Student s = this.iterator.current();
            System.out.println(s);
        }
    }

    public void printWithNegativeGrade() {
        for (this.withNegativeGrade.first(); !this.withNegativeGrade.isDone(); this.withNegativeGrade.next()) {
            Student s = this.iterator.current();
            System.out.println(s);
        }
    }

    public double avgPositiveGrade() {
        double sum = 0;
        double count = 0;
        for (this.withPositiveGrade.first(); !this.withPositiveGrade.isDone(); this.withPositiveGrade.next()) {
            Student s = this.iterator.current();
            sum += s.grade;
            count++;
        }
        return sum / count;
    }

    public void addStudent(Student student) {
        int i = 0;
        Student[] students = new Student[this.students.length+1];
        boolean inserted = false;
        for (this.iterator.first(); !this.iterator.isDone(); this.iterator.next()) {
            Student s = this.iterator.current();
            if (s.indexNum < student.indexNum || inserted) {
                students[i] = s;
                i += 1;
            } else {
                students[i++] = student;
                students[i++] = s;
                inserted = true;
            }
        }
        this.students = students;
        this.iterator = new StudentIterator(this.students);
        this.withPositiveGrade = new FilterIterator(this.iterator, new ByPositiveGrade());
        this.withNegativeGrade = new FilterIterator(this.iterator, new ByNegativeGrade());
    }

    public void removeStudent(Student student) {
        int i = 0;
        Student[] students = new Student[this.students.length-1];
        for (this.iterator.first(); !this.iterator.isDone(); this.iterator.next()) {
            Student s = this.iterator.current();
            if (!s.equals(student)) {
                students[i] = s;
                i += 1;
            }
        }
        this.students = students;
        this.iterator = new StudentIterator(this.students);
        this.withPositiveGrade = new FilterIterator(this.iterator, new ByPositiveGrade());
        this.withNegativeGrade = new FilterIterator(this.iterator, new ByNegativeGrade());
    }

    public void sortByGrade(boolean sorted) {
        int i = 0;
        this.iterator.first();
        if (!sorted) {
            int switchCount = 0;
            while (!this.iterator.isDone()) {
                try {
                    Student current = this.iterator.current();
                    this.iterator.next();
                    Student next = this.iterator.current();
                    if (current.grade < next.grade) {
                        Student tmp = next;
                        this.students[i+1] = current;
                        this.students[i] = tmp;
                        switchCount++;
                    }
                    i++;
                } catch (ArrayIndexOutOfBoundsException e) {
                    // nic nie robimy current=last
                }
            }
            this.sortByGrade(switchCount==0);
        } else {
            this.iterator = new StudentIterator(this.students);
            this.withPositiveGrade = new FilterIterator(this.iterator, new ByPositiveGrade());
            this.withNegativeGrade = new FilterIterator(this.iterator, new ByNegativeGrade());
        }
    }

    public String toString() {
        String dbString = "";
        for (this.iterator.first(); !this.iterator.isDone(); this.iterator.next()) {
            Student s = this.iterator.current();
            dbString += String.format("%s%n", s);
        }
        return dbString;
    }
}
