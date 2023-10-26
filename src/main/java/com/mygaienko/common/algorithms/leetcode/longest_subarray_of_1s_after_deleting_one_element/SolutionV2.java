package com.mygaienko.common.algorithms.leetcode.longest_subarray_of_1s_after_deleting_one_element;

class SolutionV2 {

    // iterate over array
    // check if element is 1 or 0 and keep count of 1th
    // if 1 increment current length
    // if 0 then set current zero. if current zero is set before, then update it with new one and adjust length of
    // array with ones
    public int longestSubarray(int[] nums) {
        var maxLength = 0;
        var length = 0;

        var prevZeroIndex = -1;
        var zeroIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            var num = nums[i];

            if (num == 1) {
                length++;
                maxLength = Math.max(maxLength, length);
            } else if (i - 1 >= 0 && nums[i - 1] == 0) {
                length = 0;
            } else if (zeroIndex != -1 || i == nums.length - 1) {
                maxLength = Math.max(maxLength, length);

                if (prevZeroIndex != -1 && prevZeroIndex + 1 < zeroIndex) {
                    length = length - (zeroIndex - prevZeroIndex);
                }

                prevZeroIndex = zeroIndex;
                zeroIndex = i;
            } else {
                zeroIndex = i;
            }
        }
        maxLength = Math.max(maxLength, length);
        return zeroIndex == -1 ? maxLength - 1 : maxLength;
    }

}
