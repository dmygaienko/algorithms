package com.mygaienko.common.algorithms.leetcode.insert_interval;

import java.util.LinkedList;

class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) return new int[][]{newInterval};

        int newIntervalStart = newInterval[0];
        int newIntervalEnd = newInterval[1];

        LinkedList<int[]> intervalList = new LinkedList<>();

        boolean inserted = false;
        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];

            if (current[0] <= newIntervalStart && newIntervalStart <= current[1] ||
                    newIntervalStart <= current[0] && current[0] <= newIntervalEnd
            ) {
                current[0] = Math.min(newIntervalStart, intervals[i][0]);
                inserted = true;
                while (i < intervals.length) {
                    if (newIntervalEnd >= intervals[i][0]) {

                        current[1] = Math.max(newIntervalEnd, intervals[i][1]);
                        i++;
                    } else {
                        i--;
                        break;
                    }
                }
            } else if (newIntervalEnd < current[0] && !inserted) {
                current = newInterval;
                inserted = true;
                i--;
            }

            intervalList.add(current);
        }

        if (!inserted) {
            if (intervalList.get(0)[0] > newInterval[1]) {
                intervalList.addFirst(newInterval);
            } else {
                intervalList.addLast(newInterval);
            }
        }

        return intervalList.toArray(new int[intervalList.size()][2]);
    }

}
