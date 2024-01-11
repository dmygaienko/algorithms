package com.mygaienko.common.algorithms.leetcode.max_consecutive_ones_ii;

class Solution {

    // traverse with two iterators: left and right
    // on each step increase right iterator
    // and check next number
    // if next number is 1 check max length
    // if next number is 0 and one of the nums are already flipped than move left iterator
    // if next number is 0 and no flip then set as flipped
    public int findMaxConsecutiveOnes(int[] nums) {
        var left = 0;
        var right = 0;

        var maxLength = 0;
        var zeroCount = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

}