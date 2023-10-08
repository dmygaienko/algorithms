package com.mygaienko.common.algorithms.leetcode.fair_distribution_of_cookies;

class Solution {

    public int distributeCookies(int[] cookies, int k) {
        if (k == cookies.length) {
            return max(cookies);
        }
        return distributeCookies(cookies, new int[cookies.length], 0, k);
    }

    private int distributeCookies(int[] cookies, int[] groupCount, int i, int groups) {
        if (i == cookies.length) return getUnfair(groupCount);
        var unfair = Integer.MAX_VALUE;

        var bag = cookies[i];
        for (int k = 0; k < groups; k++) {

            groupCount[k] += bag;

            int result = distributeCookies(cookies, groupCount, i + 1, groups);
            unfair = Math.min(unfair, result);

            groupCount[k] -= bag;
        }
        return unfair;
    }

    private int getUnfair(int[] groupSum) {
        int max = Integer.MIN_VALUE;
        for (var sum : groupSum) {
            max = Math.max(max, sum);
        }
        return max;
    }

    private int max(int[] cookies) {
        int max = Integer.MIN_VALUE;
        for (var bag : cookies) {
            max = Math.max(max, bag);
        }
        return max;
    }
}
