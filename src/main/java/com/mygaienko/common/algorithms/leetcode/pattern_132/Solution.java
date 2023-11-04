package com.mygaienko.common.algorithms.leetcode.pattern_132;

import java.util.ArrayList;
import java.util.LinkedList;

class Solution {


    // TODO fix with min array
    // iterate overn nums
    // assign element to min Max and curMin and curMax and check whether next is in between
    // 1 2 4 10 4 2 11 12 3
    public boolean find132pattern(int[] nums) {

        var min = Integer.MAX_VALUE;
        var monoStack = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            var next = nums[i];
            min = Math.min(min, next);

            var poppedList = new LinkedList<Integer>();
            while (!monoStack.isEmpty() && nums[monoStack.peek()] > next) {
                var popped = monoStack.pop();

                if (min < popped && popped > next) {
                    return true;
                }
                poppedList.add(popped);
            }

            monoStack.push(i);
            poppedList.forEach(monoStack::push);
            poppedList.clear();
        }

        return false;
    }


}