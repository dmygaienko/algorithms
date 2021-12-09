package com.mygaienko.common.algorithms.leetcode.split_array_largest_sum;

/**
 * 410. Split Array Largest Sum https://leetcode.com/problems/split-array-largest-sum/
 * <p>
 * Let's define f[i][j] to be the minimum largest subarray sum for splitting nums[0..i] into j parts.
 * <p>
 * Consider the jth subarray. We can split the array from a smaller index k to i to form it.
 * Thus f[i][j] can be derived from max(f[k][j - 1], nums[k + 1] + ... + nums[i]).
 * For all valid index k, f[i][j] should choose the minimum value of the above formula.
 * <p>
 * The final answer should be f[n][m], where n is the size of the array.
 * <p>
 * For corner situations, all the invalid f[i][j] should be assigned with INFINITY, and f[0][0] should be initialized with 0.
 */
class SolutionV2 {

    public int splitArray(int[] nums, int m) {

        int[] sums = new int[nums.length + 1];

        int[][] f = new int[nums.length + 1][m + 1];

        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }

        f[0][0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= m; j++) {

                for (int k = 0; k < i; k++) {

                    int lessDivValue = f[k][j - 1];
                    int remainedSumDiff = sums[i] - sums[k];
                    int exist = f[i][j];
                    int res = Math.min(exist, //existing
                            Math.max(
                                    lessDivValue, // prev value
                                    remainedSumDiff) // sum of subarray k to i
                    );
                    f[i][j] = res;
                }
            }
        }

        return f[nums.length][m];
    }

}
