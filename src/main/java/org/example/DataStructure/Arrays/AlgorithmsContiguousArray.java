package org.example.DataStructure.Arrays;

import java.util.Arrays;

public class AlgorithmsContiguousArray {

    public static void main(String[] args) {
        Integer[][] arr = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8}
        };


        _print(
                removeEvenIntegers(arr[0]),
                removeEvenIntegers(arr[1]),
                removeEvenIntegers(arr[2])
        );
        /*
        [1, 3, 5, 7, 9]
        [1, 3, 5, 7, 9]
        [1, 3, 5, 7]
         */

        reverseAnArray(arr[0], 0, arr[0].length - 1);
        reverseAnArray(arr[1], 0, arr[1].length - 1);
        reverseAnArray(arr[2], 0, arr[2].length - 1);
        _print(arr);
        /*
        [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
        [9, 8, 7, 6, 5, 4, 3, 2, 1]
        [8, 7, 6, 5, 4, 3, 2, 1]
         */
    }


    public static Integer[] removeEvenIntegers(Integer[] arr) { // receive a copy of the reference
        int odds = 0;
        for (int val : arr) {
            if (val % 2 != 0) {
                odds++;
            }
        }

        int[] res = new int[odds];
        int idx = 0;
        for (int i = 0; (i < arr.length) && (idx <= res.length - 1); i++) {
            if (arr[i] % 2 != 0) {
                res[idx++] = arr[i];
            }
        }
        // arr = res; // we can't
        return res;
    }

    public static int

    public static <T> void reverseAnArray(T[] arr, int idxStart, int idxEnd) {
        if (idxStart >= idxEnd) return;
        _swap(arr, idxStart, idxEnd);
        reverseAnArray(arr, ++idxStart, --idxEnd);
    }

    public static <T> void _swap(T[] arr, int idx1, int idx2) {
        T tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    public static <T> void _print(T[]... arr) {
        for (T[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}
