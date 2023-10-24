package com.mygaienko.common.algorithms.leetcode.longest_arithmetic_subsequence;

import java.util.HashMap;
import java.util.TreeSet;

class Solution {

    // find min, max N
    // put element to map (num per index) N

    // for each element try to find whether exist any element further (by index) via map    (N)
    //     for each element find
    //     for each step from min to max (consider that step could be negative as from 20 to 5) (1 -> N)
    //
    // count current length and compare with max
    // return max

    public int longestArithSeqLength(int[] nums) {

        var numIndexes = new HashMap<Integer, TreeSet<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            var val = nums[i];
            numIndexes.computeIfAbsent(val, v -> new TreeSet<>()).add(i);
        }

        int[][] memo = new int[nums.length][nums.length];

        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int currLength = 1;
            for (int j = i + 1; j < nums.length; j++) {
                currLength = 2;
                var step = nums[j] - nums[i];

                Integer nextIndex = j;
                Integer nextNum = null;

                while (nextNum == null || nextIndex != null) {

                    if (nextNum == null) {
                        nextNum = nums[j] + step;
                    } else {
                        nextNum = nextNum + step;
                    }

                    var indexes = numIndexes.get(nextNum);
                    nextIndex = indexes == null ? null : indexes.higher(nextIndex);

                    if (nextIndex != null) {
                        currLength++;
                    }

                }

                maxLength = Math.max(maxLength, currLength);
            }
        }

        return maxLength;
    }
}
