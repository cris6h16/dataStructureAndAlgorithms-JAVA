package org.example.DataStructure.Trees.Heap.MyComparators;

import java.util.Comparator;

public class MinHeapComparator<T extends Comparable<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        int r = o1.compareTo(o2);
        return r;
    }
}
