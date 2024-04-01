package com.mygaienko.common.algorithms.leetcode.handshakes_that_dont_cross;

class Solution {
    int MOD = 1000000007;

    public int numberOfWays(int numPeople) {
        var dp = new long[numPeople / 2 + 1];
        dp[0] = 1;

        for (int i = 1; i <= numPeople / 2; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += (dp[j] * dp[i - j - 1]) % MOD;
                dp[i] %= MOD;
            }
        }

        return (int) dp[numPeople / 2];
    }

}
