package com.mygaienko.common.algorithms.leetcode.maximum_distance_in_arrays;

import java.util.List;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        var min = arrays.get(0).get(0);
        var max = arrays.get(0).get(arrays.get(0).size() - 1);

        var result = 0;
        for (int i = 1; i < arrays.size(); i++) {
            var arr = arrays.get(i);
            var first = arr.get(0);
            var last = arr.get(arr.size() - 1);

            var curr = Math.max(Math.abs(last - min), Math.abs(max - first));
            result = Math.max(result, curr);

            min = Math.min(min, first);
            max = Math.max(max, last);
        }

        return result;
    }
}
