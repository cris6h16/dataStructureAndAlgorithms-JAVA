package org.example.Algorithms.Impls;

import org.example.ArrayWithElements.MyUtilClass;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BogoSort {
    // subroutines: isSorted, shuffle
    public static <T extends Comparable<T>> void bogoSort(T[] arr) {
        while (MyUtilClass.isSorted(arr)) shuffle(arr);
    }

    private static <T extends Comparable<T>> void shuffle(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int idx = (i) + (int) (Math.random() * (arr.length - 1 - i + 1));
            T temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
    }

}
