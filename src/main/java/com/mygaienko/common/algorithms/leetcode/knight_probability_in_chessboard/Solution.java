package com.mygaienko.common.algorithms.leetcode.knight_probability_in_chessboard;


class Solution {

    int[][] DIRS = new int[][]{
            {-2, 1},
            {-1, 2},
            {1, 2},
            {2, 1},
            {2, -1},
            {1, -2},
            {-1, -2},
            {-2, -1}
    };

    public double knightProbability(int n, int k, int row, int column) {
        var prevDp = new double[n][n];
        var currDp = new double[n][n];

        //init first step
        prevDp[row][column] = 1;

        for (int i = 1; i < k + 1; i++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    for (var dir : DIRS) {
                        var prevR = r - dir[0];
                        var prevC = c - dir[1];

                        if (isValid(n, prevR) && isValid(n, prevC)) {
                            currDp[r][c] += prevDp[prevR][prevC] / 8;
                        }
                    }
                }
            }
            prevDp = currDp;
            currDp = new double[n][n];
        }

        var result = 0.0d;
        for (int r = 0; r < n; r++) {
            var nextRow = prevDp[r];
            for (var prob : nextRow) {
                result += prob;
            }
        }

        return result;
    }

    boolean isValid(int n, int prop) {
        return prop >= 0 && prop < n;
    }

}