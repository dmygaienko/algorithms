package com.mygaienko.common.algorithms.leetcode.longest_arithmetic_subsequence;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Solution {

    int[] nums;
    Map<Integer, TreeSet<Integer>> numIndexes;
    int[][] memo;

    // find min, max N
    // put element to map (num per index) N

    // for each element try to find whether exist any element further (by index) via map    (N)
    //     for each element find
    //     for each step from min to max (consider that step could be negative as from 20 to 5) (1 -> N)
    //
    // count current length and compare with max
    // return max

    public int longestArithSeqLength(int[] nums) {
        this.nums = nums;
        this.numIndexes = new HashMap<>();
        this.memo = new int[nums.length][nums.length];

        for (int i = 0; i < nums.length; i++) {
            var val = nums[i];
            numIndexes.computeIfAbsent(val, v -> new TreeSet<>()).add(i);
        }

        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int currLength = 1;
            for (int j = i + 1; j < nums.length; j++) {
                currLength = 2;
                var step = nums[j] - nums[i];

                currLength += dp(j, step);

                maxLength = Math.max(maxLength, currLength);
            }
        }

        return maxLength;
    }

    private int dp(int index, int step) {
        Integer nextNum = nums[index] + step;
        var indexes = numIndexes.get(nextNum);
        Integer nextIndex = indexes == null ? null : indexes.higher(index);

        var currLength = 0;
        if (nextIndex != null) {
            var memoed = memo[index][nextIndex];
            if (memoed != 0) {
                return memoed;
            }

            currLength = 1 + dp(nextIndex, step);

            memo[index][nextIndex] = currLength;
        }

        return currLength;
    }

}
