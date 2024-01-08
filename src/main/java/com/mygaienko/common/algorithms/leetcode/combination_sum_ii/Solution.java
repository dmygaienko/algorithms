package com.mygaienko.common.algorithms.leetcode.combination_sum_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    //
    // calculate value frequencies for each candidate
    // use backtrack approach
    // iterate on map frequencies
    // on each value decrement count and target
    // if count equal zero skip
    // if target equal zero add current list to result
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        var result = new ArrayList<List<Integer>>();
        backtrack(candidates, 0, new ArrayList<>(), target, result);
        return result;
    }

    private void backtrack(int[] candidates,
                           int index,
                           List<Integer> current,
                           int target,
                           List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
        }

        for (int i = index; i < candidates.length; i++) {
            var value = candidates[i];

            if (i > index && candidates[i] == candidates[i - 1]) continue;
            if (target - value < 0) break;

            current.add(value);
            backtrack(candidates, i + 1, current, target - value, result);
            current.remove(current.size() - 1);
        }
    }

}