public class ByPositiveGrade implements Predicate {

    public boolean accept(Object obj) {
        Student s = (Student)obj;
        return s.grade > 2;
    }
}

