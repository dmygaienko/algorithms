package com.mygaienko.common.algorithms.leetcode.range_sum_query_2d_mutable;

/**
 * https://www.topcoder.com/thrive/articles/Binary%20Indexed%20Trees
 * https://leetcode.com/problems/range-sum-query-mutable/solutions/75753/Java-using-Binary-Indexed-Tree-with-clear-explanation/
 */
class NumMatrix {

    int[][] matrix;
    long[][] horizontalSums;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        horizontalSums = calcHorizontal(matrix);
    }

    public void update(int row, int col, int val) {
        matrix[row][col] = val;
        updateHorizontal(matrix, horizontalSums, row, col);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        long sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += horizontalSums[i][col2];
            if (col1 > 0) {
                sum -= horizontalSums[i][col1 - 1];
            }
        }
        return (int) sum;
    }

    private long[][] calcHorizontal(int[][] matrix) {
        var horizontalSums = new long[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            updateHorizontal(matrix, horizontalSums, i, 0);
        }
        return horizontalSums;
    }

    private void updateHorizontal(int[][] matrix, long[][] horizontalSums, int i, int col) {
        for (int j = col; j < matrix[0].length; j++) {
            long prevSum = 0;
            if (j > 0) {
                prevSum = horizontalSums[i][j - 1];
            }
            horizontalSums[i][j] = prevSum + matrix[i][j];
        }
    }

}