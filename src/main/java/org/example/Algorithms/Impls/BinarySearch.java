package org.example.Algorithms.Impls;

import org.example.ArrayWithElements.MyUtilClass;

public class BinarySearch {
    public static void main(String[] args) {
        String[] nums = MyUtilClass.getNamesArray();
        String toSearch;

        QuickSort.quickSort(nums, 0, nums.length - 1);

        System.out.println("Existent in SORTED array");
        for (int i = 0; i < nums.length; i += 2100) {
            toSearch = nums[i];
            System.out.println(
                    "Value: " + toSearch + ", Index: " +
                            binarySearch(nums, toSearch) + ", " +
                            binarySearchRecursive(nums, 0, nums.length - 1, toSearch)
            );
        }

        System.out.println("nonexistent in SORTED array");
        for (int i = 0; i < 10; i++) {
            String value = "nonexistent" + i;
            System.out.println(
                    "Value: " + value + ", Index: " +
                            binarySearch(nums, value) + ", " +
                            binarySearchRecursive(nums, 0, nums.length - 1, value)
            );
        }

    }

    // O(log n)
    public static <T extends Comparable<T>> int binarySearch(T[] arrSorted,
                                                             T target) {
        int left = 0;
        int right = arrSorted.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (target.compareTo(arrSorted[mid]) == 0) return mid;    // target == nums[mid]
            if (target.compareTo(arrSorted[mid]) < 0) right = mid - 1;// target < nums[mid]
            else left = mid + 1;                                      // target > nums[mid]
        }

        return -1;
    }

    public static <T extends Comparable<T>> int binarySearchRecursive(T[] arrSorted,
                                                                      int start,
                                                                      int end,
                                                                      T target) {
        if (start > end) return -1;

        int mid = (start + end) / 2;
        if (target.compareTo(arrSorted[mid]) == 0) return mid;
        else if (target.compareTo(arrSorted[mid]) < 0)
            return binarySearchRecursive(arrSorted, start, mid - 1, target);
        else
            return binarySearchRecursive(arrSorted, mid + 1, end, target);
    }

}
