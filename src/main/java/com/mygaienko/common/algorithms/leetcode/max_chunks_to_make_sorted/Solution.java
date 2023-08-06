package com.mygaienko.common.algorithms.leetcode.max_chunks_to_make_sorted;

import java.util.ArrayDeque;

class Solution {

    public int maxChunksToSorted(int[] arr) {
        int maxChunks = 0;

        ArrayDeque<Integer> monoStack = new ArrayDeque<>();

        int min = getMin(arr);
        int max = Integer.MIN_VALUE;
        int popped = 0;

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];

            while(!monoStack.isEmpty() && arr[monoStack.peek()] < val) {
                int poppedValue = arr[monoStack.pop()];
                min = Math.min(min, poppedValue);
                max = Math.max(max, poppedValue);
                popped++;
            }

            if (i != 0 && monoStack.isEmpty() && (max - min + 1) == popped) {
                maxChunks++;
                min = max + 1;
                max = min;
                popped = 0;
            }

            monoStack.push(i);
        }

        if (!monoStack.isEmpty()) maxChunks++;

        return maxChunks;
    }

    private int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i ++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }

}
