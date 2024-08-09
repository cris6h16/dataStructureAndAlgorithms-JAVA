package org.example.DataStructure.Queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class QueueCircularArray<T> implements Queue<T> {
    private static final int DEFAULT_CAPACITY = 2;
    private static final int EMPTY_QUEUE_INDEX = -1;

    private T[] arr;
    private int size;
    private int headIdx, tailIdx;

    public QueueCircularArray(int initialCapacity) {
        this.arr = createArray(Math.max(initialCapacity, DEFAULT_CAPACITY));
        this.headIdx = this.tailIdx = EMPTY_QUEUE_INDEX;
    }

    // Prototype Design Pattern
    public QueueCircularArray(QueueCircularArray<T> q) {
        this.arr = q.arr.clone();
        this.headIdx = q.headIdx;
        this.tailIdx = q.tailIdx;
        this.size = q.size;
    }

    @Override
    public void offer(T val) {
        if (isEmpty()) headIdx = tailIdx = 0;
        else if (isFull()) resize();
        else tailIdx = goRight(tailIdx);

        arr[tailIdx] = val;
        size++;
    }

    private void resize() {
        T[] newArr = createArray(arr.length * 2);
        int lastEmpty = 0;

        for (int i = headIdx; i != tailIdx; i = goRight(i)) {
            newArr[lastEmpty++] = arr[i];
        }
        newArr[lastEmpty++] = arr[tailIdx]; // copy the last element

        headIdx = 0;
        tailIdx = lastEmpty;
        arr = newArr;
        /*
        [ a, b, c, d, e, f, g, null, null, null ]
          ^                 ^
          |                 |
        head=0           tail=6
         */
    }


    @Override
    public T poll() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty.");

        T tmp = arr[headIdx];
        arr[headIdx] = null;

        if (headIdx == tailIdx) headIdx = tailIdx = EMPTY_QUEUE_INDEX;
        else headIdx = goRight(headIdx);

        size--;
        return tmp;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty.");
        return arr[headIdx];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == arr.length;
    }

    @Override
    public int size() {
        return size;
    }

    private int goRight(int idx) {
        return (idx + 1) % arr.length;
    }

    @SuppressWarnings("unchecked")
    private T[] createArray(int length) {
        return (T[]) new Object[length];
    }


    @Override
    public Queue<T> clone() {
        return new QueueCircularArray<>(this);
    }

    @Override
    public String toString() {
        return "QueueCircularArray{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                ", headIdx=" + headIdx +
                ", tailIdx=" + tailIdx +
                '}';
    }
}
