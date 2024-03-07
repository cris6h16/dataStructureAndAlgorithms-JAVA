package org.example.DataStructure.Trees.Heap.MyComparators;

import java.util.Comparator;

public class MaxHeapComparator<T extends Comparable<T>> implements Comparator<T> {
    // comparison result is inverted, in Heap class, we compare: o1 < o2
    // if we want o1 > o2, simply invert the result
    @Override
    public int compare(T o1, T o2) {
        int r = o1.compareTo(o2);
        return r > 0 ? -1 : 1;
    }
}
