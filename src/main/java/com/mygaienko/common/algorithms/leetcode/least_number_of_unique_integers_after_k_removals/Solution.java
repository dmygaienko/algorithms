package com.mygaienko.common.algorithms.leetcode.least_number_of_unique_integers_after_k_removals;

import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {

    // count num frequencies
    // put all nums to queue with priority by frequency
    // remove k elements
    // return size of the queue

    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        var numCounts = new HashMap<Integer, Integer>();
        for (var val : arr) {
            numCounts.compute(val, (key, v) -> v == null ? 1 : v + 1);
        }

        var queue = new PriorityQueue<Integer>();
        for (var entry : numCounts.entrySet()) {
            queue.offer(entry.getValue());
        }

        while (k > 0 && !queue.isEmpty()) {
            var count = queue.peek();

            if (count <= k) {
                k -= count;
                queue.poll();
            } else {
                k = 0;
            }
        }

        return queue.size();
    }
}
