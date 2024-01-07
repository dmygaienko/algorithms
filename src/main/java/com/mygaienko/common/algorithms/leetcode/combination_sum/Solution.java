package com.mygaienko.common.algorithms.leetcode.combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combination(candidates, 0, new ArrayList<>(), target);
    }

    private List<List<Integer>> combination(int[] candidates,
                                            int index,
                                            List<Integer> current,
                                            int target) {
        var result = new ArrayList<List<Integer>>();
        if (target == 0) {
            result.add(new ArrayList<>(current));
        }

        for (int i = index; i < candidates.length; i++) {
            var cand = candidates[i];

            var lastValue = current.isEmpty() ? Integer.MIN_VALUE : current.get(current.size() - 1);
            if (cand <= target) {

                if (cand >= lastValue) {
                    current.add(cand);
                    var combinations = combination(candidates, i, current, target - cand);
                    if (!combinations.isEmpty()) {
                        result.addAll(combinations);
                    }
                    current.remove(current.size() - 1);
                }

            } else {
                break;
            }

        }

        return result;
    }

}