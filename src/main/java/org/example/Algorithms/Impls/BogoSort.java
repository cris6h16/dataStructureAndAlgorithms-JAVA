package org.example.Algorithms.Impls;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BogoSort {
    static int c = 0;

    public static void main(String[] args) {
        Integer[] arr = {10, 77, 52,-52,0};

        System.out.println("Before sorting: " + Arrays.toString(arr));

        bogoSort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr) + " attempts: " + c);
    }

    // subroutines: isSorted, shuffle
    public static <T extends Comparable<T>> void bogoSort(T[] arr) {
        while (isSorted(arr)) shuffle(arr);
    }

    private static <T extends Comparable<T>> void shuffle(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int idx = (i) + (int) (Math.random() * (arr.length - 1 - i + 1));
            T temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
    }

    private static <T extends Comparable<T>> boolean isSorted(T[] arr) {
        c++;
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i].compareTo(arr[i + 1]) > 0) //arr[i] > arr[i + 1]
                return true;
        return false;
    }
}
