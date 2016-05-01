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
            for (int k=0; k<i-1; k++){
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
        int i, k;
        for (i=1; i<array.length; i++) {
            T key = array[i];
            for (k=i-1; (k>=0 && this.compare(array[k], key) >= 0); k--) {
                array[k+1] = array[k];
            }
            array[k+1] = key;
            this.switches++;
        }
        System.out.println(String.format("Comparsions: %d, Switches: %d", this.compares, this.switches));
        return array;
    }
}
