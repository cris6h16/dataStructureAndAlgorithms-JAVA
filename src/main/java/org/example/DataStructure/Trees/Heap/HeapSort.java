package org.example.DataStructure.Trees.Heap;

public class HeapSort<T extends Comparable<T>> {
    public void maxHeapSort(T[] arr, int lastUsedIdx) {
        if (lastUsedIdx == 0) return;

        swap(arr, 0, lastUsedIdx--);
        trickleDown(arr, 0, lastUsedIdx);
        maxHeapSort(arr, lastUsedIdx);
    }

    private void trickleDown(T[] arr, int idx, int lastUsedIdx) {
        int lC = 2 * idx + 1;//left child
        int rC = 2 * idx + 2;//right child
        if (lC <= lastUsedIdx && arr[idx].compareTo(arr[lC]) < 0) {
            swap(arr, idx, lC);
            trickleDown(arr, lC, lastUsedIdx);
        }
        if (rC <= lastUsedIdx && arr[idx].compareTo(arr[rC]) < 0) {
            swap(arr, idx, rC);
            trickleDown(arr, rC, lastUsedIdx);
        }
    }

    private void swap(T[] arr, int idx1, int idx2) {
        T temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
