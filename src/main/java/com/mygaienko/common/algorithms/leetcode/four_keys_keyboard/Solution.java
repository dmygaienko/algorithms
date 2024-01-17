package com.mygaienko.common.algorithms.leetcode.four_keys_keyboard;

public class Solution {

    public int maxA(int n) {
        if (n <= 5) return n;

        var dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        dp[5] = 5;

        var buffer = new int[n + 1];

        for (int i = 6; i < dp.length; i++) {
            var result = i;

            var minusOneResult = dp[i - 1] + buffer[i - 1];
            if (minusOneResult > result) {
                result = minusOneResult;
                buffer[i] = buffer[i - 1];
            }

            var minusTwoResult = dp[i - 2] + buffer[i - 2] + buffer[i - 2];
            if (minusTwoResult > result) {
                result = minusTwoResult;
                buffer[i] = buffer[i - 2];
            }

            var minusThreeResult = dp[i - 3] + buffer[i - 3] + buffer[i - 3] + buffer[i - 3];
            if (minusThreeResult > result) {
                result = minusThreeResult;
                buffer[i] = buffer[i - 3];
            }

            minusThreeResult = dp[i - 3] * 2;
            if (minusThreeResult >= result) {
                result = minusThreeResult;
                buffer[i] = dp[i - 3];
            }

            var minusFourResult = dp[i - 4] + dp[i - 4] + dp[i - 4]; // CA + CC + CV + CV
            if (minusFourResult > result) {
                result = minusFourResult;
                buffer[i] = dp[i - 4];
            }

            var minusFiveResult = dp[i - 5] + dp[i - 5] + dp[i - 5] + dp[i - 5]; // CA + CC + CV + CV + CV
            if (minusFiveResult > result) {
                result = minusFiveResult;
                buffer[i] = dp[i - 5];
            }

            dp[i] = result;
        }

        return dp[n];
    }
}
