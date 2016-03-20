public class Zad1 {

    public static void main(String[] args) {
        OneWayList list = new OneWayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
            list.add(5);
        }
        System.out.println(list);
        list.insert(4, 1000);
        list.insert(100, 999);
        OneWayList deleted = list.deleteAll(5);
        Element changed = list.set(3, 33);
        System.out.println("---");
        System.out.println(deleted);
        System.out.println(changed.value.toString());
        System.out.println("---");
        System.out.println(list);
    }
}
