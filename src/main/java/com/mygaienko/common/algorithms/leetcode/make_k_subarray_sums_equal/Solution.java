package com.mygaienko.common.algorithms.leetcode.make_k_subarray_sums_equal;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        var operations = 0L;
        for (int i = 0; i < k; ++i) {
            var cycle = new ArrayList<Integer>();

            for (int j = i; arr[j] != 0; j = (j + k) % arr.length) {
                cycle.add(arr[j]);
                arr[j] = 0;
            }

            Collections.sort(cycle);

            for (var num : cycle) {
                operations += Math.abs(num - cycle.get(cycle.size() / 2));
            }
        }
        return operations;

    }
}
