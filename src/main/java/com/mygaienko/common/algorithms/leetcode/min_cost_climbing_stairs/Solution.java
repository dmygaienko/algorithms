package com.mygaienko.common.algorithms.leetcode.min_cost_climbing_stairs;

class Solution {

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length ==1) {
            return cost[0];
        }

        int[] dp = new int[cost.length+1];

        for (int i = 2; i < dp.length; i++) {
            int oneStepCost = dp[i-1] + cost[i-1];
            int twoStepCost = dp[i-2] + cost[i-2];

            dp[i] = Math.min(oneStepCost, twoStepCost);
        }

        return dp[dp.length-1];
    }

}