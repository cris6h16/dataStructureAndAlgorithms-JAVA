package org.example.Algorithms.Impls;

import org.example.ArrayWithElements.MyUtilClass;

public class SelectionSort {

    public static void main(String[] args) {
        Integer[] nums = MyUtilClass.getNumsArray();
        selectionSort(nums);
        if (MyUtilClass.isSorted(nums)) {
            System.out.println("Nums array is sorted, length: " + nums.length);
        }
    }


    // subroutines: get min value Index from, swap i with index
    public static <T extends Comparable<T>> void selectionSort(T[] arr) {

        int idx, aux;
        for (int i = 0; i < arr.length; i++) {
            idx = getMinValIdx(arr, i);
            swap(arr, i, idx);
        }

    }

    private static <T extends Comparable<T>> void swap(T[] arr, int a, int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static <T extends Comparable<T>> int getMinValIdx(T[] arr, int fromIdx) {
        if (arr.length == 1) return 0;
        if (arr.length == 0) return -1;

        int minIdx = 0;
        while (fromIdx < arr.length) {
            if (arr[fromIdx].compareTo(arr[minIdx]) < 0)// arr[fromIdx] < arr[minIdx]
                minIdx = fromIdx;

            fromIdx++;
        }

        return minIdx;
    }
}
