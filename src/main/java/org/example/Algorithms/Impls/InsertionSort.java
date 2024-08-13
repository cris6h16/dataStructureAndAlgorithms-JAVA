package org.example.Algorithms.Impls;

import org.example.ArrayWithElements.MyUtilClass;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        String[] alphabet = {"z", "y", "x", "w", "v", "u", "t", "s", "r", "q", "p", "o", "n", "m", "l", "k", "j", "i", "h", "g", "f", "e", "d", "c", "b", "a"};
        insertionSort(alphabet);
        System.out.println(Arrays.toString(alphabet));
        System.out.println(MyUtilClass.isSorted(alphabet));
        /*
            [a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]
            true
         */

    }












    /* Time Complexity:
    Best Case:    O(n)        when the array is already sorted
    Worst Case:   O(n^2)      when the array is sorted in reverse order
    Average Case: O(n^2)      because of the two nested loops
     */
    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        int previousIdx;
        T current;

        for (int i = 1; i < arr.length; i++) {

            current = arr[i];
            previousIdx = i - 1;       // arr[j] > current

            while (previousIdx >= 0 && arr[previousIdx].compareTo(current) > 0) {
                arr[previousIdx + 1] = arr[previousIdx];
                previousIdx--;
            }

            arr[previousIdx + 1] = current;

        }
    }
}
