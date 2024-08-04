package org.example.DataStructure.Arrays;

import java.util.Arrays;
import java.util.function.Function;

public class AlgorithmsContiguousArray {

    public static void main(String[] args) {
        Integer[][] arr = new Integer[10][]; // initialize the array but not the inner arrays


        //||||||||||||||||||||||||||||||||||||||||||||||||||||\\
        //||||||||||||||| REMOVE EVEN INTEGERS |||||||||||||||\\
        //||||||||||||||||||||||||||||||||||||||||||||||||||||\\
        arr[0] = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, -9, 10};
        arr[1] = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, -9};
        arr[2] = new Integer[]{-1, 2, 3, 4, 5, 6, 7, 8};
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

        //||||||||||||||||||||||||||||||||||||||||||||||||||||\\
        //||||||||||||||||| FIND THE MINIMUM |||||||||||||||||\\
        //||||||||||||||||||||||||||||||||||||||||||||||||||||\\
        arr[0] = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, -9, 10};
        arr[1] = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, -9};
        arr[2] = new Integer[]{-1, 2, 3, 4, 5, 6, 7, 8};
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

        //||||||||||||||||||||||||||||||||||||||||||||||||||||\\
        //||||||||||||| FIND THE SECOND GREATEST |||||||||||||\\
        //||||||||||||||||||||||||||||||||||||||||||||||||||||\\
        arr[0] = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, -9, 10};
        arr[1] = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, -9};
        arr[2] = new Integer[]{-1, 2, 3, 4, 5, 6, 7, 8};
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


        //||||||||||||||||||||||||||||||||||||||||||||||||||||\\
        //|||||||||||| MOVE ALL ZEROS TO THE END |||||||||||||\\
        //||||||||||||||||||||||||||||||||||||||||||||||||||||\\
        arr[0] = new Integer[]{0, 2, 3, 4, 5, 6, 7, 8, -9, 0};
        arr[1] = new Integer[]{1, 2, 3, 0, 5, 6, 7, 0, -9};
        arr[2] = new Integer[]{-1, 0, 3, 4, 5, 6, 7, 0};
        arr[3] = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0};
        arr[4] = new Integer[]{0, 0, 0, 0, 0, 0, 0, Integer.MIN_VALUE};

        moveAllZerosToTheEnd(arr[0]);
        moveAllZerosToTheEnd(arr[1]);
        moveAllZerosToTheEnd(arr[2]);
        moveAllZerosToTheEnd(arr[3]);
        moveAllZerosToTheEnd(arr[4]);
        System.out.printf(
                "\n%s\n%s\n%s\n%s\n%s\n\n",
                Arrays.toString(arr[0]),
                Arrays.toString(arr[1]),
                Arrays.toString(arr[2]),
                Arrays.toString(arr[3]),
                Arrays.toString(arr[4])
        );
        /*
            [-9, 2, 3, 4, 5, 6, 7, 8, 0, 0]
            [1, 2, 3, -9, 5, 6, 7, 0, 0]
            [-1, 7, 3, 4, 5, 6, 0, 0]
            [0, 0, 0, 0, 0, 0, 0, 0]
            [-2147483648, 0, 0, 0, 0, 0, 0, 0]
         */


        //||||||||||||||||||||||||||||||||||||||||||||||||||||\\
        //||||||||||||||||| REVERSE AN ARRAY |||||||||||||||||\\
        //||||||||||||||||||||||||||||||||||||||||||||||||||||\\
        arr[0] = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, -9, 10};
        arr[1] = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, -9};
        arr[2] = new Integer[]{-1, 2, 3, 4, 5, 6, 7, 8};
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

    private static <T extends Number> void moveAllZerosToTheEnd(T[] arr) {
        int idxL = 0;               // left
        int idxR = arr.length - 1;  // right
        while (true) {
            while (idxL <= arr.length - 1 && !arr[idxL].equals(0)) idxL++;
            while (idxR >= 0 && arr[idxR].equals(0)) idxR--;
            if (idxL > idxR) break;
            _swap(arr, idxL, idxR);
        }
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
            if (t.compareTo(greatest) > 0) { // t > greatest
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
