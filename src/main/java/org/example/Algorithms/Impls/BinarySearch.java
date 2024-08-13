package org.example.Algorithms.Impls;

import org.example.ArrayWithElements.MyUtilClass;

public class BinarySearch {
    public static void main(String[] args) {
        String[] alphabet = MyUtilClass.getAlphabetArray();
        Integer[] nums1to100 = MyUtilClass.generateSortedNUms(1, 100);

        // ---------------- Binary Search: O(log n) ---------------- \\

        System.out.println("Alphabet: Idx: " + binarySearch(alphabet, "g", 0, alphabet.length - 1)); // recursive
        System.out.println("Alphabet: Idx: " + binarySearchIteration(alphabet, "g")); // iterative
        /*
            m
            f
            i
            Alphabet: Idx: 6
            m
            f
            i
            Alphabet: Idx: 6
         */


        System.out.println("1 to 100: Idx: " + binarySearch(nums1to100, 100, 0, nums1to100.length - 1));
        System.out.println("1 to 100: Idx: " + binarySearchIteration(nums1to100, 100));
        /*
            50
            75
            88
            94
            97
            99
            1 to 100: Idx: 99
            50
            75
            88
            94
            97
            99
            1 to 100: Idx: 99
         */
    }

    // O(log n) - recursive
    public static <T extends Comparable<T>> int binarySearch(T[] arr, T val, int idxFrom, int idxTo) {
        if (arr == null) throw new IllegalArgumentException();
        int mid = (idxFrom + idxTo) / 2;
        // best case:
        if (idxFrom > idxTo) return -1;
        if (arr[mid].compareTo(val) == 0) return mid;
        System.out.println(arr[mid]);

        // recursively until hit the best case
        if (arr[mid].compareTo(val) < 0) { // val is greater
            return binarySearch(arr, val, mid + 1, idxTo);
        } else { // val is less
            return binarySearch(arr, val, idxFrom, mid - 1);
        }
    }

    // O(log n) - iterative
    public static <T extends Comparable<T>> int binarySearchIteration(T[] arr, T val) {
        int fromIdx = 0;
        int toIdx = arr.length - 1;
        while (fromIdx <= toIdx) {
            int mid = (fromIdx + toIdx) / 2;
            if (arr[mid].compareTo(val) == 0) return mid;

            System.out.println(arr[mid]);
            if (arr[mid].compareTo(val) < 0) fromIdx = mid + 1;
            else toIdx = mid - 1;
        }
        return -1;
    }

}
