package com.mygaienko.common.algorithms.leetcode.detonate_the_maximum_bombs;

import java.util.*;
import java.util.Map.Entry;

class Solution {

    public int maximumDetonation(int[][] bombs) {
        int max = 0;

        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < bombs.length; i++) {
            int[] bomb = bombs[i];
            for (int j = 0; j < bombs.length; j++) {
                if (i == j) continue;
                int[] bombNext = bombs[j];
                double distance = Math.sqrt(Math.pow(bomb[0] - bombNext[0], 2) + Math.pow(bomb[1] - bombNext[1], 2));
                if (distance <= bomb[2]) {
                    adj.putIfAbsent(i, new ArrayList<>());
                    adj.get(i).add(j);
                }
            }
        }

        Comparator<int[]> comparator = Comparator
                .<int[]>comparingInt(arr -> arr[1])
                .thenComparingInt(arr -> arr[2]).reversed();

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(comparator);

        for (Entry<Integer, List<Integer>> entry : adj.entrySet()) {
            int index = entry.getKey();
            priorityQueue.add(new int[] {index, entry.getValue().size(), bombs[index][2]});
        }

        while (!priorityQueue.isEmpty()) {
            int[] bomb = priorityQueue.poll();

            int localMax = 0;
            PriorityQueue<int[]> queue = new PriorityQueue<>(comparator);
            queue.add(bomb);
            BitSet bitSet = new BitSet(bombs.length);
            bitSet.set(bomb[0]);
            while (!queue.isEmpty()) {
                localMax++;
                int[] b = queue.poll();

                List<Integer> neighbors = adj.getOrDefault(b[0], List.of());
                for(int n : neighbors) {
                    if (!bitSet.get(n)) {
                        queue.offer(new int[] {n, adj.getOrDefault(n, List.of()).size(), bombs[n][2]});
                        bitSet.set(n);
                    }
                }
            }
            max = Math.max(max, localMax);
            if (max == bombs.length) return max;
        }

        return Math.max(max, 1);

    }

}
