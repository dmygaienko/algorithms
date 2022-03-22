package com.mygaienko.common.algorithms.leetcode.missing_ranges;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final int EMPTY = Integer.MIN_VALUE;

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ranges = new ArrayList<>();

        int currentLower = lower;

        int existing = EMPTY;
        int n = 0;

        while (currentLower <= upper) {

            if (nums != null && n < nums.length) {
                existing = nums[n];
            }

            if (currentLower < existing) {
                ranges.add(getRange(currentLower, existing - 1));
                currentLower = existing + 1;
            } else if (currentLower > existing) {
                ranges.add(getRange(currentLower, upper));
                currentLower = upper + 1; // end
            } else {
                currentLower = existing + 1;
            }

            if (nums != null && n < nums.length - 1) n++;
        }

        return ranges;
    }

    private String getRange(int lower, int upper) {
        String range = null;
        if (lower != EMPTY) {
            if (lower < upper) {
                range = lower + "->" + upper;
            } else {
                range = String.valueOf(lower);
            }
        }
        return range;
    }

}
