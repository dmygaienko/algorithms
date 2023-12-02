package com.mygaienko.common.algorithms.leetcode.number_of_longest_increasing_subsequence;

import java.util.Arrays;

class Solution {

    // 1,3,5,4,7
    //
    // iterate over elements of array
    // take a look at previous element
    // if previous element is less than current than increment length and save length to array (map)
    public int findNumberOfLIS(int[] nums) {

        var dp = new int[nums.length][2]; // nums -> length, count;
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, 1));

        var maxLength = 1;

        for (int i = 1; i < nums.length; i++) {
            var curr = nums[i];
            for (int j = 0; j < i; j++) {
                var prev = nums[j];
                if (prev < curr) {
                    if (dp[i][0] < dp[j][0] + 1) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                    } else if (dp[i][0] == dp[j][0] + 1) {
                        dp[i][1] += dp[j][1];
                    }
                }
            }

            maxLength = Math.max(maxLength, dp[i][0]);
        }

        var maxLengthCount = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][0] == maxLength) {
                maxLengthCount += dp[i][1];
            }
        }

        return maxLengthCount;
    }

}
