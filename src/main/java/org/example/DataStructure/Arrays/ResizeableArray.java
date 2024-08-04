package org.example.DataStructure.Arrays;

public class ResizeableArray<T> {
    private T[] arr;
    private int lastIdx;

    public ResizeableArray(int initialCapacity) {
        if (initialCapacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        arr = (T[]) new Object[initialCapacity];
        lastIdx = 0;
    }


    public void add(T val) {
        if (isFull()) resize();
        arr[lastIdx++] = val;
    }

    public boolean isFull() {
        return arr[arr.length - 1] != null; // reference
    }

    public void resize() {
        T[] newArray = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        arr = newArray;
    }

    public T[] getArr() {
        return arr;
    }

    public int getLastIdx() {
        return lastIdx;
    }
}
