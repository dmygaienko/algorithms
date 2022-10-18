package com.mygaienko.common.algorithms.leetcode.leftmost_column_with_at_least_a_one;

class Solution {

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int result = Integer.MAX_VALUE;

        var dimensions = binaryMatrix.dimensions();
        int x = dimensions.get(0);
        int y = dimensions.get(1);

        for (int i = 0; i < x; i++) {

            int left = 0;
            int right = y - 1;

            while (left <= right) {
                int mid = left + (right - left)/2;

                int val = binaryMatrix.get(i , mid);

                if (val == 0) {
                    left = mid + 1;
                } else {
                    result = Math.min(result, mid);
                    right = mid - 1;
                }
            }

        }

        return result != Integer.MAX_VALUE ? result : -1;
    }

}