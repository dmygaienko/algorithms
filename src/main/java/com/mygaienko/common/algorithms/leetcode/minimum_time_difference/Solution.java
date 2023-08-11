package com.mygaienko.common.algorithms.leetcode.minimum_time_difference;

import java.util.List;
import java.util.TreeSet;

class Solution {

    int dayMinutes = 24 * 60;

    public int findMinDifference(List<String> timePoints) {
        var set = new TreeSet<Integer>();

        for (String timePoint : timePoints) {
            String[] timeArr = timePoint.split(":");
            int timePointMinutes = Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
            if (!set.add(timePointMinutes)) return 0;
            set.add(timePointMinutes + dayMinutes);
        }

        int minDiff = Integer.MAX_VALUE;

        var iterator = set.iterator();
        Integer prev = null;
        while (iterator.hasNext()) {
            var next = iterator.next();
            if (prev != null) {
                minDiff = Math.min(minDiff, next - prev);
            }
            prev = next;
        }

        return minDiff;
    }

}
