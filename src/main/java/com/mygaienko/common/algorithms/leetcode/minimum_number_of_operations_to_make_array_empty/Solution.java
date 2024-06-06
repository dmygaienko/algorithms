package com.mygaienko.common.algorithms.leetcode.minimum_number_of_operations_to_make_array_empty;

import java.util.HashMap;

class Solution {

    public int minOperations(int[] nums) {
        var numCount = new HashMap<Integer, Integer>();
        for (var num : nums) {
            numCount.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }

        var operations = 0;
        for (var entry : numCount.entrySet()) {
            var count = entry.getValue();

            if (count == 1) return -1;

            var left = count % 3;
            if (left == 0) {
                operations += count / 3;
            } else if (left == 1) {
                operations += count / 3 + 1;
            } else if (left == 2) {
                operations += count / 3 + 1;
            } else if (count % 2 == 0) {
                operations += count / 2;
            }

        }

        return operations;
    }

}