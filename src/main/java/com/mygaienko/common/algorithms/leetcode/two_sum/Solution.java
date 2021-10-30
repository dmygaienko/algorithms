package com.mygaienko.common.algorithms.leetcode.two_sum;

import java.util.*;

/**
 * https://leetcode.com/problems/two-sum/
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> numsToIndex = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int finalI = i;
            numsToIndex.compute(nums[i],
                    (k, list) -> (list == null)
                            ? newArrayList(finalI)
                            : addValue(list, finalI));
        }

        for (Map.Entry<Integer, List<Integer>> entry : numsToIndex.entrySet()) {
            Integer firstValue = entry.getKey();
            int secondValue = target - firstValue;
            List<Integer> secondValueIndexes = numsToIndex.get(secondValue);

            if (secondValueIndexes != null && secondValueIndexes.size() > 0) {
                Integer nextFirstIndex = entry.getValue().remove(0);
                Integer nextSecondIndex = secondValueIndexes.remove(0);
                return new int[] {nextFirstIndex, nextSecondIndex};
            }
        }

        return new int[] {};
    }

    private List<Integer> addValue(List<Integer> list, int value) {
        list.add(value);
        return list;
    }

    private List<Integer> newArrayList(int value) {
        List<Integer> list = new LinkedList<>();
        list.add(value);
        return list;
    }
}
