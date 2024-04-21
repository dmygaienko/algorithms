package com.mygaienko.common.algorithms.leetcode.armstrong_number;

import java.util.ArrayList;

class Solution {
    public boolean isArmstrong(int n) {
        var digits = new ArrayList<Integer>();

        var val = n;
        while (val > 0) {
            var digit = val % 10;
            val = val / 10;
            digits.add(digit);
        }

        var result = 0;
        for (var digit : digits) {
            result += Math.pow(digit, digits.size());
        }

        return result == n;
    }
}
