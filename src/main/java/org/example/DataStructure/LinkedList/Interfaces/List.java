package org.example.DataStructure.LinkedList.Interfaces;

public interface List<T extends Comparable<T>> {
    void addFirst(T obj);

    void addLast(T obj);

    T removeFirst();

    T removeLast();

    T remove(T obj);

    T peekFirst();

    T peekLast();

    T contains(T obj);

}
