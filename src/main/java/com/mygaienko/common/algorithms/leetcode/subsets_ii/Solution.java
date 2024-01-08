package com.mygaienko.common.algorithms.leetcode.subsets_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        var result = new ArrayList<List<Integer>>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int index,
                           List<Integer> current,
                           List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        if (current.size() == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i - 1] == nums[i]) continue;

            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

}