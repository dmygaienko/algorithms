package com.mygaienko.common.algorithms.leetcode.minimize_the_maximum_difference_of_pairs;

import java.util.Arrays;

/**
 * Dynamic programming (bottom up): space optimization
 */
class SolutionV2 {
/*

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int[][] memo = new int[nums.length + 1][p + 1];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));
        return minimizeMax(nums, memo, p, 0);
    }

    private int minimizeMax(int[] nums, int[][] memo, int p, int i) {
        Integer memoed = memo[i][p];
        if (memoed != -1) return memoed;

        if (p == 0) return 0;
        else if (i + 1 >= nums.length) return Integer.MAX_VALUE;

        var minMax = Math.min(
                minimizeMax(nums, memo, p, i + 1),
                Math.max(nums[i + 1] - nums[i], minimizeMax(nums, memo, p - 1, i + 2)));

        memo[i][p] = minMax;

        return minMax;

    }
*/

    public int minimizeMax(int[] nums, int pairs) {
        if (pairs == 0) return 0;

        Arrays.sort(nums);
        int[][] memo = new int[2][nums.length];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));

        //init
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            memo[0][i] = diff;

            if (memo[0][i - 1] != -1) {
                memo[0][i] = Math.min(memo[0][i], memo[0][i - 1]); // skip flow
            }
        }

        for (int p = 1; p < pairs; p++) {
            Arrays.fill(memo[p % 2], -1);

            for (int i = 2; i < nums.length; i++) {
                if (memo[(p - 1) % 2][i - 2] == -1) {
                    continue;
                }

                int diff = nums[i] - nums[i - 1];
                int prev = memo[(p - 1) % 2][i - 2];
                memo[p % 2][i] = Math.max(prev, diff);

                if (memo[p % 2][i - 1] != -1) {
                    memo[p % 2][i] = Math.min(memo[p % 2][i], memo[p % 2][i - 1]); // skip flow
                }
            }

//            // skip flow
//            for (int i = 1; i < nums.length; i++) {
//                if (memo[p % 2][i] == -1) {
//                    memo[p % 2][i] = memo[p % 2][i-1];
//                }
//            }
        }

        int minMax = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            var val = memo[(pairs - 1) % 2][i];
            if (val != -1) {
                minMax = Math.min(minMax, val);
            }
        }

        return minMax;
    }

}
