package com.mygaienko.common.algorithms.leetcode.meeting_rooms_ii;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.function.Function;

class SolutionV3 {

    public int minMeetingRooms(int[][] intervals) {
        int length = intervals.length;

        Integer[] starts = new Integer[length];
        for (int i = 0; i < length; i++) {
            starts[i] = intervals[i][0];
        }

        Integer[] ends = new Integer[length];
        for (int i = 0; i < length; i++) {
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts, Comparator.comparingInt(a -> a));
        Arrays.sort(ends, Comparator.comparingInt(a -> a));

        int startIndex = 0;
        int endIndex = 0;
        int usingRooms = 0;

        while (startIndex < length) {

            if (starts[startIndex] >= ends[endIndex]) {
                usingRooms--;
                endIndex++;
            }

            startIndex++;
            usingRooms++;
        }

        return usingRooms;
    }

}
