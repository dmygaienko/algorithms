package com.mygaienko.common.algorithms.leetcode.subarray_sum_equals_k;

class SolutionV2 {

    // iterate over array and count sum of subarray starting from length 1
    // if sum is not enough, move right point
    // if sum is bigger, move left point
    // if sum is equals to k then increase answer and move left point
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        int sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            sum += num;

            if (sum == k) {
                count++;
            }

            while (left < right &&
                    ((count > 0 && (sum > k || (sum < k && nums[left] < 0))) ||
                            (right == nums.length - 1))) {
                sum -= nums[left];
                left++;

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

}