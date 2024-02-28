package com.mygaienko.common.algorithms.leetcode.cheapest_flights_within_k_stops;

import java.util.Arrays;

/**
 * Bellman-Ford algorithm
 * find shortest path distances with at most k edges with dynamic programming
 */
class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        var dp = new int[Math.max(n, k + 2)][n];

        for (var row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dp[0][src] = 0;

        for (int i = 1; i <= k + 1; i++) {

            for (var flight : flights) {
                var source = flight[0];
                var dest = flight[1];
                var cost = flight[2];

                dp[i][dest] = Math.min(dp[i][dest], dp[i - 1][dest]);
                if (dp[i - 1][source] != Integer.MAX_VALUE) {
                    dp[i][dest] = Math.min(dp[i][dest], dp[i - 1][source] + cost);
                }
            }

        }

        return dp[k + 1][dst] == Integer.MAX_VALUE ? -1 : dp[k + 1][dst];
    }
}