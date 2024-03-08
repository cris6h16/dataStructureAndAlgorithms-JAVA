package org.example.DataStructure.Trees.AVLTrees;

public class Main {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(7);
        tree.add(-7);
        tree.add(-17);
        tree.add(20);
        /*
        RESULT: (saw in debug)
                       4
                    /      \
                 2           6
               /   \       /   \
             -7     3     5     7
            /  \              /   \
         -17    1            7     20

         */
    }
}
