public class StudentList extends OneWayList {

    public StudentList join(StudentList other) {
        OneWayListIterator iter = this.iterator();
        OneWayListIterator otherIter = other.iterator();
        StudentList joined = new StudentList();

        for (iter.first(); !iter.isDone(); iter.next()) {
            Element iterElement = iter.current();
            Student s1 = (Student)iterElement.value;
            for (otherIter.first(); !otherIter.isDone(); otherIter.next()) {
                Element otherIterElement = otherIter.current();
                Student s2 = (Student)otherIterElement.value;
                // przy założeniach zadania że studenci są posortowani
                // ten algorytm zadziała, w przeciwnym wypadku nie.
                if (s1.indexNum >= s2.indexNum && !joined.contains(s2)) {
                    joined.add(s2);
                }
            }
            if (!joined.contains(s1)) {
                joined.add(s1);
            }
        }

        // sprawdzamy koniec listy nr 2
        otherIter.last();
        Element otherIterElement = otherIter.current();
        Student s2 = (Student)otherIterElement.value;
        if (!joined.contains(s2)) {
            joined.add(s2);
        }
        return joined;
    }
}
