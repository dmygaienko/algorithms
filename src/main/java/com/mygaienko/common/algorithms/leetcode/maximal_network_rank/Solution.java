package com.mygaienko.common.algorithms.leetcode.maximal_network_rank;

import java.util.*;

class Solution {

    public int maximalNetworkRank(int n, int[][] roads) {
        var ranks = new HashMap<Integer, Integer>();
        var adj = new HashMap<Integer, Set<Integer>>();

        var max = 0;
        for (var road : roads) {
            ranks.compute(road[0], (k, v) -> v == null ? 1 : v + 1);
            ranks.compute(road[1], (k, v) -> v == null ? 1 : v + 1);

            int from = Math.min(road[0], road[1]);
            int to = Math.max(road[0], road[1]);
            adj.computeIfAbsent(from, v -> new HashSet<>()).add(to);
        }

        var queue = new PriorityQueue<>(Comparator.<int[]>comparingInt(arr -> arr[1]).reversed());
        for (var entry : ranks.entrySet()) {
            queue.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        var city = -1;
        var cityRank = -1;
        var stack = new LinkedList<int[]>();
        while (!queue.isEmpty()) {
            var nextEntry = queue.poll();
            var nextCity = nextEntry[0];
            var nextRank = nextEntry[1];
            var isConnected = isConnected(adj, city, nextCity);

            if (isConnected && !queue.isEmpty() && queue.peek()[1] == nextRank) {
                stack.push(nextEntry);
                continue;
            } else if (!stack.isEmpty()) {
                stack.forEach(queue::offer);
                stack.clear();
            }

            if (city != -1) {
                var pairRank = nextRank + cityRank + (isConnected ? -1 : 0);
                max = Math.max(max, pairRank);
            }

            city = nextCity;
            cityRank = nextRank;
        }

        return max;
    }

    private boolean isConnected(HashMap<Integer, Set<Integer>> adj, int city, int nextCity) {
        int from = Math.min(city, nextCity);
        int to = Math.max(city, nextCity);
        return adj.getOrDefault(from, Set.of()).contains(to);
    }
}