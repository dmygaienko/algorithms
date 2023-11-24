package com.mygaienko.common.algorithms.leetcode.zeroone_matrix;

import java.util.Arrays;

class Solution {

    int[][] DIRS = new int[][]{
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    // iterate over matrix
    // if value equals zero put zero to new matrix in corespondent cell
    // else visit BFS every cell and find nearest zero
    public int[][] updateMatrix(int[][] mat) {
        var lengthMat = new int[mat.length][mat[0].length];
        Arrays.stream(lengthMat).forEach(arr -> Arrays.fill(arr, Integer.MAX_VALUE));

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                var cell = mat[i][j];
                if (cell == 0) {
                    lengthMat[i][j] = 0;
                } else if (lengthMat[i][j] != Integer.MAX_VALUE) {
                    updateMatrix(mat, lengthMat, i, j);
                }
            }
        }

        return lengthMat;
    }

    private void updateMatrix(int[][] mat, int[][] lengthMat, int i, int j) {

    }

}
