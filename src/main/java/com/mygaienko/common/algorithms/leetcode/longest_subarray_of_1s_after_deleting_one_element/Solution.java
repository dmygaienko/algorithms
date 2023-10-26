package com.mygaienko.common.algorithms.leetcode.longest_subarray_of_1s_after_deleting_one_element;

class Solution {

    // iterate over array
    // check if element is 1 or 0 and keep count of 1th
    // if 1 increment current length
    // if 0 then set current zero. if current zero is set before, then update it with new one and adjust length of
    // array with ones
    public int longestSubarray(int[] nums) {
        var maxLength = 0;

        int left = 0;
        var length = 0;
        var zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 1) {
                length++;
                maxLength = Math.max(maxLength, length);
            } else {
                zeroCount++;
            }

            while (zeroCount > 1 && left < right) {
                if (nums[left] == 1) {
                    length--;
                } else {
                    zeroCount--;
                }
                left++;
            }
        }
        return length == nums.length ? length - 1 : maxLength;
    }

}
