package org.example.Algorithms;

import java.util.Arrays;

public class MergeSortArray {

    // O( n log n)
    // n + n (log n) ==> , Overall by merge sort: n log n
    public static void main(String[] args) {
        int[] nums = {1};
        // n log n
        mergeSort(nums);
        // n times
        System.out.println(Arrays.toString(nums));
    }


    // Big O: O(n log n)
    private static void mergeSort(int[] nums) {
        if (nums.length <= 1) return;
        int midL = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, midL);
        int[] right = Arrays.copyOfRange(nums, midL, nums.length);
        mergeSort(left);
        mergeSort(right);
        merge(nums, left, right);
    }

    private static void merge(int[] original, int[] left, int[] right) {
        int pL = 0, pR = 0, idx = 0;
        while (pL < left.length && pR < right.length)
            original[idx++] = (left[pL] < right[pR]) ? left[pL++] : right[pR++];
        while (pL < left.length) original[idx++] = left[pL++];
        while (pR < right.length) original[idx++] = right[pR++];
    }

}