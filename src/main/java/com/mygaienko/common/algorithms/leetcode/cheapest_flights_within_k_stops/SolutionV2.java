package com.mygaienko.common.algorithms.leetcode.cheapest_flights_within_k_stops;

import java.util.Arrays;

/**
 * Bellman-Ford algorithm
 * find shortest path distances with at most k edges with dynamic programming (with two-dimensional array)
 */
class SolutionV2 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        var prev = new int[n];
        Arrays.fill(prev, Integer.MAX_VALUE);
        prev[src] = 0;

        for (int i = 0; i <= k; i++) {

            int[] curr = Arrays.copyOf(prev, n);

            for (var flight : flights) {
                var source = flight[0];
                var dest = flight[1];
                var cost = flight[2];

                if (prev[source] != Integer.MAX_VALUE) {
                    curr[dest] = Math.min(curr[dest], prev[source] + cost);
                }
            }

            prev = curr;
        }

        return prev[dst] == Integer.MAX_VALUE ? -1 : prev[dst];
    }
}