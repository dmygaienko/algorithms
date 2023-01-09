package com.mygaienko.common.algorithms.leetcode.sparse_package_multiplication;

import java.util.ArrayList;
import java.util.List;

class SolutionV2 {

    /**
     * A is an m × n matrix and B is an n × p matrix,
     */
    public int[][] multiply(int[][] a, int[][] b) {
        SparseMatrix A = new SparseMatrix(a);
        SparseMatrix B = new SparseMatrix(b, true);

        int[][] product = new int[a.length][b[0].length];

        for (int row = 0; row < product.length; row++) {
            for (int col = 0; col < product[0].length; col++) {

                // Row element range indices
                int matrixOneRowStart = A.rowIndex.get(row);
                int matrixOneRowEnd = A.rowIndex.get(row + 1);

                // Column element range indices
                int matrixTwoColStart = B.colIndex.get(col);
                int matrixTwoColEnd = B.colIndex.get(col + 1);

                while (matrixOneRowStart < matrixOneRowEnd && matrixTwoColStart < matrixTwoColEnd) {

                    if (A.colIndex.get(matrixOneRowStart) < B.rowIndex.get(matrixTwoColStart)) {
                        matrixOneRowStart++;
                    } else if (A.colIndex.get(matrixOneRowStart) > B.rowIndex.get(matrixTwoColStart)) {
                        matrixTwoColStart++;
                    } else {
                        // Row index and col index are same so we can multiply these elements.
                        product[row][col] += A.values.get(matrixOneRowStart) * B.values.get(matrixTwoColStart);
                        matrixOneRowStart++;
                        matrixTwoColStart++;
                    }
                }

            }
        }

        return product;
    }


    static class SparseMatrix {

        List<Integer> values = new ArrayList<>();
        List<Integer> colIndex = new ArrayList<>();
        List<Integer> rowIndex = new ArrayList<>();

        /**
         * Compressed Sparse Row format
         */
        public SparseMatrix(int[][] matrix) {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    int value = matrix[row][col];

                    if (value != 0) {
                        values.add(value); // add non zero value to values
                        colIndex.add(col); // add correspondent index of non zero value to colIndex
                    }
                }
                rowIndex.add(values.size()); // add end + 1 of current row to rowIndex
            }
        }

        /**
         * Compressed Sparse Column format
         */
        public SparseMatrix(int[][] matrix, boolean columnWise) {
            for (int col = 0; col < matrix[0].length; col++) {
                for (int row = 0; row < matrix.length; row++) {

                    int value = matrix[row][col];

                    if (value != 0) {
                        values.add(value); // add non zero value to values
                        rowIndex.add(row); // add correspondent index of non zero value to rowIndex
                    }
                }
                colIndex.add(values.size()); // add end + 1 of current column to colIndex
            }
        }

    }

}