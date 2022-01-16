package com.mygaienko.common.algorithms.leetcode.top_k_frequent_elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(k);
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums) {
            freqs.compute(num, (key, value) -> value == null ? 1 : value + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
            Integer freq = entry.getValue();
            if (minHeap.size() < k) {
                minHeap.add(new Pair(freq, entry.getKey()));
            } else {
                if (minHeap.peek().freq < freq) {
                    minHeap.poll();
                    minHeap.add(new Pair(freq, entry.getKey()));
                }
            }
        }

        int i = 0;
        for (Pair pair : minHeap) {
            result[i] = pair.value;
            i++;
        }

        return result;
    }

    static class Pair implements Comparable<Pair> {
        Integer freq;
        Integer value;

        public Pair(Integer freq, Integer value) {
            this.freq = freq;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return this.freq - o.freq;
        }
    }
}
