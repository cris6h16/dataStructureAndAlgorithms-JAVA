package org.example.Algorithms;

public class Algorithms {

    static final Integer[][] spiral4x4Matrix = new Integer[][]{
            {1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 16, 15, 6},
            {10, 9, 8, 7}
    };
    static final Integer[][] spiral1x10Matrix = {
            {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}
    };

    static final Integer[][] spiral10x1Matrix = {
            {10},
            {20},
            {30},
            {40},
            {50},
            {60},
            {70},
            {80},
            {90},
            {100}
    };

    static final Integer[][] spiral1x1Matrix = {
            {10}
    };
    static final Integer[][] spiral0x0Matrix = {
    };


    static final Integer[][] matrix = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
    };

    public static void main(String[] args) {


        sortedMatrixEfficientKeyFinder(matrix, 10);
        sortedMatrixEfficientKeyFinder(matrix, 20);
        sortedMatrixEfficientKeyFinder(matrix, 30);
        sortedMatrixEfficientKeyFinder(matrix, 40);
        sortedMatrixEfficientKeyFinder(matrix, 15);
        sortedMatrixEfficientKeyFinder(matrix, 25);
        sortedMatrixEfficientKeyFinder(matrix, 35);
        sortedMatrixEfficientKeyFinder(matrix, 45);
        sortedMatrixEfficientKeyFinder(matrix, 27);
        sortedMatrixEfficientKeyFinder(matrix, 29);
        sortedMatrixEfficientKeyFinder(matrix, 37);
        sortedMatrixEfficientKeyFinder(matrix, 48);
        sortedMatrixEfficientKeyFinder(matrix, 32);
        sortedMatrixEfficientKeyFinder(matrix, 33);
        sortedMatrixEfficientKeyFinder(matrix, 39);
        sortedMatrixEfficientKeyFinder(matrix, 50);

        sortedMatrixEfficientKeyFinder(matrix, 11);
        sortedMatrixEfficientKeyFinder(matrix, 21);
        /*
            key: 10 ( rowIdx: 0 columnIdx: 0 )
            key: 20 ( rowIdx: 0 columnIdx: 1 )
            key: 30 ( rowIdx: 0 columnIdx: 2 )
            key: 40 ( rowIdx: 0 columnIdx: 3 )
            key: 15 ( rowIdx: 1 columnIdx: 0 )
            key: 25 ( rowIdx: 1 columnIdx: 1 )
            key: 35 ( rowIdx: 1 columnIdx: 2 )
            key: 45 ( rowIdx: 1 columnIdx: 3 )
            key: 27 ( rowIdx: 2 columnIdx: 0 )
            key: 29 ( rowIdx: 2 columnIdx: 1 )
            key: 37 ( rowIdx: 2 columnIdx: 2 )
            key: 48 ( rowIdx: 2 columnIdx: 3 )
            key: 32 ( rowIdx: 3 columnIdx: 0 )
            key: 33 ( rowIdx: 3 columnIdx: 1 )
            key: 39 ( rowIdx: 3 columnIdx: 2 )
            key: 50 ( rowIdx: 3 columnIdx: 3 )
            not found
            not found
         */

        System.out.println("\n\n\n");

        printMatrixInSpiral(spiral4x4Matrix, 4, 4);
        printMatrixInSpiral(spiral1x10Matrix, 1, 10);
        printMatrixInSpiral(spiral10x1Matrix, 10, 1);
        printMatrixInSpiral(spiral1x1Matrix, 1, 1);
        printMatrixInSpiral(spiral0x0Matrix, 0, 0);

    }

    /*
    1. Given a row and column wise (nxn) sorted matrix.
    write an algorithm to search a key in the matrix.

    Example:
                    10  20  30  40
                    15  25  35  45
                    27  29  37  48
                    32  33  39  50

    key = 29
    printed: 29 is found at row: 2 and column: 1
     */

    // arr[row][column]
    public static <T extends Comparable<T>> void sortedMatrixEfficientKeyFinder(T[][] arr, T key) {
        int rowIdx = 0;
        int columnIdx = arr.length - 1;
        String msg = "not found";
        while (rowIdx < arr.length && columnIdx >= 0) { // while row or column is not out of bounds
            if (arr[rowIdx][columnIdx].compareTo(key) == 0) {
                msg = "key: " + key + " ( rowIdx: " + rowIdx + " columnIdx: " + columnIdx + " )";
                break;
            }

            // PD: never reach with a equals value
            if (arr[rowIdx][columnIdx].compareTo(key) > 0) { // arr[r][c] > key   || if the current column has a value greater than the key, then move to the left
                columnIdx--;
            } else { // arr[r][c] < key     || if the current column has a value greater than the key, then move to the down
                rowIdx++;
            }
        }
        System.out.println(msg);
    }

    /*

    2. Given a matrix, print it in spiral form.

    Example:
                    10  20  30  40
                    15  25  35  45
                    27  29  37  48
                    32  33  39  50

        Output: 10 20 30 40 45 48 50 39 33 32 27 15 25 35 37 29
     */

    static <T> void printMatrixInSpiral(T[][] mtx, int rows, int columns) {
        System.out.println("");
        int rowsMaxIdx = rows - 1;
        int rowsMinIdx = 0;

        int columnsMaxIdx = columns - 1;
        int columnsMinIdx = 0;

        int processed = rows * columns; // total


        while (true) {

            for (int c = columnsMinIdx; c <= columnsMaxIdx; c++) {
                System.out.print(mtx[rowsMinIdx][c] + ", ");
                processed--;
            }
            rowsMinIdx++; // top row processed

            for (int r = rowsMinIdx; r <= rowsMaxIdx; r++) {
                System.out.print(mtx[r][columnsMaxIdx] + ", ");
                processed--;
            }
            columnsMaxIdx--; // right column processed


            if (processed == 0) break;


            for (int c = columnsMaxIdx; c >= columnsMinIdx; c--) {
                System.out.print(mtx[rowsMaxIdx][c] + ", ");
                processed--;
            }
            rowsMaxIdx--; // bottom rows processed

            for (int r = rowsMaxIdx; r >= rowsMinIdx; r--) {
                System.out.print(mtx[r][columnsMinIdx] + ", ");
                processed--;
            }
            columnsMinIdx++; // left column processed
        }

    }

}



