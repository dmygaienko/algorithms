package com.mygaienko.common.algorithms.leetcode.search_a_2d_matrix_ii;

public class SolutionV3 {

    int[] UP_RIGHT = new int[]{-1, 1};

    int[] DOWN_LEFT = new int[]{1, -1};

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix[0][0] == target) return true;

        int[] start = new int[]{0, 0};
        int[] end = new int[]{matrix.length - 1, matrix[0].length - 1};

        while (start != end) {
            int x = start[0] + (end[0] - start[0]) / 2;
            int y = start[1] + (end[1] - start[1]) / 2;
            int[] mid = new int[]{x, y};
            int midValue = matrix[mid[0]][mid[1]];
            if (midValue == target) return true;

            boolean isDiagonalGreater = midValue > target;

            int[] next = mid;
            while (next[0] + UP_RIGHT[0] >= 0 && next[1] + UP_RIGHT[1] < matrix[0].length) {
                next = new int[]{next[0] + UP_RIGHT[0], next[1] + UP_RIGHT[1]};
                int val = matrix[next[0]][next[1]];
                if (val == target) {
                    return true;
                } else if (val > target) {
                    isDiagonalGreater = true;
                }
            }

            next = mid;
            while (next[0] + DOWN_LEFT[0] < matrix.length && next[1] + DOWN_LEFT[1] >= 0) {
                next = new int[]{next[0] + DOWN_LEFT[0], next[1] + DOWN_LEFT[1]};
                int val = matrix[next[0]][next[1]];
                if (val == target) {
                    return true;
                } else if (val > target) {
                    isDiagonalGreater = true;
                }
            }

            if (isSameDiagonal(start, end)) return false;

            if (isDiagonalGreater) {
                end = mid;
            } else {
                if (mid[1] + 1 < matrix[0].length) {
                    start = new int[]{mid[0], mid[1] + 1};
                } else {
                    start = new int[]{mid[0] + 1, mid[1]};
                }

            }
        }
        return false;
    }

    private boolean isSameDiagonal(int[] start, int[] end) {
        int[] s1 = new int[]{0, start[1] + start[0]};
        int[] e1 = new int[]{0, end[1] + end[0]};

        return s1[0] == e1[0] && s1[1] == e1[1];
    }

}
