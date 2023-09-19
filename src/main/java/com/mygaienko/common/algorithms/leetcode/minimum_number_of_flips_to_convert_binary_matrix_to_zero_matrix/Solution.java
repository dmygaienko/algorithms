package com.mygaienko.common.algorithms.leetcode.minimum_number_of_flips_to_convert_binary_matrix_to_zero_matrix;

import java.util.ArrayDeque;

class Solution {

    int ONE = 1;
    int ZERO = 0;

    public int minFlips(int[][] mat) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == ONE) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        int steps = 0;
        int oneCount = queue.size();
        while (!queue.isEmpty() && oneCount != 0) {
            int[] curr = queue.poll();
            int currI = curr[0];
            int currJ = curr[1];
            if (mat[currI][currJ] == ZERO) continue;
            oneCount--;
            mat[currI][currJ] = ZERO;

            boolean flipped = false;
            int prevI = currI - 1;
            if (prevI >= 0) {
                for (int j = 0; j < mat[0].length; j++) {
                    flipped = true;
                    if (mat[prevI][j] == ZERO) {
                        mat[prevI][j] = ONE;
                        queue.offer(new int[] {prevI, j});
                        oneCount++;
                    } else {
                        mat[prevI][j] = ZERO;
                        oneCount--;
                    }
                }
            }

            int nextI = currI + 1;
            if (nextI < mat.length) {
                for (int j = 0; j < mat[0].length; j++) {
                    flipped = true;
                    if (mat[nextI][j] == ZERO) {
                        mat[nextI][j] = ONE;
                        queue.offer(new int[] {nextI, j});
                        oneCount++;
                    } else {
                        mat[nextI][j] = ZERO;
                        oneCount--;
                    }
                }
            }

            if (flipped) {
                steps++;
            }
        }

        return steps;
    }

}
