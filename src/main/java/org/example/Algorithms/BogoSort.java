package org.example.Algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BogoSort {
    public static void main(String[] args) {
        Integer[] arr = {10, 1, 9, 2, 2};

        System.out.println("Before sorting: " + Arrays.toString(arr));

        bogoSort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
    // subroutines: isSorted, shuffle
    private static void bogoSort(Integer[] arr) {
        while (isSorted(arr)) shuffle(arr);
    }
    private static void shuffle(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int idx = (int) (Math.random() * arr.length);
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
    }
    private static boolean isSorted(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) if (arr[i] > arr[i + 1]) return true;
        return false;
    }
}
