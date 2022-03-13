package com.mygaienko.common.algorithms.leetcode.minimum_cost_to_connect_sticks;

import java.util.PriorityQueue;

class Solution {

    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int stick : sticks) {
            minHeap.offer(stick);
        }

        int cost = 0;
        while (minHeap.size() > 1) {
            int a = minHeap.poll();
            int b = minHeap.poll();
            int sum = a + b;
            cost += sum;
            minHeap.offer(sum);
        }
        return cost;
    }

}
