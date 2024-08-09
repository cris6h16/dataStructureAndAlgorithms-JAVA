package org.example.DataStructure.Stack;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.stream.Collectors;

public class MIAN {
    public static void main(String[] args) {
        // test
        stackLinkedList();
        stackResizeableArray();

        // algorithms
        reverseString();
        findTheNextGreaterElement();
        bracketBalancing();
    }


    private static void bracketBalancing() {
        String[] vals = new String[]{"()", "()[]{}", "(]", "([)]", "{[]}", "[]{}", "[]{}{", "{[()]}", "{[()]{", "{()]"}; // 10
        System.out.printf("\n\n%s",
                Arrays.stream(vals)
                        .map(s -> s + " -> " + _bracketBalancing(s)) // "() -> true"
                        .collect(Collectors.joining("\n"))   // "() -> true\n()[]{} -> true\n...."
        );
        /*
            ()      -> true
            ()[]{}  -> true
            (]      -> false
            ([)]    -> false
            {[]}    -> true
            []{}    -> true
            []{}{   -> false
            {[()]}  -> true
            {[()]{  -> false
            {()]    -> false
         */
    }

    private static boolean _bracketBalancing(String str) {
        StackLinkedList<Character> s = new StackLinkedList<>();
        char[] chars = str.toCharArray();
        char prev;

        for (char c : chars) {
            prev = s.isEmpty() ? ' ' : s.peek();
            if ((prev == '{' && c == '}') || (prev == '[' && c == ']') || (prev == '(' && c == ')')) {
                         // not save the c
                s.pop(); // remove the previous
                continue;
            }
            s.push(c);
        }

        return s.isEmpty();
    }

    /*
    Given an array of integers, for each element contained in the array, find its next greater element inn the array.
    The next greater element is the first element to the right of the current element that is greater than the current element.

    If no greater element is found, return -1.

    EXAMPLE:
    IN                                          OUT
    [4, 7, 3, 4, 8, 1]          [7, 8, 4, 8, -1, -1]
    [3, 2, 1]                           [-1, -1, -1]
    [1, 2, 3, 4, 5]                 [2, 3, 4, 5, -1]
     */
    private static void findTheNextGreaterElement() {
        System.out.printf("\n\n%s\n%s\n%s",
                Arrays.toString(_findTheNextGreaterElement(new Integer[]{4, 7, 3, 4, 8, 1})),
                Arrays.toString(_findTheNextGreaterElement(new Integer[]{3, 2, 1})),
                Arrays.toString(_findTheNextGreaterElement(new Integer[]{1, 2, 3, 4, 5}))
        );
        /*
            [7, 8, 4, 8, -1, -1]
            [-1, -1, -1]
            [2, 3, 4, 5, -1]
         */
    }

    private static Integer[] _findTheNextGreaterElement(Integer[] arr) {
        StackResizeableArray<Integer> s = new StackResizeableArray<>();
        boolean greaterFound;

        for (int principal = 0; principal < arr.length; principal++) {              // range: [ idxStart ; idxEnd ]

            greaterFound = false;
            for (int toRight = principal + 1; toRight < arr.length; toRight++) {    // range: ( idxCurrentElement ; idxEnd ]
                if (arr[principal].compareTo(arr[toRight]) < 0) {   // principal is small
                    s.push(arr[toRight]);
                    greaterFound = true;
                    break; // just I need the first greater element
                }
            }
            if (!greaterFound) s.push(-1); // if no greater element found for principal

        }

        Integer[] res = new Integer[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) res[i] = s.pop(); // pop in reverse order ( LIFO )

        return res;
    }


    private static void reverseString() {
        System.out.printf("%s\n%s\n%s\n%s",
                _reverseString("Hello World!"),
                _reverseString("github.com/cris6h16"),
                _reverseString(""),
                _reverseString("1")
        );
        /*
            java.util.EmptyStackException
            !dlroW olleH
            61h6sirc/moc.buhtig

            1
         */
    }

    private static String _reverseString(String str) {
        StackLinkedList<Character> s = new StackLinkedList<>();
        for (char c : str.toCharArray()) s.push(c);
        StringBuilder sb = new StringBuilder();
        s.iterator().forEachRemaining(sb::append);
        return sb.toString();
    }

    private static void stackLinkedList() {

        Stack<Integer> s = new StackLinkedList<>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);
        s.push(9);
        s.push(10);
        s.push(11);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        try {
            System.out.println(s.pop());
        } catch (EmptyStackException e) {
            System.out.println(e.toString());
        }
        /*
            11
            10
            9
            8
            7
            6
            5
            4
            3
            2
            1
            java.util.EmptyStackException
         */

    }

    private static void stackResizeableArray() {
        StackResizeableArray<Integer> s1 = new StackResizeableArray<>();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.push(5);
        s1.push(6);
        s1.push(7);
        s1.push(8);
        s1.push(9);
        s1.push(10);
        s1.push(11);

        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        try {
            System.out.println(s1.pop());
        } catch (EmptyStackException e) {
            System.out.println(e.toString());
        }
        /*
            11
            10
            9
            8
            7
            6
            5
            4
            3
            2
            1
            java.util.EmptyStackException
         */
    }
}
