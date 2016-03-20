public class Zad1 {

    public static void main(String[] args) {
        OneWayList list = new OneWayList();
        for (int i = 0; i < 10; i++) {
            list.add(new Integer(i));
        }
        System.out.println(list);
        list.insert(4, 1000);
        list.insert(100, 999);
        Element deleted = list.delete(5);
        Element changed = list.set(3, 33);
        System.out.println("---");
        System.out.println(deleted.value.toString());
        System.out.println(changed.value.toString());
        System.out.println("---");
        System.out.println(list);
    }
}
