package org.example.DataStructure.Trees.Heap;

import org.example.DataStructure.Trees.Heap.MyComparators.MaxHeapComparator;
import org.example.DataStructure.Trees.Heap.MyComparators.MinHeapComparator;

public class MAIN {
    public static void main(String[] args) {
        Heap<Integer> h = new Heap<>(0, new MaxHeapComparator<Integer>());
        h.add(9);
        h.add(8);
        h.add(7);
        h.add(6);
        h.add(5);
        h.add(4);
        h.add(3);
        h.add(2);
        h.add(1);

        System.out.println();

        Heap<Integer> h2 = new Heap<>(0, new MinHeapComparator<Integer>());
        h2.add(9);
        h2.add(8);
        h2.add(7);
        h2.add(6);
        h2.add(5);
        h2.add(4);
        h2.add(3);
        h2.add(2);
        h2.add(1);

        h2.removeRoot();
        h2.removeRoot();
        h2.removeRoot();
        h2.removeRoot();
        h2.removeRoot();
        h2.removeRoot();
        h2.removeRoot();
        h2.removeRoot();

        Integer a = null;
        assert a != null:"error";
        System.out.println("hola");
    }
}
