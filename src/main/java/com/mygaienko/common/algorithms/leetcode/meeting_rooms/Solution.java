package com.mygaienko.common.algorithms.leetcode.meeting_rooms;

import java.util.Arrays;

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        var canAttend = true;
        int[] prevMeeting = null;

        for (int i = 0; i < intervals.length; i++) {
            var currMeeting = intervals[i];
            if (prevMeeting != null && prevMeeting[1] > currMeeting[0]) {
                return false;
            }

            prevMeeting = currMeeting;
        }
        return canAttend;
    }
}