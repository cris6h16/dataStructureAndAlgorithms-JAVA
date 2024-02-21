package org.example.Algorithms;

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
    public static void selectionSort(Integer[] arr) {

        int idx, aux;
        for (int i = 0; i < arr.length; i++) {
            idx = getMinValIdx(arr, i);
            swap(arr, i, idx);
        }

    }

    private static void swap(Integer[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static int getMinValIdx(Integer[] arr, int fromIdx) {
        if (arr.length == 1) return 0;

        int minIdx = 0;
        for (; fromIdx < arr.length; fromIdx++) {
            if (arr[fromIdx] < arr[minIdx]) minIdx = fromIdx;
        }
        return minIdx;
    }
}
