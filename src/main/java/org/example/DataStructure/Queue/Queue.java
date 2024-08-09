package org.example.DataStructure.Queue;

public interface Queue<T> {
    void offer(T val);
    T poll();
    T peek();
    boolean isEmpty();
    boolean isFull();
    Queue<T> clone();
    int size();
}
