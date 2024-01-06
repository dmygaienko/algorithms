package com.mygaienko.common.algorithms.leetcode.factor_combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> getFactors(int n) {
        var factors = factors(n);
        if (factors.isEmpty()) return List.of();
        var curr = new ArrayList<Integer>();
        curr.add(factors.get(0));
        return combinate(factors, curr, 1);
    }

    private List<Integer> factors(int n) {
        var result = new ArrayList<Integer>();
        var val = n;
        while (val % 2 == 0) {
            val = val / 2;
            result.add(2);
        }

        while (val % 3 == 0) {
            val = val / 3;
            result.add(3);
        }

        return result;
    }

    private List<List<Integer>> combinate(List<Integer> factors, List<Integer> currFactors, int step) {
        var results = new ArrayList<List<Integer>>();
        if (step == factors.size()) {
            if (currFactors.size() > 1) {
                results.add(currFactors);
            }
            return results;
        }
        //keep
        var keepList = new ArrayList<>(currFactors);
        keepList.add(factors.get(step));
        var keepResults = combinate(factors, keepList, step + 1);
        if (!keepResults.isEmpty()) {
            results.addAll(keepResults);
        }

        //multiple
        var multipleList = new ArrayList<>(currFactors);
        var multiplied = multipleList.get(multipleList.size() - 1) * factors.get(step);
        multipleList.set(multipleList.size() - 1, multiplied);
        var multipleResults = combinate(factors, multipleList, step + 1);
        if (!multipleResults.isEmpty()) {
            results.addAll(multipleResults);
        }

        return results;
    }
}
