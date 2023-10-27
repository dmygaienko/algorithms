package com.mygaienko.common.algorithms.leetcode.uncrossed_lines;

class Solution {

    private static int CROSS = -1;

    /**
     * TOP-DOWN
     * for each element from nums1 count how much uncrossed lines it will be then
     * use memoization to avoid unnecessary calls
     * <p>
     * BOTTOM-UP
     * while iterating check previous step and get count of uncrossed lines on previous step
     * <p>
     * To check that lines are crossed: true if from1 < from2 && to1 > to2
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            var temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        var N = nums1.length;
        var M = nums2.length;

        var dp = new int[N][M];

        var maxAllCount = 0;
        for (int i = 0; i < N; i++) {
            var num1 = nums1[i];
            for (int j = 0; j < M; j++) {
                var num2 = nums2[j];

                var cellAbove = i - 1 >= 0 ? Math.abs(dp[i-1][j]) : 0;
                var cellBefore = j - 1 >= 0 ? Math.abs(dp[i][j-1]) : 0;
                var maxPrevCell = Math.max(cellAbove, cellBefore);

                if (num1 == num2) {
                    boolean noCrossesInARow = noCrossesInARow(dp, i, j);
                    boolean noCrossesInColumn = noCrossesInColumn(dp, i, j);
                    if (noCrossesInARow && noCrossesInColumn) {
                        dp[i][j] = (maxPrevCell + 1) * CROSS;
                    } else if (noCrossesInARow && cellAbove <= cellBefore) {
                        dp[i][j] = (cellBefore + 1) * CROSS;
                    } else if (noCrossesInColumn && cellBefore <= cellAbove) {
                        dp[i][j] = (cellAbove + 1) * CROSS;
                    } else {
                        dp[i][j] = maxPrevCell;
                    }
                } else {
                    dp[i][j] = maxPrevCell;
                }

                maxAllCount = Math.max(maxAllCount, Math.abs(dp[i][j]));
            }
        }
        return maxAllCount;
    }

    private boolean noCrossesInARow(int[][] dp, int i, int j) {
        for (int j1 = 0; j1 < j; j1++) {
            // should be no crosses in row or sum from cell above is equal or greater
            if (dp[i][j1] < 0) return false;
        }
        return true;
    }

    private boolean noCrossesInColumn(int[][] dp, int i, int j) {
        for (int i1 = 0; i1 < i; i1++) {
            // should be no crosses in column or sum in previous cell is equal or greater
            if (dp[i1][j] < 0) return false;
        }
        return true;
    }

}
