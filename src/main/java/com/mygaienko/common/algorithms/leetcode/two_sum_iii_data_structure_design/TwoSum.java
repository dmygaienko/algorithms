package com.mygaienko.common.algorithms.leetcode.two_sum_iii_data_structure_design;

import java.util.HashMap;
import java.util.Map;

class TwoSum {

    Map<Integer, Integer> counts = new HashMap<>();

    public TwoSum() {

    }

    public void add(int number) {
        counts.compute(number, (k, v) -> v == null ? 1 : v + 1);
    }

    public boolean find(int sum) {
        for (var entry : counts.entrySet()) {
            var val = entry.getKey();
            var target = sum - val;

            if (target == val && entry.getValue() > 1) return true;
            if (target != val && counts.containsKey(target)) return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
