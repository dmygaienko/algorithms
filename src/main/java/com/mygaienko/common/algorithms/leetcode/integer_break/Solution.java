package com.mygaienko.common.algorithms.leetcode.integer_break;

import java.util.HashMap;
import java.util.Map;

class Solution {

    // from 0 to n
    // make all possible break sum
    // for each group calculate product and compare with max
    // use memoization
    public int integerBreak(int n) {
        if (n <= 3) return n - 1;
        HashMap<Integer, Integer> memo = new HashMap<>();
        integerBreak(n, memo);
        return memo.get(n);
    }

    private int integerBreak(int n, Map<Integer, Integer> memo) {
        if (n <= 3) return n;

        Integer memoed = memo.get(n);
        if (memoed != null) {
            return memoed;
        }

        int max = 0;
        for (int i = 2; i < n; i++) {
            max = Math.max(max, i * integerBreak(n - i, memo));
        }

        memo.put(n, max);

        return max;
    }
}
