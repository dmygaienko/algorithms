package com.mygaienko.common.algorithms.leetcode.number_of_subsequences_that_satisfy_the_given_sum_condition;

class SolutionV2 {


    //      1   2   3   4   5   6   7   8
    //      1   2
    //      1   2   3
    //      1   2   3   4
    //      1   2   3   4   5
    //      1   2   3   4   5   6
    //      1   2   3   4   5   6   7
    //      1   2   3   4   5   6   7   8
    //          2   3
    //          2   3   4
    //          2   3   4   5
    //          2   3   4   5   6
    //          2   3   4   5   6   7
    //          2   3   4   5   6   7   8
    //              3   4
    //              3   4   5
    //              3   4   5   6
    //              3   4   5   6   7
    //              3   4   5   6   7   8

    //  iterate array
    //  for each element find sum and put into dp

    public int numSubseq(int[] nums, int target) {
        var count = 0;

        var dp = new int[nums.length][nums.length];

        //init dp
        dp[0][0] = nums[0];
        for (int j = 1; j < nums.length; j++) {
            dp[0][j] = dp[0][j - 1] + nums[j];
            if (dp[0][j] <= target) count++;
        }

        // for each element find whether it was calculated sum for previous element and minus current element
        for (int i = 1; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = dp[i - 1][j] - nums[i - 1];
                if (dp[i][j] <= target) count++;
            }
        }

        return count;
    }

}
