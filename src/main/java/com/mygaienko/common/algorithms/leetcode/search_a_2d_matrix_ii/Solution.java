package com.mygaienko.common.algorithms.leetcode.search_a_2d_matrix_ii;

class Solution {

    int[] UP_RIGHT = new int[]{-1, 1};

    int[] DOWN_LEFT = new int[]{1, -1};

    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, target);
    }

    private boolean searchMatrix(int[][] matrix, int initXMin, int initXMax, int initYMin, int initYMax, int target) {
        int xMin = initXMin;
        int xMax = initXMax;
        int yMin = initYMin;
        int yMax = initYMax;

        int xMid = 0;
        int yMid = 0;

        while (xMax - xMin >= 0 && yMax - yMin >= 0) {
            xMid = xMin + (xMax - xMin) / 2;
            yMid = yMin + (yMax - yMin) / 2;

            int val = matrix[xMid][yMid];

            if (val == target) {
                return true;
            } else if (xMax - xMin == 0 && yMax - yMin == 0) {
                break;
            } else if (target < val) {
                xMax = xMid;
                yMax = yMid;
            } else {
                xMin = xMid + 1 <= xMax ? xMid + 1 : xMid;
                yMin = yMid + 1 <= yMax ? yMid + 1 : yMid;
            }
        }

        if (xMid > initXMin && yMid < matrix[0].length
                && (xMid != initXMax || yMid != initYMin)) {
            if (searchMatrix(matrix, initXMin, xMid, yMid, initYMax, target)) return true;
        }

        if (xMid < matrix.length && yMid > initYMin
                && (xMid != initXMin || yMid != initYMax)) {
            if (searchMatrix(matrix, xMid, initXMax, initYMin, yMid, target)) return true;
        }

        return false;
    }

}