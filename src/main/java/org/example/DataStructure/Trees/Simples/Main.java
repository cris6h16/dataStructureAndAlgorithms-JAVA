package org.example.DataStructure.Trees.Simples;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //testing
        binaryTree();
        binarySearchTree();

        // algorithms
        isBSTValid();

    }

    private static void isBSTValid() {
        BinarySearchTreeImpl<Integer> bst = new BinarySearchTreeImpl<Integer>();
        bst.add(1);
        bst.add(-2);
        bst.add(3);
        bst.add(-4);
        bst.add(5);
        bst.add(7);
        bst.add(-7);
        bst.add(1);
        bst.add(0);
        bst.add(10);
        bst.add(-10);
        bst.add(9);
        bst.add(-8);
        bst.add(-7);
        bst.add(7);
        bst.add(-5);
        bst.add(-4);
        bst.add(3);
        bst.add(-2);
        bst.add(6);

        System.out.println("\n\n\n\n\nIsBSTValid: ");
        System.out.println("IsBSTValid: " + bst.isValid());

        bst.root.left.left.right.data = 9999;

        System.out.println("\nIsBSTValid: ");
        System.out.println("IsBSTValid: " + bst.isValid());

        bst.root.left.left.right.data = -9999;

        System.out.println("\nIsBSTValid: ");
        System.out.println("IsBSTValid: " + bst.isValid());
    }

    private static void binarySearchTree() {
        System.out.println("\n\n\n\n\nBinarySearchTree: ");
        BinaryTreeImpl<Integer> bst = new BinarySearchTreeImpl<Integer>();
        bst.add(1);
        bst.add(-2);
        bst.add(3);
        bst.add(-4);
        bst.add(5);
        bst.add(7);
        bst.add(-7);
        bst.add(1);
        bst.add(0);
        bst.add(10);
        bst.add(-10);
        bst.add(9);
        bst.add(-8);
        bst.add(-7);
        bst.add(7);
        bst.add(-5);
        bst.add(-4);
        bst.add(3);
        bst.add(-2);
        bst.add(6);
         /* I see this using the debugger
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
        System.out.println("BinarySearchTree height: " + bst.height());
        /*
            BinarySearchTree height: 7
         */

        System.out.println("\n\nContains: ");
        Integer[] nums = new Integer[]{1, -2, 3, -4, 1, 3, 5, -7, -2, 0, 7, -10, -5, 7, 10, -8, -4, 6, 9, -7, 999999999, -999999999}; // just the 2 last are not in the tree
        String arr = Arrays.stream(nums)
                .map(num -> num + ": " + bst.contains(num))
                .collect(
                        Collectors.joining("\n", "[\n", "\n]")
                );
        System.out.println(arr);
        /*
            Contains:
            [
            1: true
            -2: true
            3: true
            -4: true
            1: true
            3: true
            5: true
            -7: true
            -2: true
            0: true
            7: true
            -10: true
            -5: true
            7: true
            10: true
            -8: true
            -4: true
            6: true
            9: true
            -7: true
            999999999: false
            -999999999: false
            ]
         */

        System.out.printf(
                "\nBigger: %s\nSmaller: %s\n",
                bst.getMax(),
                bst.getMin()
        );
        /*
            Bigger: 10
            Smaller: -10
         */
    }

    public static void binaryTree() {
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

        /* I see this using the debugger
                                     1
                                 /         \
                              -10           -2
                            /                 \
                           9                    3
                          /                       \
                        -8                         -4
                       /                             \
                    -7                                5
                    /                                   \
                   7                                     7
                  /                                        \
                -5                                          -7
               /                                              \
             -4                                                 1
             /                                                    \
            3                                                       0
           /                                                          \
          -2                                                           10
         /
        6

       size: 20
         */
        System.out.println("\nIN_ORDER: left -> root -> right");
        System.out.println(Arrays.toString(tree.toArray(BinaryTreeImpl.ETraversalOrder.IN_ORDER)));
        /*
            IN_ORDER: left -> root -> right
            [6, -2, 3, -4, -5, 7, -7, -8, 9, -10, 1, -2, 3, -4, 5, 7, -7, 1, 0, 10]
         */

        System.out.println("\nPRE_ORDER: root -> left -> right");
        System.out.println("PRE_ORDER (STACK): root -> left -> right");
        System.out.println(Arrays.toString(tree.toArray(BinaryTreeImpl.ETraversalOrder.PRE_ORDER)));
        System.out.println(Arrays.toString(tree.toArray(BinaryTreeImpl.ETraversalOrder.PRE_ORDER_STACK)));
        /*
            PRE_ORDER: root -> left -> right
            PRE_ORDER (STACK): root -> left -> right
            [1, -10, 9, -8, -7, 7, -5, -4, 3, -2, 6, -2, 3, -4, 5, 7, -7, 1, 0, 10]
            [1, -10, 9, -8, -7, 7, -5, -4, 3, -2, 6, -2, 3, -4, 5, 7, -7, 1, 0, 10]
         */

        System.out.println("\nPOST_ORDER: left -> right -> root");
        System.out.println("POST_ORDER(ITERATION): left -> right -> root");
        System.out.println(Arrays.toString(tree.toArray(BinaryTreeImpl.ETraversalOrder.POST_ORDER)));
        System.out.println(Arrays.toString(tree.toArray(BinaryTreeImpl.ETraversalOrder.POST_ORDER_ITERATION)));
        /*
            POST_ORDER: left -> right -> root
            POST_ORDER(ITERATION): left -> right -> root
            [6, -2, 3, -4, -5, 7, -7, -8, 9, -10, 10, 0, 1, -7, 7, 5, -4, 3, -2, 1]
            [6, -2, 3, -4, -5, 7, -7, -8, 9, -10, 10, 0, 1, -7, 7, 5, -4, 3, -2, 1]
         */

        System.out.println("\nLEVEL_ORDER: level by level");
        System.out.println(Arrays.toString(tree.toArray(BinaryTreeImpl.ETraversalOrder.LEVEL_ORDER)));
        /*
            LEVEL_ORDER: level by level
            [1, -10, -2, 9, 3, -8, -4, -7, 5, 7, 7, -5, -7, -4, 1, 3, 0, -2, 10, 6]
         */

        System.out.printf(
                "\nBigger: %s\nSmaller: %s\n",
                tree.getMax(),
                tree.getMin()
        );
        /*
            Bigger: 10
            Smaller: -10
         */

        System.out.println("\n\nContains: ");
        Integer[] nums = new Integer[]{1, -2, 3, -4, 1, 3, 5, -7, -2, 0, 7, -10, -5, 7, 10, -8, -4, 6, 9, -7, 999999999, -999999999}; // just the 2 last are not in the tree
        String arr = Arrays.stream(nums)
                .map(num -> num + ": " + tree.contains(num))
                .collect(
                        Collectors.joining("\n", "[\n", "\n]")
                );
        System.out.println(arr);
        /*
            Contains:
            [
            1: true
            -2: true
            3: true
            -4: true
            1: true
            3: true
            5: true
            -7: true
            -2: true
            0: true
            7: true
            -10: true
            -5: true
            7: true
            10: true
            -8: true
            -4: true
            6: true
            9: true
            -7: true
            999999999: false
            -999999999: false
            ]
         */

        System.out.println("BinaryTree height: " + tree.height());
        /*
            BinaryTree height: 11
         */
    }
}

//BinaryTreeImpl<Integer> tree = new BinaryTreeImpl<>();
//        tree.add(1);
//        tree.add(-2);
//        tree.add(3);
//        tree.add(-4);
//        tree.add(5);
//        tree.add(7);
//        tree.add(-7);
//        tree.add(1);
//        tree.add(0);
//        tree.add(10);
//        tree.add(-10);
//        tree.add(9);
//        tree.add(-8);
//        tree.add(-7);
//        tree.add(7);
//        tree.add(-5);
//        tree.add(-4);
//        tree.add(3);
//        tree.add(-2);
//        tree.add(6);
//
//        /*
//                                     1
//                                 /         \
//                               -2            3
//                            /      \       /   \
//                          -4        1     3      5
//                          /  \     /              \
//                        -7   -2   0                7
//                       /   \                      /  \
//                    -10     -5                   7    10
//                       \       \                /     /
//                       -8       -4             6     9
//                          \
//                           -7
//
//         */
//        System.out.println("\nIN_ORDER: left -> root -> right");
//        System.out.println(Arrays.toString(tree.toArray(BinaryTreeImpl.ETraversalOrder.IN_ORDER)));
//        /*
//            left -> root -> right
//            [-10, -8, -7, -7, -5, -4, -4, -2, -2, 0, 1, 1, 3, 3, 5, 6, 7, 7, 9, 10]
//         */
//
//        System.out.println("\nPRE_ORDER: root -> left -> right");
//        System.out.println("PRE_ORDER (STACK): root -> left -> right");
//        System.out.println(Arrays.toString(tree.toArray(BinaryTreeImpl.ETraversalOrder.PRE_ORDER)));
//        System.out.println(Arrays.toString(tree.toArray(BinaryTreeImpl.ETraversalOrder.PRE_ORDER_STACK)));
//        /*
//            PRE_ORDER: root -> left -> right
//            PRE_ORDER (STACK): root -> left -> right
//            [1, -2, -4, -7, -10, -8, -7, -5, -4, -2, 1, 0, 3, 3, 5, 7, 7, 6, 10, 9]
//            [1, -2, -4, -7, -10, -8, -7, -5, -4, -2, 1, 0, 3, 3, 5, 7, 7, 6, 10, 9]
//         */
//
//        System.out.println("\nPOST_ORDER: left -> right -> root");
//        System.out.println("\nPOST_ORDER(ITERATION): left -> right -> root");
//        System.out.println(Arrays.toString(tree.toArray(BinaryTreeImpl.ETraversalOrder.POST_ORDER)));
//        System.out.println(Arrays.toString(tree.toArray(BinaryTreeImpl.ETraversalOrder.POST_ORDER_ITERATION)));
//        /*
//            left -> right -> root
//            [-7, -8, -10, -4, -5, -7, -2, -4, 0, 1, -2, 3, 6, 7, 9, 10, 7, 5, 3, 1]
//         */
//
//        System.out.println("\nLEVEL_ORDER: level by level");
//        System.out.println(Arrays.toString(tree.toArray(BinaryTreeImpl.ETraversalOrder.LEVEL_ORDER)));
//        /*
//            LEVEL_ORDER: level by level
//            [1, -2, 3, -4, 1, 3, 5, -7, -2, 0, 7, -10, -5, 7, 10, -8, -4, 6, 9, -7]
//         */
//
//        System.out.printf(
//                "\nBigger: %s\nSmaller: %s\n",
//                tree.getMax(),
//                tree.getMin()
//        );
//        /*
//            LEVEL_ORDER: level by level
//            [1, -2, 3, -4, 1, 3, 5, -7, -2, 0, 7, -10, -5, 7, 10, -8, -4, 6, 9, -7]
//         */
//
//                System.out.printf("\n\nDeleted: \n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
//                                  tree.remove(10),
//                tree.remove(8),
//                tree.remove(6),
//                tree.remove(4),
//                tree.remove(2),
//                tree.remove(999999999),
//                tree.remove(-2),
//                tree.remove(-4),
//                tree.remove(-6),
//                tree.remove(-8),
//                tree.remove(-10)
//        );
//
//                tree.add(4);
//        tree.add(-2);
//        tree.add(-4);
//
//        /*
//        result( saw with debugging):
//
//                   1
//               /        \
//             -9          3
//               \           \
//                -7          5
//                  \       /   \
//                   -5    4     7
//                     \          \
//                      -3          9
//                     /   \
//                  -4      -1
//                         /
//                       -2
//         */
//
//
//    }
