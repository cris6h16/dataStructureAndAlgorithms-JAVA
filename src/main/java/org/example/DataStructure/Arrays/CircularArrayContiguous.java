package org.example.DataStructure.Arrays;

import java.util.Arrays;

public class CircularArrayContiguous<T> {
    private T[] arr;
    private int head;
    private int tail;

    public CircularArrayContiguous(int fixedSize) {
        if (fixedSize < 2) throw new IllegalArgumentException();
        this.arr = (T[]) new Object[fixedSize];
        head = tail = arr.length / 2;
    }

    public void prepend(T val) { // head
        isNotFull();
        head = goLeft(head);
        arr[head] = val;
    }


    public void append(T val) { // tail
        isNotFull();
        arr[tail] = val;
        tail = goRight(tail);
    }

    public void removeFirst() { // head
        if (isEmpty()) return;
        arr[head] = null;
        head = goRight(head);
    }

    public void removeLast() { // tail
        if (isEmpty()) return;
        tail = goLeft(tail);
        arr[tail] = null;
    }

    public void isNotFull() {
        boolean headTailEquals = arr[head] == arr[tail];
        if (headTailEquals && !isEmpty()) throw new ArrayIsFullException();
    }

    private boolean isEmpty() {
        return arr[head] == null;
    }

    private int goLeft(int idx) {
        return (idx - 1 + arr.length) % arr.length;
    }

    private int goRight(int idx) {
        return (idx + 1) % arr.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Internal Array: ");
        for (int i = 0; i < arr.length; i++) {
            sb
                    .append(i == 0 ? "[\n\t" : "\t")
                    .append(arr[i])
                    .append(i == head ? " \t<- head" : "")
                    .append(i == tail ? " \t<- tail" : "")
                    .append(i == arr.length - 1 ? "\n]" : "")
                    .append("\n");

        }
        sb.append("Array to expose: ").append(Arrays.toString(getArray()));
        return sb.toString();
    }

    private T[] getArray() {
        T[] res = (T[]) new Object[arr.length];
        int falseHead = head;
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[falseHead];
            falseHead = goRight(falseHead);
        }
        return res;
    }
}

class ArrayIsFullException extends RuntimeException {
}
