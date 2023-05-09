package com.mygaienko.common.algorithms.leetcode.sort_colors;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest  {

    Solution solution = new Solution();

    @Test
    public void test() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        assertThat(nums).isEqualTo(new int[]{0, 0, 1, 1, 2, 2});
    }
}