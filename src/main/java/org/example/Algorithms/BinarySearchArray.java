package org.example.Algorithms;

public class BinarySearchArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int toSearch;

        // O(n log n)
        System.out.println("Nums in array");
        // n
        for (int i = 0; i < nums.length; i++) {
            toSearch = nums[i];

            System.out.println(
                    // log n
                    binarySearch(nums, toSearch) + ", " +
                    // log n
                    binarySearchR(nums, 0, nums.length - 1, toSearch)
            );
        }

        // O( log n)
        System.out.println("Nums nonexistent in array");
        for (int i = 20; i < 27; i++) {
            toSearch = i;

            System.out.println(
                    // log n
                    binarySearch(nums, toSearch) + ", " +
                    // log n
                    binarySearchR(nums, 0, nums.length - 1, toSearch)
            );
        }

    }

    // O(log n)
    public static int binarySearch(int[] nums, int val) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (val == nums[mid]) return mid;       // if val is in middle
            if (val < nums[mid]) right = mid - 1;   // if val is less
            else left = mid + 1;                    // if val is greater
        }
        return -1;
    }

    // Complexity: O(log n)
    public static int binarySearchR(int[] nums, int start, int end, int val) {
        if (start > end) return -1;

        int mid = (start + end) / 2;
        if (nums[mid] == val) return mid;
        else if (val < nums[mid]) return binarySearchR(nums, start, mid - 1, val);
        else return binarySearchR(nums, mid + 1, end, val);
    }

}
