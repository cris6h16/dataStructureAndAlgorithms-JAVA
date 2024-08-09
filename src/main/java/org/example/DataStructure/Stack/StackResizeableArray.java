package org.example.DataStructure.Stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackResizeableArray<T> implements Stack<T> {
    private T[] arr;
    private int toAddIdx;


    public StackResizeableArray() {
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
        if (size() == 0) throw new EmptyStackException();

        T tmp = arr[toAddIdx - 1];
        arr[toAddIdx--] = null;

        return tmp;
    }

    @Override
    public T peek() {
        if (size() == 0) throw new EmptyStackException();
        return arr[toAddIdx];
    }

    @Override
    public int size() {
        return toAddIdx;
    }

    @Override
    public boolean isEmpty() {
        return toAddIdx == 0;
    }

    private void checkCapacity() {
        if (toAddIdx > arr.length - 1)
            // increment in 50%
            arr = Arrays.copyOf(arr, (int) (arr.length * 1.5));
    }
}
