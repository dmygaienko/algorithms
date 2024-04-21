package com.mygaienko.common.algorithms.leetcode.largest_unique_number;

import java.util.HashMap;

class Solution {

    public int largestUniqueNumber(int[] nums) {
        var counts = new HashMap<Integer, Integer>();

        for (var num : nums) {
            counts.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }

        var largest = Integer.MIN_VALUE;
        for (var entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                largest = Math.max(largest, entry.getKey());
            }
        }

        return largest == Integer.MIN_VALUE ? -1 : largest;
    }

}