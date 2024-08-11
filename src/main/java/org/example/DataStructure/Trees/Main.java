package org.example.DataStructure.Trees;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BinaryTreeImpl<Integer> tree = new BinaryTreeImpl<>();
        tree.add(1);
        tree.add(-2);
        tree.add(3);
        tree.add(-4);
        tree.add(5);
        tree.add(7);
        tree.add(-7);
        tree.add(1);
        tree.add(0);
        tree.add(10);
        tree.add(-10);
        tree.add(9);
        tree.add(-8);
        tree.add(-7);
        tree.add(7);
        tree.add(-5);
        tree.add(-4);
        tree.add(3);
        tree.add(-2);
        tree.add(6);

        /*
                                     1
                                 /         \
                               -2            3
                            /      \       /   \
                          -4        1     3      5
                          /  \     /              \
                        -7   -2   0                7
                       /   \                      /  \
                    -10     -5                   7    10
                       \       \                /     /
                       -8       -4             6     9
                          \
                           -7
                                               
         */
        System.out.println("\nIN_ORDER: left -> root -> right");
        System.out.println(Arrays.toString(tree.toArray(BinaryTreeImpl.ETraversalOrder.IN_ORDER)));
        /*
            left -> root -> right
            [-10, -8, -7, -7, -5, -4, -4, -2, -2, 0, 1, 1, 3, 3, 5, 6, 7, 7, 9, 10]
         */

        System.out.println("\nPRE_ORDER: root -> left -> right");
        System.out.println("PRE_ORDER (STACK): root -> left -> right");
        System.out.println(Arrays.toString(tree.toArray(BinaryTreeImpl.ETraversalOrder.PRE_ORDER)));
        System.out.println(Arrays.toString(tree.toArray(BinaryTreeImpl.ETraversalOrder.PRE_ORDER_STACK)));
        /*
            PRE_ORDER: root -> left -> right
            PRE_ORDER (STACK): root -> left -> right
            [1, -2, -4, -7, -10, -8, -7, -5, -4, -2, 1, 0, 3, 3, 5, 7, 7, 6, 10, 9]
            [1, -2, -4, -7, -10, -8, -7, -5, -4, -2, 1, 0, 3, 3, 5, 7, 7, 6, 10, 9]
         */

        System.out.println("\nPOST_ORDER: left -> right -> root");
        System.out.println("\nPOST_ORDER(ITERATION): left -> right -> root");
        System.out.println(Arrays.toString(tree.toArray(BinaryTreeImpl.ETraversalOrder.POST_ORDER)));
        System.out.println(Arrays.toString(tree.toArray(BinaryTreeImpl.ETraversalOrder.POST_ORDER_ITERATION)));
        /*
            left -> right -> root
            [-7, -8, -10, -4, -5, -7, -2, -4, 0, 1, -2, 3, 6, 7, 9, 10, 7, 5, 3, 1]
         */

        System.out.println("\nLEVEL_ORDER: level by level");
        System.out.println(Arrays.toString(tree.toArray(BinaryTreeImpl.ETraversalOrder.LEVEL_ORDER)));
        /*
            LEVEL_ORDER: level by level
            [1, -2, 3, -4, 1, 3, 5, -7, -2, 0, 7, -10, -5, 7, 10, -8, -4, 6, 9, -7]
         */

        System.out.printf("\n\nDeleted: \n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
                tree.remove(10),
                tree.remove(8),
                tree.remove(6),
                tree.remove(4),
                tree.remove(2),
                tree.remove(999999999),
                tree.remove(-2),
                tree.remove(-4),
                tree.remove(-6),
                tree.remove(-8),
                tree.remove(-10)
        );

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
