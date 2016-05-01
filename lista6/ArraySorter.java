import java.util.*;
import java.lang.reflect.Array;

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

    public int calculateIncrement(int h, int max) {
        int hCurrent = 3 * h + 1;
        if (hCurrent < max) {
            return this.calculateIncrement(hCurrent, max);
        }
        else {
            return h;
        }
    }

    // algorytmy złożone
    public T[] insertSortWithIncrementation(T[] array, int start, int incrementation) {
        // insert sort zmodyfikowany na potrzeby algorytmu shell sort
        int i, k;
        for (i=start+incrementation; i<array.length; i+=incrementation) {
            T key = array[i];
            for (k=i-incrementation; (k>=0 && this.compare(array[k], key) >= 0); k-=incrementation) {
                //System.out.println(String.format("i: %d k: %d", i, k));
                array[k+incrementation] = array[k];
            }
            array[k+incrementation] = key;
            this.switches++;
        }
        return array;
    }

    public T[] shellSort(T[] array) {
        this.compares = 0;
        this.switches = 0;
        int H = this.calculateIncrement(0, array.length);
        while (H >= 1) {
            //System.out.println(H);
            for (int start=0; start<H; start++) {
                array = this.insertSortWithIncrementation(array, start, H);
            }
            H = this.calculateIncrement(0, H);
        }
        System.out.println(String.format("Comparsions: %d, Switches: %d", this.compares, this.switches));
        return array;
    }

    public void actualQuickSort(T[] array, int lo, int hi) {
        int i=lo, j=hi;
        T tmp;
        T key = array[(lo+hi) / 2];
        do {
            while(this.compare(array[i], key) < 0) i++;
            while(this.compare(array[j], key) > 0) j--;
            if (i <= j) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
                this.switches++;
            }
        } while (i<=j);
        if (lo < j) actualQuickSort(array, lo, j);
        if (hi > i) actualQuickSort(array, i, hi);
    }

    public T[] quickSort(T[] array) {
        this.compares = 0;
        this.switches = 0;
        this.actualQuickSort(array, 0, array.length - 1);
        System.out.println(String.format("Comparsions: %d, Switches: %d", this.compares, this.switches));
        return array;
    }

    @SuppressWarnings("unchecked")
    public T[] joinArrays(T[] left, T[] right) {
        T[] merged = (T[]) Array.newInstance(left.getClass().getComponentType(), left.length+right.length);
        int i = 0,
            j = 0,
            m = 0;
        while(i != left.length && j != right.length) {
            //System.out.println(String.format("left length: %d Right length: %d", left.length, right.length));
            if (this.compare(left[i], right[j]) <= 0) {
                merged[m] = left[i];
                i++;
            } else {
                merged[m] = right[j];
                j++;
            }
            switches++;
            m++;
        }
        while (i != left.length) {
            merged[m] = left[i];
            i++;
            m++;
        }
        while (j != right.length) {
            merged[m] = right[j];
            j++;
            m++;
        }
        return merged;
    }

    @SuppressWarnings("unchecked")
    public T[] actualMergesort(T[] array, int lo, int hi) {
        if (lo == hi) {
            T[] copy = Arrays.copyOfRange(array, lo, lo+1);
            copy[0] = array[lo];
            return copy;
        }
        int x = (lo + hi) / 2;
        return this.joinArrays(actualMergesort(array, lo, x),
                               actualMergesort(array, x+1, hi));
    }

    public T[] mergesort(T[] array) {
        this.compares = 0;
        this.switches = 0;
        array = this.actualMergesort(array, 0, array.length-1);
        System.out.println(String.format("Comparsions: %d, Switches: %d", this.compares, this.switches));
        return array;
    }
}
