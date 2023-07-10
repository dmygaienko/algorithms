package com.mygaienko.common.algorithms.leetcode.four_sum_ii;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> first_sums = sum(nums1, nums2);
        Map<Integer, Integer> next_sums = sum(nums3, nums4);
        return combine(first_sums, next_sums);
    }

    private Map<Integer, Integer> sum(int[] nums1, int[] nums2) {
        Map<Integer, Integer> sums = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                int sum = n1 + n2;
                sums.compute(sum, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        return sums;
    }

    private int combine(Map<Integer, Integer> first_sums, Map<Integer, Integer> next_sums) {
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : first_sums.entrySet()) {
            int sum = entry.getKey();
            int occurrence = entry.getValue();

            Integer oppositeOccurrence = next_sums.get(-sum);
            if (oppositeOccurrence != null) {
                result += occurrence * oppositeOccurrence;
            }
        }

        return result;
    }

}
