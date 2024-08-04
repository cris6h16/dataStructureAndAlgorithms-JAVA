package org.example.DataStructure.Arrays;

import java.util.Arrays;

public class AlgorithmsContiguousArray {

    public static void main(String[] args) {
        Integer[][] arr = {
                {1, 2, 3, 4, 5, 6, 7, 8, -9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, -9},
                {-1, 2, 3, 4, 5, 6, 7, 8}
        };


        System.out.printf(
                "\n%s\n%s\n%s\n\n",
                Arrays.toString(removeEvenIntegers(arr[0])),
                Arrays.toString(removeEvenIntegers(arr[1])),
                Arrays.toString(removeEvenIntegers(arr[2]))
        );
        /*
            [1, 3, 5, 7, -9]
            [1, 3, 5, 7, -9]
            [-1, 3, 5, 7]
         */

        System.out.printf(
                "\n%s\n%s\n%s\n\n",
                findMinimum(arr[0], 0),
                findMinimum(arr[1], 0),
                findMinimum(arr[2], 0)
        );
        /*
            -9
            -9
            -1
         */

        System.out.printf(
                "\n%s\n%s\n%s\n\n",
                findSecondGreatest(arr[0]),
                findSecondGreatest(arr[1]),
                findSecondGreatest(arr[2])
        );
        /*
            8
            7
            7
         */

        reverseAnArray(arr[0], 0, arr[0].length - 1);
        reverseAnArray(arr[1], 0, arr[1].length - 1);
        reverseAnArray(arr[2], 0, arr[2].length - 1);
        System.out.printf(
                "\n%s\n%s\n%s\n\n",
                Arrays.toString(arr[0]),
                Arrays.toString(arr[1]),
                Arrays.toString(arr[2])
        );
        /*
            [10, -9, 8, 7, 6, 5, 4, 3, 2, 1]
            [-9, 8, 7, 6, 5, 4, 3, 2, 1]
            [8, 7, 6, 5, 4, 3, 2, -1]
         */
    }


    public static Integer[] removeEvenIntegers(Integer[] arr) { // receive a copy of the reference
        int odds = 0;
        for (int val : arr) {
            if (val % 2 != 0) {
                odds++;
            }
        }

        Integer[] res = new Integer[odds];
        int idx = 0;
        for (int i = 0; (i < arr.length) && (idx <= res.length - 1); i++) {
            if (arr[i] % 2 != 0) {
                res[idx++] = arr[i];
            }
        }
        // arr = res; // we can't
        return res;
    }

    public static <T extends Comparable<T>> T findSecondGreatest(T[] arr) {
        if (arr.length < 2) throw new IllegalArgumentException();

        T greatest = arr[0];
        T secondGreatest = null;
        for (T t : arr) {
            if (t.compareTo(greatest) > 0) { // arr[i] > greatest
                secondGreatest = greatest;
                greatest = t;
            } else if (t.compareTo(greatest) != 0 && (secondGreatest == null || t.compareTo(secondGreatest) > 0)) { // t != greatest && (secondGreatest == null || t > secondGreatest)
                secondGreatest = t;
            }
        }

        return secondGreatest == null ? greatest : secondGreatest; // if there is no second greatest, return the greatest, we can throw an exception if we want
    }


    public static <T extends Comparable<T>> T findMinimum(T[] arr, int idxStart) {
        if (idxStart == arr.length - 1) return arr[idxStart];
        else if (idxStart > arr.length - 1) throw new IllegalArgumentException();
        T current = arr[idxStart];
        T minimum = findMinimum(arr, idxStart + 1);
        return minimum.compareTo(current) < 0 ? minimum : current;
    }

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


}
