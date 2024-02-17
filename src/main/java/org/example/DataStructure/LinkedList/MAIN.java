package org.example.DataStructure.LinkedList;

public class MAIN {
    public static void main(String[] args) {
        LinkedList<Integer> nums = new LinkedList<Integer>(1);
        nums.prepend(2);
        nums.prepend(3);
        nums.prepend(4);
        nums.prepend(5);

        nums.delete(1);

        System.out.println(nums);
    }
}
