package com.mygaienko.common.algorithms.leetcode.maximal_square;

class SolutionV2 {

    public static final char ONE = '1';

    public int maximalSquare(char[][] matrix) {
        int l1 = matrix.length;
        int l2 = matrix[0].length;

        int[][] dp = new int[l1][l2];

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                dp[i][j] = matrix[i][j] == ONE ? 1 : 0;
                maxArea = Math.max(maxArea, dp[i][j]);
            }
        }

        for (int i = 1; i < l1; i++) {
            for (int j = 1; j < l2; j++) {

                int prev = dp[i - 1][j - 1];

                if (prev > 0 && matrix[i][j] == ONE) {
                    int s = (int) Math.sqrt(prev) + 1;

                    int newS = 1;
                    boolean process = true;
                    while (process && newS < s) {
                        if (matrix[i - newS][j] != ONE || matrix[i][j - newS] != ONE) {
                            process = false;
                        } else {
                            newS++;
                        }
                    }

                    dp[i][j] = (int) Math.pow(newS, 2);
                    maxArea = Math.max(maxArea, dp[i][j]);
                }
            }
        }

        return maxArea;
    }

}
