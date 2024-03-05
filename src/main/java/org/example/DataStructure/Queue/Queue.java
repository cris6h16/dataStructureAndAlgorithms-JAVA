package org.example.DataStructure.Queue;

public interface Queue<T> {
    boolean offer(T val);
    T poll();
    T peek();
    boolean isEmpty();
    boolean isFull();
    Queue<T> clone();
}
