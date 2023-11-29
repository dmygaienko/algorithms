package com.mygaienko.common.algorithms.leetcode.maximum_earnings_from_taxi;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, Comparator.comparingInt(ride -> ride[0]));

        var maxEnd = 0;
        for (int i = 0; i < rides.length; i++) {
            maxEnd = Math.max(maxEnd, rides[i][1]);
        }

        var dp = new long[maxEnd + 1];

        int i = 0;
        for (int r = 0; r < rides.length; r++) {
            var ride = rides[r];
            int end = ride[1];
            int start = ride[0];

            while (i < start && i + 1 < dp.length) {
                dp[i + 1] = Math.max(dp[i], dp[i + 1]);
                i++;
            }

            var earning = end - start + ride[2];
            var prev = dp[start];
            dp[end] = Math.max(dp[end], prev + earning);
        }

        long maxEarning = 0;
        for (long value : dp) {
            maxEarning = Math.max(maxEarning, value);
        }

        return maxEarning;
    }
}
