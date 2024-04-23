package com.mygaienko.common.algorithms.leetcode.missing_number_in_arithmetic_progression;

class Solution {
    public int missingNumber(int[] arr) {
        var last = arr.length - 1;
        var diff = (arr[last] - arr[0]) / arr.length;

        var left = 0;
        var right = last;

        while (left + 1 < right) {
            var mid = left + (right - left) / 2;
            double leftDiff = (arr[mid] - arr[left]) / (double) (mid - left);

            if (leftDiff == diff) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (left + 1 == right) {
            return arr[left] + diff;
        }

        return -1;
    }
}
