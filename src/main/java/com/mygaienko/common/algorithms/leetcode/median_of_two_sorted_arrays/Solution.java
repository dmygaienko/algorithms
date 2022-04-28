package com.mygaienko.common.algorithms.leetcode.median_of_two_sorted_arrays;

class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int target = length/2;

        int minMedian = findMedian(nums1);
        int bigMedian = findMedian(nums2);
        int minMedianVal = nums1[minMedian];
        int bigMedianVal = nums2[bigMedian];
        if (minMedianVal > bigMedianVal) {
            int temp = minMedian;
            minMedian = bigMedian;
            bigMedian = temp;

            int[] tempNums = nums1;
            nums1 = nums2;
            nums2 = tempNums;

            int temp2 = minMedianVal;
            minMedianVal = bigMedianVal;
            bigMedianVal = temp2;
        }

        int left = minMedian;
        int right = nums1.length - 1;
        while (left <= right) {
            int mid = left + ( right - left ) / 2;
            int nextVal = nums1[mid];

            if (nextVal < bigMedianVal) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int left2 = 0;
        int right2 = bigMedian;
        while (left2 <= right2) {
            int mid2 = left2 + ( right2 - left2 ) / 2;
            int nextVal = nums2[mid2];

            if (nextVal < minMedianVal) {
                left2 = mid2 + 1;
            } else {
                right2 = mid2 - 1;
            }
        }

        double result = 0.0d;
        int currentIndex = left + left2;

        if (currentIndex < target && left < nums1.length - 1) {
            currentIndex = target - left;
            result = length % 2 == 0 ? (nums2[currentIndex] + nums2[currentIndex+1])/2d : nums2[currentIndex]/2d;
        } else if (currentIndex == target) {
            result = length % 2 == 0 ? findSafely(nums1, nums2, currentIndex) : nums1[currentIndex]/2d;
        }

        return result;
    }

    private double findSafely(int[] nums1, int[] nums2, int currentIndex) {
        if (currentIndex < nums1.length -1) {
            return (nums1[currentIndex] + nums1[currentIndex + 1]) / 2d;
        } else {
            return (nums1[currentIndex] + nums2[0]) / 2d;
        }

    }

    private int findMedian(int[] nums) {
        return nums.length % 2 == 0 ?
                (nums.length/2 + (nums.length/2 - 1))/2 :
                nums.length/2;
    }

}
