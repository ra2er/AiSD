public class ArraySorter<T extends Comparable> {

    Comparator<T> comparator;
    int switches = 0,
        compares = 0;

    public ArraySorter(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public ArraySorter() {
        this.comparator = null;
    }

    protected int compare(T first, T second) {
        if (this.comparator == null) {
            // natural comparator
            int cmp = first.compareTo(second);
            this.compares++;
            return cmp;
        }
        int cmp = this.comparator.compare(first, second);
        this.compares++;
        return cmp;
    }

    protected T[] swap(T[] array, int i, int k) {
        T tmp = array[i];
        array[i] = array[k];
        array[k] = tmp;
        this.switches++;
        return array;
    }

    public T[] bubbleSort(T[] array) {
        this.compares = 0;
        this.switches = 0;
        for (int i=array.length; i>1; i--) {
            boolean switched = false;
            for (int k=0; k<array.length-1; k++){
                T current = array[k];
                T next = array[k+1];
                int cmp = this.compare(current, next);
                if (cmp > 0) {
                    array = this.swap(array, k, k+1);
                    switched = true;
                }
            }
            if (!switched) {
                break;
            }
        }
        System.out.println(String.format("Comparsions: %d, Switches: %d", this.compares, this.switches));
        return array;
    }

    public T[] selectSort(T[] array) {
        this.compares = 0;
        this.switches = 0;
        for (int i=0; i<array.length-1; i++) {
            int minIndex = i;
            for (int k=i+1; k<array.length; k++) {
                int cmp = this.compare(array[minIndex], array[k]);
                if (cmp > 0) {
                    minIndex = k;
                }
            }
            array = this.swap(array, minIndex, i);
        }
        System.out.println(String.format("Comparsions: %d, Switches: %d", this.compares, this.switches));
        return array;
    }

    public T[] insertSort(T[] array) {
        this.compares = 0;
        this.switches = 0;
        T[] result = array.clone();
        for (int i=0; i<array.length; i++) {
            int pos = result.length;
            for (int k=array.length-1; k>=0; k--) {
                int cmp = this.compare(array[k], array[i]);
                if (cmp >=0) {
                    pos--;
                }
            }
            result[pos] = array[i];
        }
        System.out.println(String.format("Comparsions: %d, Switches: %d", this.compares, this.switches));
        return result;
    }
}
