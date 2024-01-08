package com.mygaienko.common.algorithms.leetcode.combinations;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> combine(int n, int k) {
        var result = new ArrayList<List<Integer>>();
        combine(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void combine(int n, int k, int index,
                         List<Integer> current,
                         List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i <= n; i++) {
            current.add(i);
            combine(n, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

}
