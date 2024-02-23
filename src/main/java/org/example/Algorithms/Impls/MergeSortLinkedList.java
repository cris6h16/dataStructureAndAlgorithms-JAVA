package org.example.Algorithms.Impls;

import org.example.ArrayWithElements.MyUtilClass;
import org.example.DataStructure.LinkedList.LinkedList;
import org.example.DataStructure.LinkedList.Node;

import java.util.Arrays;
import java.util.stream.Stream;

public class MergeSortLinkedList {
    public static void main(String[] args) {
        String[] numsArr = MyUtilClass.getNamesArray();
        LinkedList<String> nums = new LinkedList<>("Hello");
        Arrays.stream(numsArr).forEach(nums::prepend);

        System.out.println("Before: is SORTED? :" + MyUtilClass.isSorted(nums));
        mergeSort(nums);

        System.out.println("After: is SORTED? :" + MyUtilClass.isSorted(nums) + " with elements count: " + nums.size());

    }

    // subroutines: -> split -> merge
    // O(n log n)
    public static <T extends Comparable<T>> void mergeSort(LinkedList<T> list) {
        int sz = list.size(); // is O(n), but we can improve to O(1)
        if (sz <= 1)
            return;

        Node<T> mid = list.getByIndex(sz / 2);
        LinkedList<T> left = new LinkedList<>(list.getHead()); // [ head, mid ]
        LinkedList<T> right = new LinkedList<>(mid.getNext());//  ( mid, Tail ]
        mid.setNext(null);

        mergeSort(left);
        mergeSort(right);

        merge(list, left, right);
    }

    // n/2 = O(n)
    public static <T extends Comparable<T>> void merge(LinkedList<T> list,
                                                       LinkedList<T> left,
                                                       LinkedList<T> right) {
        Node<T> cL = left.getHead(); //current node left
        Node<T> cR = right.getHead();//current node right

        Node<T> fN; // first node of sorted
        Node<T> cN; // current node of sorted

        if (cR.getData().compareTo(cL.getData()) > 0) { //cR.getData() > cL.getData()
            fN = cL;
            cL = cL.getNext();
        } else {
            fN = cR;
            cR = cR.getNext();
        }

        cN = fN; // current is first node of sorted

        while (cL != null && cR != null) {
            if (cR.getData().compareTo(cL.getData()) > 0) {//cR.getData() > cL.getData()
                cN.setNext(cL);
                cL = cL.getNext();
            } else {
                cN.setNext(cR);
                cR = cR.getNext();
            }
            cN = cN.getNext();
        }
        while (cR != null) {
            cN.setNext(cR);
            cN = cN.getNext();
            cR = cR.getNext();
        }
        while (cL != null) {
            cN.setNext(cL);
            cN = cN.getNext();
            cL = cL.getNext();
        }

        list.setHead(fN); // first node with all next references
    }


}
