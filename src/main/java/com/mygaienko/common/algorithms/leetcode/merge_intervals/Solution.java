package com.mygaienko.common.algorithms.leetcode.merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] current  = intervals[i];

            while (i + 1 < intervals.length && intervals[i+1][0] <= current[1]) {
                int[] next = intervals[++i];
                current[1] = Math.max(current[1], next[1]);
            }

            list.add(current);
        }

        return list.toArray(new int[list.size()][2]);
    }

}