package org.example.DataStructure.Trees;

public class Main {
    public static void main(String[] args) {
        SimpleTree<Integer> tree = new SimpleTree<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        tree.add(-10);
        tree.add(-9);
        tree.add(-8);
        tree.add(-7);
        tree.add(-6);
        tree.add(-5);
        tree.add(-4);
        tree.add(-3);
        tree.add(-2);
        tree.add(-1);

        tree.remove(10);
        tree.remove(8);
        tree.remove(6);
        tree.remove(4);
        tree.remove(2);
        tree.remove(999999999);
        tree.remove(-2);
        tree.remove(-4);
        tree.remove(-6);
        tree.remove(-8);
        tree.remove(-10);

        tree.add(4);
        tree.add(-2);
        tree.add(-4);

        /*
        result( saw with debugging):

                   1
               /        \
             -9          3
               \           \
                -7          5
                  \       /   \
                   -5    4     7
                     \          \
                      -3          9
                     /   \
                  -4      -1
                         /
                       -2
         */

    }
}
