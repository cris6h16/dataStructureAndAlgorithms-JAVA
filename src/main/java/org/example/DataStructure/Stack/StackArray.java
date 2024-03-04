package org.example.DataStructure.Stack;

import java.util.Arrays;

public class StackArray<T> implements Stack<T> {
    private T[] arr;
    private int toAddIdx;

    public StackArray() {
        this.arr = (T[]) new Object[10];
        this.toAddIdx = 0;
    }

    @Override
    public void push(T val) {
        checkCapacity();

        arr[toAddIdx++] = val;
    }

    @Override
    public T pop() {
        if (toAddIdx==0) return null;

        T tmp = arr[toAddIdx - 1];
        arr[toAddIdx--] = null;

        return tmp;
    }

    @Override
    public T peek() {
        return arr[toAddIdx];
    }

    @Override
    public boolean isEmpty() {
        return toAddIdx == 0;
    }

    private void checkCapacity() {
        if (toAddIdx > arr.length - 1)
            arr = Arrays.copyOf(arr, (int) (arr.length * 1.5)); // increment in 50%
    }
}
