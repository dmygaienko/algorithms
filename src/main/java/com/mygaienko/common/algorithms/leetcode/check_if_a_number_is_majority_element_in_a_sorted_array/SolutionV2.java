package com.mygaienko.common.algorithms.leetcode.check_if_a_number_is_majority_element_in_a_sorted_array;

class SolutionV2 {

    public boolean isMajorityElement(int[] nums, int target) {
        var right = findGreater(nums, target);
        var left = findLess(nums, target);

        return right != -1 && left != -1 && right - left + 1 > (nums.length / 2);
    }

    private int findGreater(int[] nums, int target) {
        var left = 0;
        var right = nums.length - 1;

        var result = Integer.MIN_VALUE;
        while (left <= right) {
            var mid = left + (right - left) / 2;

            var val = nums[mid];
            if (val == target) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else if (val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result == Integer.MIN_VALUE ? -1 : result;
    }

    private int findLess(int[] nums, int target) {
        var left = 0;
        var right = nums.length - 1;

        var result = Integer.MAX_VALUE;
        while (left <= right) {
            var mid = left + (right - left) / 2;

            var val = nums[mid];
            if (val == target) {
                result = Math.min(result, mid);
                right = mid - 1;
            } else if (val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
