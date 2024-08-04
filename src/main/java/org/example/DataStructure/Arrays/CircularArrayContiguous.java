package org.example.DataStructure.Arrays;

public class CircularArrayContiguous<T> {
    T[] arr;
    int head;
    int tail;

    public CircularArrayContiguous(int fixedSize) {
        if (fixedSize < 1) throw new IllegalArgumentException();
        this.arr = (T[]) new Object[fixedSize];
        this.head = fixedSize / 2 ;
        this.tail = fixedSize / 2 ;
    }

    public void prepend(T val){
        if (head == tail) throw new IllegalStateException
        int idx = (head + 1) % arr.length;
    }
}
