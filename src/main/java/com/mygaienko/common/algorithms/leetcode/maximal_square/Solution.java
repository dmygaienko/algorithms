package com.mygaienko.common.algorithms.leetcode.maximal_square;

class Solution {

    public static final char ONE = '1';

    public int maximalSquare(char[][] matrix) {
        int l1 = matrix.length + 1;
        int l2 = matrix[0].length + 1;

        int[][] dp = new int[l1+1][l2+1];

        int maxLength = 0;
        for (int i = 1; i < l1; i++) {
            for (int j = 1; j < l2; j++) {
                if (matrix[i-1][j-1] == ONE) {

                    int prev = Math.min(dp[i-1][j-1], dp[i-1][j]);
                    prev = Math.min(prev, dp[i][j-1]);

                    dp[i][j] = prev + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }

        return (int) Math.pow(maxLength, 2);

    }

}
