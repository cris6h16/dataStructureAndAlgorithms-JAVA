package org.example.Algorithms.Impls;

public class BinarySearch {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 6};
        int toSearch;

        System.out.println("Nums in array");
        for (int i = 0; i < nums.length; i++) {
            toSearch = nums[i];
            System.out.println(
                    binarySearch(nums, toSearch) + ", " +
                            binarySearchRecursive(nums, 0, nums.length - 1, toSearch)
            );
        }

        System.out.println("Nums nonexistent in array");
        for (int i = 20; i < 27; i++) {
            toSearch = i;
            System.out.println(
                    binarySearch(nums, toSearch) + ", " +
                            binarySearchRecursive(nums, 0, nums.length - 1, toSearch)
            );
        }

    }

    // O(log n)
    public static <T extends Comparable<T>> int binarySearch(T[] nums, T target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (target.compareTo(nums[mid]) == 0) return mid;    // target == nums[mid]
            if (target.compareTo(nums[mid]) < 0) right = mid - 1;// target < nums[mid]
            else left = mid + 1;                                 // target > nums[mid]
        }

        return -1;
    }

    public static <T extends Comparable<T>> int binarySearchRecursive(T[] nums, int start, int end, T target) {
        if (start > end) return -1;

        int mid = (start + end) / 2;
        if (target.compareTo(nums[mid]) == 0) return mid;
        else if (target.compareTo(nums[mid]) < 0)
            return binarySearchRecursive(nums, start, mid - 1, target);
        else
            return binarySearchRecursive(nums, mid + 1, end, target);
    }

}
