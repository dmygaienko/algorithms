package com.mygaienko.common.algorithms.leetcode.check_if_there_is_a_valid_partition_for_the_array;

class Solution {

    // divide solving problem to atomic steps which goes one after another
    // on each step we need to verify whether array was nicely partitioned before
    // 1) init dp array 1d with nums.length to states
    // 2) for every num - check whether array was partitioned before (i - 1), if yes check next ones.

    public boolean validPartition(int[] nums) {

        boolean[] dp = new boolean[nums.length];

        for (int i = 0; i + 1 < nums.length; i++) {
            if (i > 0 && !dp[i-1]) continue;

            if (i + 1 < nums.length && nums[i] == nums[i+1]) {
                dp[i+1] = true;

                if (i + 2 < nums.length && nums[i+1] == nums[i+2]) {
                    dp[i+2] = true;
                }
            } else if (i + 2 < nums.length && nums[i]+1 == nums[i+1] && nums[i+1]+1 == nums[i+2]) {
                dp[i+2] = true;
            }
        }

        return dp[nums.length-1];
    }
}