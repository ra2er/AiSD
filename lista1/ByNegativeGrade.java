public class ByNegativeGrade implements Predicate {

    public boolean accept(Object obj) {
        Student s = (Student)obj;
        return s.grade <= 2;
    }
}
