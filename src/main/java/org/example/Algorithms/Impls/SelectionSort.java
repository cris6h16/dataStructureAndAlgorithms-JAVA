package org.example.Algorithms.Impls;

import org.example.ArrayWithElements.MyUtilClass;

public class SelectionSort {

    public static void main(String[] args) {
        String[] alphabet = {"z", "y", "x", "w", "v", "u", "t", "s", "r", "q", "p", "o", "n", "m", "l", "k", "j", "i", "h", "g", "f", "e", "d", "c", "b", "a"};
        selectionSort(alphabet);
        if (MyUtilClass.isSorted(alphabet)) {
            System.out.println("Alphabet array is sorted, length: " + alphabet.length);
        }
        /*
            Alphabet array is sorted, length: 26
         */
    }


    // subroutines: get min value Index from, swap i with index
    /* Time Complexity
    Worst Case:     O(n^2)
    Best Case:      O(n^2)
    Average Case:   O(n^2)
     */
    public static <T extends Comparable<T>> void selectionSort(T[] arr) {

        int idx;
        for (int i = 0; i < arr.length; i++) {
            idx = getMinValIdx(arr, i);
            swap(arr, i, idx);
        }

    }

    private static <T extends Comparable<T>> void swap(T[] arr,
                                                       int a,
                                                       int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static <T extends Comparable<T>> int getMinValIdx(T[] arr,
                                                              int fromIdx) {
        if (arr.length == 1) return 0;
        if (arr.length == 0) return -1;

        int minIdx =fromIdx;
        while (fromIdx < arr.length) {
            // arr[fromIdx] < arr[minIdx]
            if (arr[fromIdx].compareTo(arr[minIdx]) < 0)
                minIdx = fromIdx;

            fromIdx++;
        }

        return minIdx;
    }
}
