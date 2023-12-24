package com.mygaienko.common.algorithms.leetcode.count_nice_pairs_in_an_array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

class Solution {

    int MOD = (int) Math.pow(10, 9) + 7;

    // iterate over array
    // put each value to map count
    // iterate over map entries and try to found reverse number
    // if found multiply current count on found count and add product to total count.
    public int countNicePairs(int[] nums) {
        var totalCount = 0;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - reverse(nums[i]);
        }

        var seenDiffCount = new HashMap<Integer, Integer>();
        for (var diff : nums) {

            var count = seenDiffCount.getOrDefault(diff, 0);
            if (count != 0) {
                totalCount = (totalCount + count) % MOD;
            }
            count = (count + 1) % MOD;
            seenDiffCount.put(diff, count);
        }

        return totalCount;
    }

    public int reverse(int num) {
        int result = 0;
        while (num > 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }

        return result;
    }

}
