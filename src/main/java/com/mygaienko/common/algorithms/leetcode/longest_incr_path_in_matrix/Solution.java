package com.mygaienko.common.algorithms.leetcode.longest_incr_path_in_matrix;

/**
 *
 */
class Solution {

    int[][] offsets = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {

        int[][] cache = new int[matrix.length][matrix[0].length];

        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int cached = cache[i][j];

                if (cached == 0) {
                    cache[i][j] = findMax(matrix, cache, i, j) + 1;
                    max = Math.max(max, cache[i][j]);
                }
            }
        }

        return max;
    }

    private int findMax(int[][] matrix, int[][] cache, int i, int j) {
        int next = matrix[i][j];
        int max = 0;
        for (int[] offset : offsets) {
            int adjI = i + offset[0];
            int adjJ = j + offset[1];

            if (adjI > -1 && adjI < matrix.length
                    && adjJ > -1 && adjJ < matrix[adjI].length) {

                int nextAdj = matrix[adjI][adjJ];

                if (next > nextAdj) {
                    int subPathMax = cache[adjI][adjJ];
                    if (subPathMax == 0) {
                        subPathMax = findMax(matrix, cache, adjI, adjJ) + 1;
                    }
                    max = Math.max(max, subPathMax);
                }
            }
        }
        return max;
    }

}
