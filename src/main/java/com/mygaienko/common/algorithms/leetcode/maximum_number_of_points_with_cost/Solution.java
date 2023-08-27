 package com.mygaienko.common.algorithms.leetcode.maximum_number_of_points_with_cost;

import java.util.LinkedList;
import java.util.List;

class Solution {

    public long maxPoints(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) return 0;

        int N = points.length;
        int M = points[0].length;

        long[][] dp = new long[N][M];
        //init with first row
        for (int j = 0; j < M; j++) {
            dp[0][j] = points[0][j];
        }

        //for each row for each cell try to pick any and find max
        for (int i = 1; i < N; i++) {

            LinkedList<long[]> maxes = new LinkedList<>();
            for (int c = 0; c < M; c++) {
                long prevVal = dp[i-1][c];
                if (maxes.isEmpty()) {
                    maxes.addLast(new long[]{prevVal, c});
                } else if (maxes.peekLast()[0] + Math.abs(maxes.peekLast()[1] - c) < prevVal) {
                    while(!maxes.isEmpty() && maxes.peekLast()[0] + Math.abs(maxes.peekLast()[1] - c) < prevVal) {
                        maxes.removeLast();
                    }

                    maxes.addLast(new long[]{prevVal, c});
                } else if (maxes.peekLast()[0] < (prevVal + Math.abs(maxes.peekLast()[1] - c))) {
                    maxes.addLast(new long[]{prevVal, c});
                }
            }

            for (int j = 0; j < M; j++) {
                long val = points[i][j];

                for (long[] max : maxes) {
                    long localVal = val - Math.abs(j-max[1]) + max[0];
                    dp[i][j] = Math.max(dp[i][j], localVal);
                }

                // if (j > 0) {
                //     dp[i][j] = Math.max(dp[i][j], val - 1 + dp[i-1][j-1]);
                // }

                // dp[i][j] = Math.max(dp[i][j], val + dp[i-1][j]);

                // if (j + 1 < M) {
                //     dp[i][j] = Math.max(dp[i][j], val - 1 + dp[i-1][j+1]);
                // }

            }
        }

        long max = 0;
        for (int j = 0; j < M; j++) {
            max = Math.max(max, dp[N-1][j]);
        }

        return max;
    }

}
