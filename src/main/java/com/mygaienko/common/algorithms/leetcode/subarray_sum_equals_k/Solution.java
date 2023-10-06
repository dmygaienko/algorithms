package com.mygaienko.common.algorithms.leetcode.subarray_sum_equals_k;

import java.util.HashMap;

class Solution {

    public int subarraySum(int[] nums, int k) {
        int count = 0;

        var prefixSum = new HashMap<Long, Integer>();
        long sum = 0;
        prefixSum.put(0L, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            count += prefixSum.getOrDefault(sum - k, 0);

            prefixSum.compute(sum, (key, v) -> v == null ? 1 : v + 1);
        }
        return count;
    }

}