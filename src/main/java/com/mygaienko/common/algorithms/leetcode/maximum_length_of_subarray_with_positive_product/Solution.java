package com.mygaienko.common.algorithms.leetcode.maximum_length_of_subarray_with_positive_product;

class Solution {
    public int getMaxLen(int[] nums) {
        var maxLength = 0;

        var currPosLength = 0;
        var currNegLength = 0;
        for (var num : nums) {
            if (num == 0) {
                currPosLength = 0;
                currNegLength = 0;
            } else if (num > 0) {
                currPosLength++;

                if (currNegLength > 0) {
                    currNegLength++;
                }
            } else {
                var temp = currNegLength;
                currNegLength = currPosLength + 1;

                if (temp > 0) {
                    currPosLength = temp + 1;
                } else {
                    currPosLength = 0;
                }
            }

            maxLength = Math.max(maxLength, currPosLength);
        }

        return maxLength;
    }
}