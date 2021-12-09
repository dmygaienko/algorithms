package com.mygaienko.common.algorithms.leetcode.meeting_rooms_ii;

import java.util.Arrays;

class Solution {

    public int minMeetingRooms(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < intervals.length; i++) {
            int[] fromTo = intervals[i];
            min = Math.min(min, fromTo[0]);
            max = Math.max(max, fromTo[1]);
        }

        int maxMeet = 0;
        int [] sch = new int[max-min];
        Arrays.fill(sch, 0);

        for (int i = 0; i < intervals.length; i++) {
            int[] fromTo = intervals[i];
            int start = fromTo[0];
            int end = fromTo[1];

            for (int j = start; j < end; j++) {
                sch[j-min] += 1;
                maxMeet = Math.max(sch[j-min], maxMeet);
            }
        }
        return maxMeet;
    }

}
