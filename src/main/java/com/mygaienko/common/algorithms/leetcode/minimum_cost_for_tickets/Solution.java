package com.mygaienko.common.algorithms.leetcode.minimum_cost_for_tickets;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int L = days.length;
        int lastDay = days[L-1];
        int firstDay = days[0];
        int N = lastDay + 1;

        int[] dp = new int[N];
        dp[0] = 0;
        dp[firstDay] = Math.min(costs[2], Math.min(costs[0], costs[1]));
        if (days.length == 1) return dp[firstDay];

        for (int i = 2, d = 1; i < N; i++) {
            int nextAttend = days[d];
            if (i == nextAttend) {
                if (i - 1 >= 0) {
                    dp[i] = dp[i-1] + costs[0];
                }

                if (i - 7 >= 0 || dp[i] > costs[1])  {
                    int weekpay = dp[Math.max(i-7, 0)] + costs[1];
                    if (dp[i] > weekpay) {
                        fillMinPay(dp, i, 7, weekpay);
                    }
                }

                if (i - 30 >= 0 || dp[i] > costs[2]) {
                    int monthpay = dp[Math.max(i-30, 0)] + costs[2];
                    if (dp[i] > monthpay) {
                        fillMinPay(dp, i, 30, monthpay);
                    }
                }
                d++;
            } else if (i - 1 >= 0){
                if (dp[i] == 0) {
                    dp[i] = dp[i-1];
                }
            }
        }

        return dp[lastDay];
    }

    private void fillMinPay(int[] dp, int end, int period, int periodPay) {
        for (int j = end; j > Math.max(end - period, -1); j--) {
            dp[j] = Math.min(dp[j], periodPay);
        }
    }
}
