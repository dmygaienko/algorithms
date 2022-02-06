package com.mygaienko.common.algorithms.leetcode.single_source_shortest_path_algorithm;

import java.util.Arrays;

/**
 * bellman ford
 */
class Solution {

    public int minimumEffortPath(int[][] heights) {
        int N = heights.length;
        int M = heights[0].length;
        int K = N*M-1;

        if (N==1 && M==1) return 0;

        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0]=0;

        boolean relaxAny = true;
        for (int k = 0; k < K && relaxAny; k++) {
            relaxAny = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    int curr = heights[i][j];
                    int min = Integer.MAX_VALUE;

                    if (i > 0) {
                        int effort = heights[i - 1][j];
                        int abs = Math.abs(curr - effort);
                        int maxEffort = Math.max(dp[i - 1][j], abs);
                        min = Math.min(maxEffort, min);
                    }
                    if (i + 1 < N) {
                        int effort = heights[i + 1][j];
                        int abs = Math.abs(curr - effort);
                        int maxEffort = Math.max(dp[i + 1][j], abs);
                        min = Math.min(maxEffort, min);
                    }
                    if (j > 0) {
                        int effort = heights[i][j - 1];
                        int abs = Math.abs(curr - effort);
                        int maxEffort = Math.max(dp[i][j - 1], abs);
                        min = Math.min(maxEffort, min);
                    }
                    if (j + 1 < M) {
                        int effort = heights[i][j + 1];
                        int abs = Math.abs(curr - effort);
                        int maxEffort = Math.max(dp[i][j + 1], abs);
                        min = Math.min(maxEffort, min);
                    }

                    if (dp[i][j] == -1 || dp[i][j] > min) {
                        dp[i][j] = dp[i][j] != -1 ? Math.min(dp[i][j], min) : min;
                        relaxAny = true;
                    }

                }
            }
        }

        return dp[N-1][M-1];
    }
}
