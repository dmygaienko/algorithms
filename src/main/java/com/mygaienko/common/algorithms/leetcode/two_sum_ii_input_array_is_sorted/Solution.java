package com.mygaienko.common.algorithms.leetcode.two_sum_ii_input_array_is_sorted;

class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length - 1;

        while (lo <= hi) {
            int sum = numbers[lo] + numbers[hi];

            if (sum == target) return new int[] {lo+1, hi+1};
            else if (sum < target) lo++;
            else hi--;
        }

        return new int[] {};
    }

}
