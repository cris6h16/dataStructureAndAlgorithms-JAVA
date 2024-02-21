package org.example.Algorithms.Impls;

import org.example.ArrayWithElements.MyUtilClass;

import java.util.Arrays;

public class MergeSortArray {

    // O( n log n)
    // n + n (log n) ==> , Overall by merge sort: n log n
    public static void main(String[] args) {
        Integer[] nums = MyUtilClass.getNumsArray();
        mergeSort(nums);
        if (MyUtilClass.isSorted(nums)) {
            System.out.println("arr is sorted with elements count: " + nums.length);
        }
    }


    // Big O: O(n log n)
    public static <T extends Comparable<T>> void mergeSort(T[] nums) {
        if (nums.length <= 1) return;
        int midL = nums.length / 2;
        T[] left = Arrays.copyOfRange(nums, 0, midL);
        T[] right = Arrays.copyOfRange(nums, midL, nums.length);
        mergeSort(left);
        mergeSort(right);
        merge(nums, left, right);
    }

    private static <T extends Comparable<T>> void merge(T[] original, T[] left, T[] right) {
        int pL = 0, pR = 0, idx = 0;
        while (pL < left.length && pR < right.length)
            original[idx++] = (left[pL].compareTo(right[pR]) < 0) ? left[pL++] : right[pR++];//left[pL] < right[pR]
        while (pL < left.length) original[idx++] = left[pL++];
        while (pR < right.length) original[idx++] = right[pR++];
    }

}