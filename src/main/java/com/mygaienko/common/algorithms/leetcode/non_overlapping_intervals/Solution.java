package com.mygaienko.common.algorithms.leetcode.non_overlapping_intervals;

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? ((a[1] - a[0]) - (b[1] - b[0])) : a[1] - b[1]);

        var eraseCount = 0;
        var prevEnd = Integer.MIN_VALUE;

        for (var interval : intervals) {

            if (prevEnd == Integer.MIN_VALUE || prevEnd <= interval[0]) {
                prevEnd = interval[1];
            } else {
                eraseCount++;
            }

        }

        return eraseCount;
    }
}
