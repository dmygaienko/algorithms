package com.mygaienko.common.algorithms.leetcode.meeting_scheduler;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

        Arrays.sort(slots1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(slots2, Comparator.comparingInt(a -> a[0]));

        for (int i = 0, j = 0; i < slots1.length && j < slots2.length;) {
            int[] nextSlot1 = slots1[i];
            int[] nextSlot2 = slots2[j];

            int s1 = nextSlot1[0];
            int e1 = nextSlot1[1];

            int s2 = nextSlot2[0];
            int e2 = nextSlot2[1];

            if (e1 - s1 < duration) { // validation
                i++;
            } else if (e1 < s2) { // #5
                i++;
            } else if (e2 - s2 < duration) { // validation
                j++;
            } else if (e2 < s1){ // #6
                j++;
            } else {
                int start = Math.max(s1, s2);
                int end = start + duration;

                if (end > e1) {
                    i++;
                    continue;
                } else if (end > e2) {
                    j++;
                    continue;
                }

                return List.of(start, end);
            }
        }

        return List.of();
    }
}
