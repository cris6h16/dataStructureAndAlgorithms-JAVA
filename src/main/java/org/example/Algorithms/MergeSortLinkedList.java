package org.example.Algorithms;

import org.example.DataStructure.LinkedList.LinkedList;
import org.example.DataStructure.LinkedList.Node;

import java.util.stream.Stream;

public class MergeSortLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> nums = new LinkedList<Integer>(1);
        nums
                .prepend(2)
                .prepend(3)
                .prepend(4)
                .prepend(5)
                .prepend(452)
                .prepend(6)
                .prepend(7)
                .prepend(8);
        System.out.println("LINKED LIST:\n" + nums);

        mergeSort(nums);

        System.out.println("SORTED:\n" + nums);

    }

    // subroutines: -> split -> merge
    // O(n log n)
    public static void mergeSort(LinkedList<Integer> list) {

        int sz = list.getSize(); // O(1)
        if (sz <= 1) return;

        Node<Integer> mid = list.getByIndex(sz / 2);
        var left = new LinkedList<>(list.getHead()); // [ head, mid ]
        var right = new LinkedList<>(mid.getNext());// ( mid, Tail ]
        mid.setNext(null);

        mergeSort(left);
        mergeSort(right);

        merge(list, left, right);
    }

    // n/2 = O(n)
    public static void merge(LinkedList<Integer> list, LinkedList<Integer> left, LinkedList<Integer> right) {
        Node<Integer> cL = left.getHead(); //current node left
        Node<Integer> cR = right.getHead();//current node right

        Node<Integer> fN; // first node of sorted
        Node<Integer> cN; // current node of sorted

        if (cR.getData() > cL.getData()) {
            fN = cL;
            cL = cL.getNext();
        } else {
            fN = cR;
            cR = cR.getNext();
        }

        cN = fN; // current is first node of sorted

        while (cL != null && cR != null) {
            if (cR.getData() > cL.getData()) {
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
