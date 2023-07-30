package com.mygaienko.common.algorithms.leetcode.largest_rectangle_in_histogram;

class SolutionV2 {

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1) return heights[0];

        int max = 0;

        int N = heights.length;
        int[][] dp = new int[N][N]; // [start][end] -> commonHeight

        //initDp
        for (int i = 0; i < N; i++) {
            dp[i][0] = heights[0];
            max = Math.max(max, heights[0]);
        }

        for (int i = 1; i < N; i++) {
            int currentHeight = heights[i];
            dp[i][i] = currentHeight;

            for (int j = 0; j < i; j++) {
                int prevCommonHeight = dp[j][i - 1];
                int currenCommonHeight = Math.min(currentHeight, prevCommonHeight);

                int localArea = currenCommonHeight != 0 ? currenCommonHeight * (i - j + 1) : currentHeight;
                localArea = Math.max(localArea, currentHeight);

                dp[j][i] = currenCommonHeight;
                max = Math.max(max, localArea);
            }
        }

        return max;
    }

}