package com.mygaienko.common.algorithms.leetcode.minimum_rounds_to_complete_all_tasks;

import java.util.Arrays;

class Solution {

    public int minimumRounds(int[] tasks) {
        if (tasks.length < 2) return -1;
        Arrays.sort(tasks);

        var dp = new int[tasks.length];
        Arrays.fill(dp, -1);
        dp[0] = 1;

        for (int i = 1; i < 3 && i < tasks.length; i++) {
            if (tasks[i] == tasks[i - 1]) {
                dp[i] = dp[i - 1];
            } else if (i == 1) {
                return -1;
            }
        }

        for (int i = 2; i < tasks.length; i++) {
            var prevRound = dp[i - 1];
            if (prevRound == -1) return -1;
            var currRound = prevRound + 1;

            for (int j = i; j < i + 3 && j < tasks.length; j++) {
                if (j > i && tasks[j] == tasks[j - 1] && tasks[j] == tasks[i]) {
                    dp[j - 1] = dp[j - 1] == -1 ? currRound : Math.min(dp[j - 1], currRound);
                    dp[j] = dp[j] == -1 ? currRound : Math.min(dp[j], currRound);
                }
            }
        }

        return dp[tasks.length - 1];
    }

}