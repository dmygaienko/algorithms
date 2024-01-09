package com.mygaienko.common.algorithms.leetcode.combination_sum_iii;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        var result = new ArrayList<List<Integer>>();
        backtrack(k, 0, n, new ArrayList<>(), result);
        return result;
    }

    void backtrack(int k,
                   int value,
                   int target,
                   List<Integer> current,
                   List<List<Integer>> result) {
        if (k == 0) {
            if (target == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = value + 1; i <= 9; i++) {
            if (target - i < 0) break;

            current.add(i);
            backtrack(k - 1, i, target - i, current, result);
            current.remove(current.size() - 1);
        }
    }

}