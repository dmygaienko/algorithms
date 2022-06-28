package com.mygaienko.common.algorithms.leetcode.peak_index_in_a_mountain_array;

class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int peak = Integer.MIN_VALUE;
        int peakIndex = Integer.MIN_VALUE;

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            int val = arr[mid];

            if (mid > 0 && val > arr[mid-1] || mid == 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            if (val >= peak) {
                peak = val;
                peakIndex = mid;
            }
        }

        return peakIndex;
    }

}