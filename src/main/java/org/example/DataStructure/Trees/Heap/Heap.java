package org.example.DataStructure.Trees.Heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Heap<T> {
    private T[] arr;
    private int lastUsedIdx;
    private Comparator<T> comparator;

    public Heap(int initialSize, Comparator<T> comparator) {
        this.arr = (T[]) new Object[Math.max(initialSize, 2)];
        lastUsedIdx = -1;
        this.comparator = comparator;
    }

    public void add(T obj) {
        verifyCapacity();
        arr[++lastUsedIdx] = obj;
        trickleUp(lastUsedIdx);
        print();
    }

    private void print() {
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, lastUsedIdx + 1)));
    }

    public void removeRoot() {
        if (lastUsedIdx == -1) return;
        if (lastUsedIdx == 0) {
            lastUsedIdx--;
            return;
        }

        swap(0, lastUsedIdx--);
        trickleDown(0);
        print();
    }

    private void trickleDown(int idx) {
        int cLIdx = (2 * idx) + 1; //childLeft
        int cRIdx = (2 * idx) + 2; //childRight
        // if parent is less, parent goes down..
        // if we want max heap, simply invert the comparison result in Comparator<T> Implementation
        if (cLIdx <= arr.length - 1 &&
                arr[cLIdx] != null &&
                comparator.compare(arr[cLIdx], arr[idx]) < 0) {
            swap(cLIdx, idx);
            trickleDown(cLIdx);
        }
        if (cRIdx <= arr.length - 1 &&
                arr[cRIdx] != null &&
                comparator.compare(arr[cRIdx], arr[idx]) < 0) {
            swap(cRIdx, idx);
            trickleDown(cRIdx);
        }
    }

    private void verifyCapacity() {
        if (lastUsedIdx + 1 > arr.length - 1)
            arr = Arrays.copyOf(arr, arr.length * 2);
    }

    private void trickleUp(int idx) {
        if (idx <= 0) return;

        int parent = (int) Math.floor((idx - 1) / 2);
        // if child is less, child goes up...
        // if we want max heap, simply invert the comparison result in Comparator<T> Implementation
        if (comparator.compare(arr[idx], arr[parent]) < 0) {
            swap(idx, parent);
            trickleUp(parent);
        }
    }

    private void swap(int idxA, int idxB) {
        T tmp = arr[idxA];
        arr[idxA] = arr[idxB];
        arr[idxB] = tmp;
    }

    public T[] getArr() {
        return arr;
    }

    public int getLastUsedIdx() {
        return lastUsedIdx;
    }
}
