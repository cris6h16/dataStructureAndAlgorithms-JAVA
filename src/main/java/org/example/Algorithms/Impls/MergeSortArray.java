package org.example.Algorithms.Impls;

import org.example.ArrayWithElements.MyUtilClass;

import java.util.Arrays;

public class MergeSortArray {

    // O( n log n)
    // n + n log n ==> , Overall by merge sort: n log n
    public static void main(String[] args) {
        Integer[] nums = {8, 0, -10, 17, 2, 101, 0, -1, 3};
        String[] strs = {"z", "a", "c", "b", "d", "e", "f", "g", "h", "i", "j", "k", "l"};

        mergeSort(nums, 0, nums.length - 1);
        mergeSort(strs, 0, strs.length - 1);
        System.out.printf(
                "%s\n%s",
                Arrays.toString(nums),
                Arrays.toString(strs)
        );
        /*
            [-10, -1, 0, 0, 2, 3, 8, 17, 101]
            [a, b, c, d, e, f, g, h, i, j, k, l, z]
         */
    }


    /*
    Time complexity:
        - O(n log n)    log n:nums of division, n: nums of comparison
    Space complexity:
        - O(n)  // n: nums of comparison
     */
    public static <T extends Comparable<T>> void mergeSort(T[] finalArr, int fromIdx, int toIdx) {
        //best case
        int length = toIdx - fromIdx + 1;
        if (length < 2) return;

        //recursively until hit the best case
        int mid = fromIdx + (toIdx - fromIdx) / 2;
        mergeSort(finalArr, fromIdx, mid);
        mergeSort(finalArr, mid + 1, toIdx);

        mergeSortedArrays(finalArr, fromIdx, toIdx, mid);
    }

    private static <T extends Object & Comparable<T>> void mergeSortedArrays(T[] finalArr, int fromIdx, int toIdx, int mid) {
        T[] arr1 = Arrays.copyOfRange(finalArr, fromIdx, mid + 1); // mid included
        T[] arr2 = Arrays.copyOfRange(finalArr, mid + 1, toIdx + 1); // mid excluded
        int idx1 = 0;
        int idx2 = 0;
        T aux;


        while (idx1 < arr1.length && idx2 < arr2.length) {
            // arr1[idx1] is smaller
            if (arr1[idx1].compareTo(arr2[idx2]) < 0) {
                aux = arr1[idx1++];
            } else {
                aux = arr2[idx2++];
            }
            finalArr[fromIdx++] = aux;
        }

        while (idx1 < arr1.length) finalArr[fromIdx++] = arr1[idx1++];
        while (idx2 < arr2.length) finalArr[fromIdx++] = arr2[idx2++];
    }
}
