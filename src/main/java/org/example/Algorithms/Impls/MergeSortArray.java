package org.example.Algorithms.Impls;

import org.example.ArrayWithElements.MyUtilClass;

import java.util.Arrays;

public class MergeSortArray {

    // O( n log n)
    // n + n log n ==> , Overall by merge sort: n log n
    public static void main(String[] args) {
        Integer[] nums = MyUtilClass.generateSortedNUms(1, 100);
        if (!MyUtilClass.isSorted(nums)) {
            System.out.println("arr isn't sorted with elements count: " + nums.length);
        }
        mergeSort(nums, 0, nums.length - 1);
        if (MyUtilClass.isSorted(nums)) {
            System.out.println("arr is sorted with elements count: " + nums.length);
        }
    }


    // Subroutines: split by middle recursively, merge
    public static <T extends Comparable<T>> void mergeSort(T[] arr, int from, int to) {
        if (from >= to) return;

        int mid = (from + to) / 2;
        mergeSort(arr, from, mid);         //left (include middle)
        mergeSort(arr, mid + 1, to);  //right
        merge(arr, from, mid, to);
    }

    private static <T extends Comparable<T>> void merge(T[] arr, int from, int mid, int to) {
//        Error: Type parameter 'T' cannot be instantiated directly
//        T[] L = new T[leftLength];
//        T[] R = new T[RightLength];

        T[] L = Arrays.copyOfRange(arr, from, mid + 1);
        T[] R = Arrays.copyOfRange(arr, mid + 1, to + 1);

        int LIdx = 0;
        int RIdx = 0;
        int arrIdx = from;

        while (LIdx < L.length && RIdx < R.length)
            arr[arrIdx++] = L[LIdx].compareTo(R[RIdx]) < 0 ? L[LIdx++] : R[RIdx++]; // L[LIdx] < R[RIdx]

        while (LIdx < L.length)
            arr[arrIdx++] = L[LIdx++];
        while (RIdx < R.length)
            arr[arrIdx++] = R[RIdx++];
    }
}