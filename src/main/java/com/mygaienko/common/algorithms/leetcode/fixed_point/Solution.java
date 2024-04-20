package com.mygaienko.common.algorithms.leetcode.fixed_point;

class Solution {

    public int fixedPoint(int[] arr) {
        var left = 0;
        var right = arr.length - 1;

        var result = Integer.MAX_VALUE;
        while (left <= right) {
            var mid = left + (right - left) / 2;

            var val = arr[mid];
            if (val == mid) {
                result = Math.min(result, val);
                right = mid - 1;
            } else if (val < mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

}