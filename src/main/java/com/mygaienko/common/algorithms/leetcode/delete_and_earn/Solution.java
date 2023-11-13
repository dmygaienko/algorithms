package com.mygaienko.common.algorithms.leetcode.delete_and_earn;

import java.util.HashMap;

class Solution {

    public int deleteAndEarn(int[] nums) {
        var max = 0;

        var numSum = new HashMap<Integer, Integer>();
        for (var num : nums) {
            numSum.compute(num, (k, v) -> v == null ? num : v + num);
            max = Math.max(max, num);
        }

        var dp = new int[max+1];
        dp[0] = numSum.getOrDefault(0, 0);
        dp[1] = Math.max(dp[0], numSum.getOrDefault(1, 0));

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-2] + numSum.getOrDefault(i, 0), dp[i-1]);
        }

        return dp[max];
    }
}
