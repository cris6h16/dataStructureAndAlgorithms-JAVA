package org.example.DataStructure.Trees.Simples;

public interface BinaryTree <T extends Comparable<T>> {

    void add(T obj);
    T remove(T obj);
    boolean contains(T obj);
    T[] toArray(BinaryTreeImpl.ETraversalOrder order);
    boolean isEmpty();
    int height();
    void clear();
    int size();
    T getMin();
    T getMax();

}
