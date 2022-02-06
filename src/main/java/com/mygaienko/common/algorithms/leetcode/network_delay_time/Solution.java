package com.mygaienko.common.algorithms.leetcode.network_delay_time;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Dijkstra's Algorithm
 */
class Solution {

    public static final int NOT_FOUND = -1;

    public int networkDelayTime(int[][] times, int n, int start) {
        Map<Integer, List<Weight>> adj = new HashMap<>();
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int weight = time[2];
            adj.computeIfAbsent(from, v -> new ArrayList<>()).add(new Weight(to, weight));
        }

        Map<Integer, Integer> minDelay = new HashMap<>();
        boolean[] seen = new boolean[n + 1];

        Queue<Weight> queue = new PriorityQueue<>(Comparator.comparingInt(Weight::getValue));
        queue.add(new Weight(start, 0));

        while (!queue.isEmpty()) {
            Weight weightedNext = queue.poll();
            int next = weightedNext.to;
            int weight = weightedNext.value;

            if (minDelay.getOrDefault(next, Integer.MAX_VALUE) < weight) {
                continue;
            } else {
                minDelay.put(next, weight);
            }

            if (seen[next]) continue; // no need to add adjacent nodes to queue
            seen[next] = true;
            int currentDelay = minDelay.computeIfAbsent(next, v -> 0);

            List<Weight> neighs = adj.get(next);
            if (neighs != null && !neighs.isEmpty()) {
                for (Weight neigh : neighs) {
                    int currNeighDelay = currentDelay + neigh.value;
                    Integer minNeighDelay = minDelay.getOrDefault(neigh.to, Integer.MAX_VALUE);
                    if (currNeighDelay < minNeighDelay) {
                        minDelay.put(neigh.to, currNeighDelay);
                        queue.offer(new Weight(neigh.to, currNeighDelay));
                    }
                }
            }
        }

        boolean allSeen = true;
        for (int i = 1; i < n + 1; i++) {
            if (!seen[i]) {
                allSeen = false;
                break;
            }
        }

        Integer result = minDelay.values().stream()
                .max(Comparator.comparingInt(i -> i))
                .orElse(NOT_FOUND);

        return result > 0 && allSeen ? result : NOT_FOUND;
    }

    static class Weight {
        int to;
        int value;

        public Weight(int to, int value) {
            this.to = to;
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
