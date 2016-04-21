public class IntegerComparator implements Comparator<Integer> {

    public int compare(Integer first, Integer second) {
        return first > second? 1: first == second? 0: 1;
    }
}
