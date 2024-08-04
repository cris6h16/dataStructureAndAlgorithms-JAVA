package org.example.DataStructure.Arrays;

public class AlgorithmsContiguousArray {


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
