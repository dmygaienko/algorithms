package com.mygaienko.common.algorithms.leetcode.single_element_in_a_sorted_array;

class Solution {

    public int singleNonDuplicate(int[] nums) {

        var left = 0;
        var right = nums.length - 1;

        while (left <= right) {
            var mid = left + (right - left)/2;
            var lengthEven = (mid - left + 1) % 2 == 0;

            if (left == right) {
                return nums[mid];
            } else if (mid - 1 >= 0 && mid + 1 < nums.length
                    && nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else if (mid + 1 < nums.length && lengthEven && nums[mid] != nums[mid + 1]) {
                left = mid + 1;
            } else if (mid + 1 < nums.length && !lengthEven && nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else if (mid - 1 >= 0 && lengthEven && nums[mid-1] != nums[mid]){
                right = mid - 1;
            } else {
                right = mid - 2;
            }
        }

        return -1;
    }

}