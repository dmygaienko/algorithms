package com.mygaienko.common.algorithms.leetcode.kth_largest_element_in_array;

/**
 * quickselect
 */
public class Solution2 {

    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, nums.length - k, 0, nums.length - 1);
    }

    private int quickselect(int[] nums, int k, int left, int right) {
        if (left == right) return nums[left];

        int pivotIndex = partition(nums, left, right);

        if (k == pivotIndex) {
            return nums[pivotIndex];
        } else if (k < pivotIndex) {
            return quickselect(nums, k, left, pivotIndex - 1);
        } else {
            return quickselect(nums, k, pivotIndex + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int j = left;

        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, j);
                j++;
            }
        }
        swap(nums, j, right);
        return j;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
