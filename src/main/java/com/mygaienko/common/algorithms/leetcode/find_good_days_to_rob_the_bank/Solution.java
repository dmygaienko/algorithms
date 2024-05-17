package com.mygaienko.common.algorithms.leetcode.find_good_days_to_rob_the_bank;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        var nonIncrease = new int[security.length];
        for (int i = 1; i < security.length - time; i++) {
            if (security[i - 1] < security[i]) {
                nonIncrease[i] = 0;
            } else {
                nonIncrease[i] = nonIncrease[i - 1] + 1;
            }
        }

        var nonDecrease = new int[security.length];
        for (int i = security.length - 2; i - time >= 0; i--) {
            if (security[i] > security[i + 1]) {
                nonDecrease[i] = 0;
            } else {
                nonDecrease[i] = nonDecrease[i + 1] + 1;
            }
        }

        var goodDays = new ArrayList<Integer>();
        for (int i = time; i < security.length - time; i++) {
            if (nonIncrease[i] >= time && nonDecrease[i] >= time) {
                goodDays.add(i);
            }
        }

        return goodDays;
    }
}