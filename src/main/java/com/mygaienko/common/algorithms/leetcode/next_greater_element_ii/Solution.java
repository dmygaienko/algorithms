package com.mygaienko.common.algorithms.leetcode.next_greater_element_ii;

import java.util.ArrayDeque;

class Solution {

    public int[] nextGreaterElements(int[] nums) {
        int N = nums.length;
        int[] result = new int[N];

        ArrayDeque<Integer> monoStack = new ArrayDeque<>();

        boolean cycled = false;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];

            //keep decreasing
            while (!monoStack.isEmpty() && nums[monoStack.peek()] < val) {
                int poped = monoStack.pop();
                result[poped] = val;
            }

            monoStack.push(i);

            if (i + 1 == nums.length && !cycled) {
                i = -1;
                cycled = true;
            }
        }

        if (result[monoStack.getLast()] == 0) {
            int max = nums[monoStack.getLast()];
            for (int i = 0; i < nums.length; i++) {
                int val = nums[i];
                if (val == max) {
                    result[i] = -1;
                }
            }
        }

        return result;
    }

}
