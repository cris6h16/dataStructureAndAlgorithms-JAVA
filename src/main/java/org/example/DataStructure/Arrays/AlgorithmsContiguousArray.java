package org.example.DataStructure.Arrays;

import java.util.concurrent.atomic.AtomicInteger;

public class AlgorithmsContiguousArray {

    AtomicInteger counter = new AtomicInteger(0);

    /*
        1. Given a sorted array of DISTINCT INTEGERS and a target value,
        return the index if the target is found. If not, return the index
        where it would be if it were inserted in order.
        You must write an algorithm with O(log n) runtime complexity.

        Example:
         - input: { 1, 3, 5, 7 }, target: 5
           output: 2

         - output: { 1, 3, 5, 7 }, target: 2
           output: 1

         - output: { 1, 3, 5, 7 }, target: 8
           output: 4

         - output: { 1, 3, 5, 7 }, target: 0
           output: 0
     */
    static <T extends Comparable<T>> int searchIdxVal(T[] arr, T target) {
        int from = 0;
        int to = arr.length - 1;

        while (from <= to) {
            int mid = from + (to - from) / 2; // prevent overflow
            if (arr[mid].compareTo(target) == 0) {
                return mid; // target found
            }
            if (arr[mid].compareTo(target) < 0) { // target is greater
                from = mid + 1;
            } else {
                to = mid - 1;
            }
        }

        // 'from' is the correct insertion point if target is not found
        return from;
    }

    /*
    Merge two sorted arrays
     */
    @SuppressWarnings("unchecked")
    static <T extends Object & Comparable<T>> T[] mergeSortedArrays(T[] arr1, T[] arr2) {
        T[] res = (T[]) new Object[arr1.length + arr2.length];
        int forInsertIdx = 0;
        int forTake1 = 0;
        int forTake2 = 0;
        T aux;

        while (forInsertIdx < res.length) {
            if (forTake1 < arr1.length && arr1[forTake1].compareTo(arr2[forTake2]) < 0) {
                aux = arr1[forTake1++];
            } else {
                aux = arr2[forTake2++];
            }
            res[forInsertIdx++] = aux;
        }

        return res;
    }


    static boolean isPalindrome(String str) {
        boolean is = true;
        char[] chars = str.toCharArray();
        int idxStart = 0;
        int idxEnd = chars.length - 1;
        while (idxStart <= idxEnd) {
            if (chars[idxStart] != chars[idxEnd]) {
                is = false;
                break;
            }
            idxStart++;
            idxEnd--;
        }
        return is;
    }

    // 1 + 2 + 3 + ... = sum
    // sum = n ( n + 1 ) / 2
    static Integer findMissingNumber(Integer[] arr) {
        int n = arr.length + 1;
        int sum = n * (n + 1) / 2;
        for (int val : arr) sum -= val;
        return sum;
    }

    static <T extends Number> void moveAllZerosToTheEnd(T[] arr) {
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
