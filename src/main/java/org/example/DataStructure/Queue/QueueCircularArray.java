package org.example.DataStructure.Queue;

import jdk.jshell.spi.ExecutionControl;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class QueueCircularArray<T> implements Queue<T> {
    T[] arr;
    int head, tail;

    public QueueCircularArray(int InitialCapacity) {
        this.arr = (T[]) new Object[Math.max(InitialCapacity, 2)];
        head = tail = -1;
    }

    @Override
    public boolean offer(T val) {
        if (isEmpty()) head++;
        else if (isFull()) resize();

        tail = (tail + 1) % arr.length;
        arr[tail] = val;
        return true;
    }

    private void resize() {
        T[] newArr = (T[]) new Object[(int) (arr.length * 2)];
        int i = 0;
        while (i <= arr.length - 1) {
            newArr[i++] = arr[head];
            head = (head + 1) % arr.length;
        }
        head = 0;
        tail = arr.length - 1;
        arr = newArr;
    }


    @Override
    public T poll() {
        if (isEmpty()) throw new NoSuchElementException();

        T tmp = arr[head];
        arr[head] = null;

        if (head == tail) head = tail = -1;
        else head = (head + 1) % arr.length;

        return tmp;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return arr[head];
    }

    @Override
    public boolean isEmpty() {
        return head == -1;
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % arr.length == head;// if next position for write isn't empty
    }
}
