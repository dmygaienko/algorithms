package com.mygaienko.common.algorithms.leetcode.champagne_tower;

class Solution {


    // recursively pour champagne and count power of pouring
    // finish if poured is 0 or we full pour query_row (query_glass)
    // save power of pouring to map
    public double champagneTower(int poured, int query_row, int query_glass) {
        var dp = new double[query_row + 1][query_row + 1];

        dp[0][0] = poured;
        var rowLength = 2;

        for (int i = 1; i < dp.length; i++) {

            for (int j = 0; j < rowLength && j < dp[0].length; j++) {
                var prevLeft = (j == 0 || dp[i-1][j-1] <= 1) ? 0 : (dp[i-1][j-1] - 1)/2;
                var prevRight = dp[i-1][j] <= 1 ? 0 : (dp[i-1][j] - 1)/2;
                dp[i][j] = prevLeft + prevRight;
            }
            rowLength++;
        }

        return Math.min(1, dp[query_row][query_glass]);
    }

}