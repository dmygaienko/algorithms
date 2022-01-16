package com.mygaienko.common.algorithms.leetcode.kth_largest_element_in_array;

import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int current : nums) {
            if (minHeap.size() < k) {
                minHeap.add(current);
            } else {
                Integer largest = minHeap.peek();
                if (largest != null && largest < current) {
                    minHeap.poll();
                    minHeap.add(current);
                }
            }
        }

        return minHeap.peek();
    }
}
