package com.mygaienko.common.algorithms.leetcode.find_smallest_common_element_in_all_rows;

class Solution {

    public int smallestCommonElement(int[][] mat) {
        var counter = new int[10001];

        for (var row : mat) {
            for (var val : row) {
                counter[val]++;
            }
        }

        for (int i = 0; i < counter.length; i++) {
            var c = counter[i];
            if (c == mat.length) {
                return i;
            }
        }

        return -1;
    }

}