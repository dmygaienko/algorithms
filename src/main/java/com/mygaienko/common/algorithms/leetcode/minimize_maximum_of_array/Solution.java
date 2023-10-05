package com.mygaienko.common.algorithms.leetcode.minimize_maximum_of_array;

import java.util.LinkedList;

class Solution {

    public int minimizeArrayValue(int[] nums) {
        var stack = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {

            // use increasing monotonic stack
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i] && stack.peek() + 1 == i) {
                var stackI = stack.pop();
                while (nums[stackI] < nums[i]) {
                    nums[stackI] += 1;
                    nums[i] -= 1;
                }
            }

            stack.push(i);
        }

        return nums[stack.getLast()];
    }
}
