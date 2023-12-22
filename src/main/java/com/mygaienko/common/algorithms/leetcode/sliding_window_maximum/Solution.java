package com.mygaienko.common.algorithms.leetcode.sliding_window_maximum;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * To perform these operations, we can use a monotonic queue as it supports efficient insertion, deletion, and retrieval of elements from the ends of a window.
 * We will implement it with the deque data structure.
 */
class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        var left = 0;
        var right = 0;

        var list = new ArrayList<Integer>(nums.length / k);
        var monoQueue = new ArrayDeque<Integer>();
        while (right < nums.length) {
            if (right - left + 1 > k) {
                if (!monoQueue.isEmpty() && (monoQueue.peekLast() == left)) {
                    monoQueue.pollLast();
                }
                left++;
            }

            while (!monoQueue.isEmpty() && nums[monoQueue.peek()] <= nums[right]) {
                monoQueue.pollFirst();
            }

            monoQueue.push(right);

            if (right - left + 1 == k && !monoQueue.isEmpty()) {
                list.add(monoQueue.peekLast());
            }

            right++;
        }

        var result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = nums[list.get(i)];
        }

        return result;
    }

}