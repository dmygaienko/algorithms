package com.mygaienko.common.algorithms.leetcode.median_of_two_sorted_arrays;

@SuppressWarnings("Duplicates")
class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return findMedian(nums2);
        if (nums2 == null || nums2.length == 0) return findMedian(nums1);

        int length = nums1.length + nums2.length;

        int minMedian = nums1.length/2;
        int bigMedian = nums2.length/2;
        double minMedianVal = findMedian(nums1);
        double bigMedianVal = (int) findMedian(nums2);
        if (minMedianVal > bigMedianVal) {
            int temp = minMedian;
            minMedian = bigMedian;
            bigMedian = temp;

            int[] tempNums = nums1;
            nums1 = nums2;
            nums2 = tempNums;

            double temp2 = minMedianVal;
            minMedianVal = bigMedianVal;
            bigMedianVal = temp2;
        }

        return doFind(nums1, nums2, length, minMedian, bigMedian, minMedianVal, bigMedianVal);
    }

    private double doFind(int[] nums1, int[] nums2, int length, int minMedian, int bigMedian, double minMedianVal, double bigMedianVal) {
        int left = minMedian;
        int right = nums1.length - 1;
        int nums1Stay = 0;
        int nums1Left = 0;
        while (left <= right) {
            int mid = left + ( right - left ) / 2;
            int nextVal = nums1[mid];

            if (nextVal <= bigMedianVal) {
                nums1Stay += mid - left + 1;
                left = mid + 1;
            } else { // nextVal >= bigMedianVal
                nums1Left += right - mid + 1;
                right = mid - 1;
            }
        }

        int left2 = 0;
        int right2 = bigMedian;
        int nums2Stay = 0;
        int nums2Left = 0;
        while (left2 <= right2) {
            int mid2 = left2 + ( right2 - left2 ) / 2;
            int nextVal = nums2[mid2];

            if (nextVal < minMedianVal) {
                nums2Left += mid2 - left2 + 1;
                left2 = mid2 + 1;
            } else { // nextVal > minMedianVal
                nums2Stay = right2 - mid2 + 1;
                right2 = mid2 - 1;
            }
        }

        double medianIndex = (nums1.length + nums2.length - 1)/2d;
        int medianIndexInt = (int) medianIndex;
        int nums1NewLength = minMedian + nums1Stay + nums2Left;
        if (medianIndexInt < nums1NewLength - 1) {
            double v = medianIndex - nums2Left;
            int intV = (int) v;
            return v - intV == 0 ? (double) nums1[intV] : (nums1[intV] + nums1[intV +1])/2d;
        } else if (medianIndexInt == nums1NewLength - 1) {
            double v = medianIndex - nums2Left;
            int intV = (int) v;
            return v - intV == 0 ? (double) nums1[intV] : (nums1[intV] + nums2[nums1Left])/2d;
        } else { // medianIndex > nums1NewLength - 1
            double v = medianIndex - minMedian - nums1Stay;
            int intV = (int) v;
            return v - intV == 0 ? (double) nums2[intV] : (nums2[intV] + nums2[intV +1])/2d;
        }
    }

    public double findMedian(int[] nums) {
       return nums.length % 2 == 0 ? (nums[nums.length/2] + nums[(nums.length/2 - 1)])/2d : nums[nums.length/2];
    }

}
