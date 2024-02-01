package com.mygaienko.common.algorithms.leetcode.remove_interval;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        var rmvFrom = toBeRemoved[0];
        var rmvTo = toBeRemoved[1];

        var result = new ArrayList<List<Integer>>();
        for (int i = 0; i < intervals.length; i++) {
            var next = intervals[i];
            var from = next[0];
            var to = next[1];

            if (rmvTo <= from || to <= rmvFrom) {
                result.add(List.of(from, to));
            } else if (from < rmvFrom && rmvTo < to) {
                result.add(List.of(from, rmvFrom));
                result.add(List.of(rmvTo, to));
            } else if (from < rmvFrom && rmvFrom < to) {
                result.add(List.of(from, rmvFrom));
            } else if (rmvFrom <= from && from < rmvTo && rmvTo < to) {
                result.add(List.of(rmvTo, to));
            }
        }
        return result;
    }
}