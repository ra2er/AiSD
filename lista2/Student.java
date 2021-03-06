public class Student {

    public int indexNum;
    public String firstName;
    public String lastName;
    public int grade;

    public Student() {};

    public Student(int indexNum, String firstName, String lastName, int grade) {
        this.indexNum = indexNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public String toString() {
        return String.format("%3d | %15s %-15s | %d", this.indexNum, this.firstName, this.lastName, this.grade);
    }

    public boolean equals(Student other) {
        return this.indexNum == other.indexNum;
    }
}
