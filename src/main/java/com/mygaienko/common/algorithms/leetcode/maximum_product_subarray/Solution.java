package com.mygaienko.common.algorithms.leetcode.maximum_product_subarray;

class Solution {

    public int maxProduct(int[] nums) {
        int N = nums.length;

        int[] dp = new int[N*2];

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int cur = nums[i];
            dp[i*2] = cur;
            dp[i*2+1] = cur;
            max = Math.max(max, cur);
        }

        for (int s = 1; s < N; s++) {
            for (int i = 1; i < N; i++) {

                int cur = nums[i];
                int prev = dp[(i-1)*2];
                int product = cur * prev;

                int curMax = Math.max(cur, product);
                curMax = Math.max(curMax, cur * dp[(i-1)*2 +1]);
                curMax = Math.max(curMax, cur * nums[i-1]);
                dp[i*2] = Math.max(curMax, dp[i*2]);

                max = Math.max(max, curMax);

                int modPrev = dp[(i-1)*2 + 1];
                int smartPrev = cur > 0 ? modPrev : prev;
                int modPrevProduct = cur * smartPrev;
                int allModProduct = Math.abs(modPrevProduct);

                if (allModProduct >= Math.abs(dp[i*2+1])) {
                    dp[i*2+1] = modPrevProduct;
                }

                dp[i*2] = Math.max(curMax, modPrevProduct);
                max = Math.max(max, modPrevProduct);
            }
        }

        return max;
    }

}
