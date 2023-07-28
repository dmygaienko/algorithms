package com.mygaienko.common.algorithms.leetcode.first_missing_positive;

class Solution {

    /**
     * SOLUTION 1
     *
     * find max
     * divide on groups 0 - 4, 5 - 9, till max
     * while running through array count sum
     * find first group which sum is differs from expected
     *
     * SOLUTION 2
     *
     * while iterating array try to complete (groups - 4) if group completed,
     * repeat from the start till you cannot complete group
     *
     * SOLUTION 2
     *
     * use two pointers ??
     */
    public int firstMissingPositive(int[] nums) {

        int min = 0;
        int max = 0;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val >= 0) {
                max = Math.max(max, val);
                sum += val;
            }
        }

        int expectedSum = calculateSum(min, max);

        int diff = expectedSum - sum;

        return diff != 0 ? diff : max + 1;
    }

    private int calculateSum(int min, int max) {
        int sum = 0;
        for(int i = min; i <= max; i++) {
            sum += i;
        }
        return sum;
    }

}