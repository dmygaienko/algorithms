package com.mygaienko.common.algorithms.leetcode.minimum_number_of_operations_to_satisfy_conditions;

import java.util.Arrays;

/**
 *
 */
class Solution {
    public int minimumOperations(int[][] grid) {
        //minimum operations to make column of value
        var minOperations = new int[grid[0].length][10];
        for (int col = 0; col < grid[0].length; col++) {
            for (int num = 0; num < 10; num++) {
                for (int row = 0; row < grid.length; row++) {
                    if (grid[row][col] != num) {
                        minOperations[col][num]++;
                    }
                }
            }
        }

        var dp = new int[grid[0].length][10];
        for (var row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int col = 0; col < dp.length; col++) {
            for (int value = 0; value < 10; value++) {
                for (int i = 0; i < 10; i++) {
                    if (i != value) {
                        var prevDp = col - 1 >= 0 ? dp[col - 1][i] : 0;
                        dp[col][value] = Math.min(dp[col][value], minOperations[col][value] + prevDp);
                    }
                }
            }
        }

        var min = Integer.MAX_VALUE;
        for (var val : dp[dp.length - 1]) {
            min = Math.min(min, val);
        }

        return min;
    }
}
