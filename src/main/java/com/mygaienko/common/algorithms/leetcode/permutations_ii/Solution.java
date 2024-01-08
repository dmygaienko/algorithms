package com.mygaienko.common.algorithms.leetcode.permutations_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        var result = new ArrayList<List<Integer>>();

        var counter = new HashMap<Integer, Integer>();
        for (var num : nums) {
            counter.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }

        backtrack(nums, new ArrayList<>(), result, counter);
        return result;
    }

    private void backtrack(int[] nums,
                           List<Integer> current,
                           List<List<Integer>> result,
                           Map<Integer, Integer> counter) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (var entry : counter.entrySet()) {
            var val = entry.getKey();
            var count = entry.getValue();

            if (count == 0) {
                continue;
            } else {
                counter.put(val, count - 1);
            }
            current.add(val);

            backtrack(nums, current, result, counter);

            current.remove(current.size() - 1);
            counter.put(val, count);
        }
    }
}