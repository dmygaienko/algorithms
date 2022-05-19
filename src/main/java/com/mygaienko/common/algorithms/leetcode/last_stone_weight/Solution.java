package com.mygaienko.common.algorithms.leetcode.last_stone_weight;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (Integer stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int a = maxHeap.poll();
            int b = maxHeap.poll();

            int diff = a - b;
            if (diff != 0) {
                maxHeap.offer(Math.abs(diff));
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

}
