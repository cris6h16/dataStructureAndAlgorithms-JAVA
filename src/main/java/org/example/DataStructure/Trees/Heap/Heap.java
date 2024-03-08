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
        int cL = (2 * idx) + 1; //childLeft
        int cR = (2 * idx) + 2; //childRight
        // if parent is less, parent goes down..
        // if we want max heap, simply invert the comparison result in Comparator<T> Implementation
        if (cL <= arr.length - 1 &&
                arr[cL] != null &&
                comparator.compare(arr[cL], arr[idx]) < 0) {
            swap(cL, idx);
            trickleDown(cL);
        }
        if (cR <= arr.length - 1 &&
                arr[cR] != null &&
                comparator.compare(arr[cR], arr[idx]) < 0) {
            swap(cR, idx);
            trickleDown(cR);
        }
    }

    private void verifyCapacity() {
        if (lastUsedIdx + 1 > arr.length - 1)
            arr = Arrays.copyOf(arr, arr.length * 2);
    }

    private void trickleUp(int idx) {
        if (idx <= 0) return;

        int parent = (int) Math.floor((idx - 1) / 2);
        // if child is less, child goes up..
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
