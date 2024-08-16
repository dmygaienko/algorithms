package com.mygaienko.common.algorithms.leetcode.find_valid_matrix_given_row_and_column_sums;

class Solution {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;

        var matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                var val = Math.min(rowSum[row], colSum[col]);
                matrix[row][col] = val;

                rowSum[row] -= val;
                colSum[col] -= val;
            }

        }

        return matrix;
    }

}