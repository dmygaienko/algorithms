package com.mygaienko.common.algorithms.leetcode.rotate_image;

/**
 * 00 01 02 03 04
 * 10 11 12 13 14
 * 20 21 22 23 24
 * 30 31 32 33 34
 * 40 41 42 43 44
 */
class Solution {

    public static final int EMPTY = Integer.MIN_VALUE;

    public void rotate(int[][] matrix) {
        int M = matrix.length;

        for (int i = 0; i < M / 2; i++) { // slices

            for (int j = i; j < M - i - 1; j++) { // length - d

                int temp = EMPTY;
                for (int k = 0; k < 4; k++) { // sides

                    int[] from = getPoint(M, i, j, k);
                    int[] to = getPoint(M, i, j, k + 1);

                    int fromValue;
                    if (temp == EMPTY) {
                        fromValue = matrix[from[0]][from[1]];
                    } else {
                        fromValue = temp;
                    }
                    temp = matrix[to[0]][to[1]];

                    matrix[to[0]][to[1]] = fromValue;
                }
            }
        }

    }

    private int[] getPoint(int mLength, int i, int j, int side) {

        if (side == 0 || side == 4) {
            return new int[]{i, j};

        } else if (side == 1) {
            return new int[]{j, mLength - 1 - i};

        } else if (side == 2) {
            return new int[]{mLength - 1 - i, mLength - 1 - j};

        } else if (side == 3) {
            return new int[]{mLength - 1 - j, i};
        }

        throw new IllegalArgumentException("side argument is illegal - " + side);
    }

}
