package org.example.DataStructure.LinkedList.Interfaces;

public interface List<T extends Comparable<T>> {
    void addFirst(T val);

    void addLast(T val);

    T removeFirst();

    T removeLast();

    T remove(T val);

    T peekFirst();

    T peekLast();

    boolean contains(T val);

}
