package com.mygaienko.common.algorithms.leetcode.minimum_swaps_to_group_all_1s_together_ii;

class Solution {

    public int minSwaps(int[] nums) {

        var total = 0;
        for (var val : nums) {
            if (val == 1) {
                total++;
            }
        }

        var circular = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            var next = nums[i];
            circular[i] = next;
            circular[i + nums.length] = next;
        }

        var min = total;

        var curr = 0;

        var left = 0;
        var right = 0;

        for (; right < circular.length; right++) {
            if (right == left + total) {
                if (circular[left] == 1) {
                    curr--;
                }
                left++;
            }

            if (circular[right] == 1) {
                curr++;
            }

            min = Math.min(min, total - curr);
        }

        return min;
    }

}
