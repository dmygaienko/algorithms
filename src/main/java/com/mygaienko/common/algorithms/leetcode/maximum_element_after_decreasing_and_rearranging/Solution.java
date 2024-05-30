package com.mygaienko.common.algorithms.leetcode.maximum_element_after_decreasing_and_rearranging;

import java.util.Arrays;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);

        if (arr[0] != 1) {
            arr[0] = 1;
        }

        var max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            var curr = arr[i];
            var prev = arr[i - 1];
            var diff = Math.abs(curr - prev);
            if (diff > 1) {
                arr[i] = prev + 1;
            }

            max = Math.max(max, arr[i]);
        }

        return max;
    }
}