package com.mygaienko.common.algorithms.leetcode.maximum_product_subarray;

class SolutionV2 {

    public int maxProduct(int[] nums) {
        int N = nums.length;

        int[] dp = new int[N];
        int[] absDp = new int[N];

        int max = init(nums, dp, absDp);

        for (int i = 1; i < N; i++) {
            init(nums, dp, absDp);

            for (int s = i; s < N; s++) {

                int cur = nums[s];
                int prev = dp[s-1];
                int product = cur * prev;

                int curMax = Math.max(cur, product);
                dp[s] = curMax;

                max = Math.max(max, curMax);

                int absPrev = absDp[s-1];
                int absPrevProduct = cur * absPrev;
                int absModProduct = Math.abs(cur) * Math.abs(absPrev);

                if (absPrevProduct == absModProduct && absPrevProduct > product) {
                    dp[s] = absPrevProduct;
                    max = Math.max(max, absPrevProduct);
                }

                absDp[s] = absPrevProduct;
            }
        }

        return max;
    }

    private static int init(int[] nums, int[] dp, int[] absDp) {
        int max = Integer.MIN_VALUE;
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int cur = nums[i];
            dp[i] = cur;
            absDp[i] = cur;
            max = Math.max(max, cur);
        }
        return max;
    }

}
