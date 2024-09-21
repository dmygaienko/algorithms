package com.mygaienko.common.algorithms.leetcode.spiral_matrix_iii;

class Solution {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        var target = rows * cols;

        var count = 0;
        var path = new int[target][2];
        path[0] = new int[]{rStart, cStart};
        count++;

        var rCurr = rStart;
        var cCurr = cStart;
        var dir = 0;
        var steps = 1;

        while (count < target) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < steps; j++) {
                    rCurr = rCurr + dirs[dir][0];
                    cCurr = cCurr + dirs[dir][1];

                    if (isValid(rows, cols, rCurr, cCurr)) {
                        path[count] = new int[]{rCurr, cCurr};
                        count++;
                    }
                }
                dir = (dir + 1) % 4;
            }
            steps++;
        }

        return path;
    }

    private boolean isValid(int rows, int cols, int rCurr, int cCurr) {
        return rCurr >= 0 && rCurr < rows &&
                cCurr >= 0 && cCurr < cols;
    }
}