package com.mygaienko.common.algorithms.leetcode.binary_trees_with_factors;

import java.util.Arrays;
import java.util.HashMap;

class Solution {

    private static final int MODULO = (int) Math.pow(10, 9) + 7;

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);

        var valueIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            var num = arr[i];
            valueIndex.put(num, i);
        }

        var dp = new long[arr.length];
        Arrays.fill(dp, 1);


        for (int i = 1; i < arr.length; i++) {
            var root = arr[i];
            for (int j = 0; j < i; j++) {
                var right = arr[j];

                var left = root / right;
                var mod = root % right;
                var leftIndex = valueIndex.get(left);

                if (mod == 0 && leftIndex != null) {
                    dp[i] = (dp[i] + dp[leftIndex] * dp[j]) % MODULO;
                }
            }
        }

        long sum = 0;
        for (long num : dp) {
            sum += num;
        }

        return (int) (sum % MODULO);
    }
}
