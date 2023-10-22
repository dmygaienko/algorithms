package com.mygaienko.common.algorithms.leetcode.longest_non_decreasing_subarray_from_two_arrays;

import java.util.Arrays;

@SuppressWarnings("Duplicates")
class Solution {

    // 2 3 1 2 1
    // 2 2 3 1 2


    /**
     * Initialize dp[i][0] to 1.
     * <p>
     * If nums1[i] >= nums1[i - 1] then dp[i][0] may be dp[i - 1][0] + 1.
     * If nums1[i] >= nums2[i - 1] then dp[i][0] may be dp[i - 1][1] + 1.
     * <p>
     * Perform a similar calculation for nums2[i] and dp[i][1].
     */
    // cache previous calculation in memo
    // on each step compare prev dp value with current and put it to the result
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int max = 1;
        int N = nums1.length;

        var dp1 = new int[N];
        Arrays.fill(dp1, 1);

        var dp2 = new int[N];
        Arrays.fill(dp2, 1);

        for (int i = 1; i < N; i++) {

            if (nums1[i] >= nums1[i - 1]) {
                dp1[i] = Math.max(dp1[i], dp1[i - 1] + 1);
            }

            if (nums1[i] >= nums2[i - 1]) {
                dp1[i] = Math.max(dp1[i], dp2[i - 1] + 1);
            }

            if (nums2[i] >= nums2[i - 1]) {
                dp2[i] = Math.max(dp2[i], dp2[i - 1] + 1);
            }

            if (nums2[i] >= nums1[i - 1]) {
                dp2[i] = Math.max(dp2[i], dp1[i - 1] + 1);
            }

            max = Math.max(max, dp1[i]);
            max = Math.max(max, dp2[i]);
        }

        return max;
    }
}
