public class Zad2 {

    public static void main(String[] args) {
        StudentList studentList1 = new StudentList();
        StudentList studentList2 = new StudentList();
        studentList1.add(new Student(1, "Jarosław", "Polskęzbaw", 3));
        studentList1.add(new Student(3, "Bredzisław", "Komoruski", 4));
        studentList1.add(new Student(5, "Koziołek", "Matołek", 2));
        studentList1.add(new Student(10, "Stanisław", "Łęcina", 5));
        studentList1.add(new Student(11, "Władimir", "Put in", 3));


        studentList2.add(new Student(2, "Polskęzbaw", "Jarosław", 3));
        studentList2.add(new Student(4, "Komoruski", "Bredzisław", 4));
        studentList2.add(new Student(6, "Matołek", "Koziołek", 2));
        studentList2.add(new Student(9, "Łęcina", "Stanisław", 5));
        studentList2.add(new Student(12, "Put in", "Władimir", 3));

        StudentList joined = studentList1.join(studentList2);
        System.out.println(studentList1);
        System.out.println(studentList2);
        System.out.println(joined);
    }
}
