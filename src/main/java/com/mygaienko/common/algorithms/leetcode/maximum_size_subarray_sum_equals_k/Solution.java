package com.mygaienko.common.algorithms.leetcode.maximum_size_subarray_sum_equals_k;

import java.util.HashMap;

class Solution {

    // iterate over array and calculate prefix sum
    // on each step add element to hashmap with its index
    // on each element find whether exist sum - k element
    // if exist find its length
    public int maxSubArrayLen(int[] nums, int k) {
        var maxLength = 0;
        var valIndexes = new HashMap<Integer, Integer>();

        var prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        valIndexes.put(nums[0], 0);
        if (prefixSum[0] == k) {
            maxLength = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            var val = nums[i];
            prefixSum[i] = prefixSum[i - 1] + val;

            if (prefixSum[i] == k) {
                maxLength = Math.max(maxLength, i + 1);
            }

            var target = prefixSum[i] - k;

            var idx = valIndexes.getOrDefault(target, i);
            var length = i - idx;

            maxLength = Math.max(maxLength, length);

            valIndexes.putIfAbsent(prefixSum[i], i);
        }

        return maxLength;
    }

}