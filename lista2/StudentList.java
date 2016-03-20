public class StudentList extends OneWayList {

    public StudentList join(StudentList other) {
        OneWayListIterator iter = this.iterator();
        OneWayListIterator otherIter = other.iterator();
        StudentList joined = new StudentList();
        //for (iter.first(); !iter.isDone(); iter.next()) {
        //    for (otherIter.first(); !otherIter.isDone(); otherIter.next()) {
        //        iterElement = iter.current();
        //        otherIterElement = other.current();
        //        if (iterElement.value.indexNum > otherIterElement.value.indexNum) {
        //            if (iterElement == this.firstObj) {
        //                this.firstObj = otherIterElement;
        //            }
        //        }
        //    }
        //}

        return joined;
    }
}
