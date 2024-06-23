package com.mygaienko.common.algorithms.leetcode.number_of_smooth_descent_periods_of_a_stock;

class Solution {

    public long getDescentPeriods(int[] prices) {

        var prev = 1L;
        var curr = 0L;
        var total = prev;

        for (int i = 1; i < prices.length; i++) {
            curr = 1;

            if (prices[i - 1] == prices[i] + 1) {
                curr += prev;
            }

            total += curr;
            prev = curr;
        }

        return total;
    }

}
