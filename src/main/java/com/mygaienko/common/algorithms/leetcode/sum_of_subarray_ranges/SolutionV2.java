package com.mygaienko.common.algorithms.leetcode.sum_of_subarray_ranges;

class SolutionV2 {
    public long subArrayRanges(int[] nums) {
        var sum = 0L;
        for (int i = 0; i < nums.length; i++) {

            var min = Integer.MAX_VALUE;
            var max = Integer.MIN_VALUE;
            for (int j = i; j < nums.length; j++) {
                var val = nums[j];

                min = Math.min(min, val);
                max = Math.max(max, val);

                sum += (max - min);
            }

        }

        return sum;

    }
}
