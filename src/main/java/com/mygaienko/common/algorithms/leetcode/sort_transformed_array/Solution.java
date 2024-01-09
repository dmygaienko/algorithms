package com.mygaienko.common.algorithms.leetcode.sort_transformed_array;

import java.util.Arrays;

public class Solution {

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            var num = nums[i];
            result[i] = a * (int) Math.pow(num, 2) + b * num + c;
        }
        Arrays.sort(result);
        return result;
    }

}
