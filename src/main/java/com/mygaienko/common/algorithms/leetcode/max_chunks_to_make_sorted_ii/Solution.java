package com.mygaienko.common.algorithms.leetcode.max_chunks_to_make_sorted_ii;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int maxChunksToSorted(int[] arr) {
        int maxChunks = 0;

        ArrayDeque<Integer> monoStack = new ArrayDeque<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> valueCounts = new HashMap<>();
        for (int i = 0; i < arr.length; i ++) {
            int value = arr[i];
            min = Math.min(min, value);
            valueCounts.compute(value, (k, v) -> v == null ? 1 : v + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];

            while(!monoStack.isEmpty() && arr[monoStack.peek()] <= val) {
                int poppedValue = arr[monoStack.pop()];
                min = Math.min(min, poppedValue);
                max = Math.max(max, poppedValue);
                valueCounts.compute(poppedValue, (k, v) -> v - 1);
            }

            if (i != 0 && monoStack.isEmpty() && isEmpty(valueCounts, min, val != max ? max - 1 : val - 1)) {
                maxChunks++;

                if (valueCounts.getOrDefault(max, 0) > 0) {
                    min = Math.min(max, val);
                } else {
                    min = Math.min(max + 1, val);
                }

                max = min;
            }

            monoStack.push(i);
        }

        if (!monoStack.isEmpty()) maxChunks++;

        return maxChunks;
    }

    private boolean isEmpty(Map<Integer, Integer> valueCounts, int min, int max) {
        for (int i = min; i <= max; i++) {
            if (valueCounts.getOrDefault(i, 0) > 0) return false;
        }
        return true;
    }

}
