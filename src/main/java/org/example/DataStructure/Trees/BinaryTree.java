package org.example.DataStructure.Trees;

import java.util.Iterator;

public interface BinaryTree <T extends Comparable<T>> extends Iterable<T> {

    void add(T obj);
    T remove(T obj);
    boolean contains(T obj);
    void clear();
    int size();
    boolean isEmpty();
    Iterator<T> iterator();

}
