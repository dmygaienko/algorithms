package com.mygaienko.common.algorithms.leetcode.furthest_building_you_can_reach;

import java.util.PriorityQueue;

class Solution {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(ladders == 0 ? 1 : ladders);
        int brickSum = 0;

        int i = 1;
        for (; i < heights.length; i++) {
            int prev = heights[i-1];
            int next = heights[i];
            int jump = next - prev;
            if (jump > 0) {
                if (minHeap.size() < ladders)  {
                    minHeap.offer(jump);
                } else if (!minHeap.isEmpty() && minHeap.peek() < jump && brickSum + minHeap.peek() <= bricks) {
                    Integer less = minHeap.poll();
                    brickSum += less;
                    minHeap.offer(jump);
                } else if (brickSum + jump <= bricks) {
                    brickSum += jump;
                } else {
                    break;
                }
            }
        }
        return i-1;
    }
}
