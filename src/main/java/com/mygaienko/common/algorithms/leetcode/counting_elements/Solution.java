package com.mygaienko.common.algorithms.leetcode.counting_elements;

import java.util.HashMap;

class Solution {
    public int countElements(int[] arr) {
        var counts = new HashMap<Integer, Integer>();
        for (var num : arr) {
            counts.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }

        var result = 0;
        for (var entry : counts.entrySet()) {
            var count = entry.getValue();

            if (counts.containsKey(entry.getKey() + 1)) {
                result += count;
            }
        }
        return result;
    }
}