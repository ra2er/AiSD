public class Zad1i2 {

    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0]=new Student(1, "Jarosław", "Polskęzbaw", 3);
        students[1]=new Student(3, "Bredzisław", "Komoruski", 4);
        students[2]=new Student(5, "Koziołek", "Matołek", 2);
        students[3]=new Student(10, "Stanisław", "Łęcina", 5);
        students[4]=new Student(11, "Władimir", "Put in", 3);
        StudentDatabase db = new StudentDatabase(students);
        System.out.println("Lista początkowa studentów:");
        System.out.println(db);
        System.out.println("Lista studentów z pozytywną oceną:");
        db.printWithPositiveGrade();
        System.out.println("Lista studentów z negatywną oceną:");
        db.printWithNegativeGrade();
        System.out.println("Średnia ocen studentów z pozytywną oceną:");
        System.out.println(db.avgPositiveGrade());
        System.out.println("Lista studentów po zmianie oceny:");
        // Koziołek Matołek ma teraz ocenę pozytywną (5)
        db.setGrade(5, 5);
        System.out.println(db);
        // dodanie studenta z zachowaniem kolejności wg indeksu
        db.addStudent(new Student(4, "Lech", "Zimny", 3));
        System.out.println("Lista studentów po dodaniu Lecha Zimnego:");
        System.out.println(db);
        // usunięcie studenta z zachowaniem kolejności wg indeksu
        db.removeStudent(new Student(4, "Lech", "Zimny", 3));
        System.out.println("Lista studentów po usunięciu Lecha Zimnego:");
        System.out.println(db);
        // sortowanie wg oceny malejąco
        db.sortByGrade(false);
        System.out.println("Lista studentów posortowaniu:");
        System.out.println(db);
    }

}
