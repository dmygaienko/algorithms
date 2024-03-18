package com.mygaienko.common.algorithms.leetcode.maximum_average_subarray_ii;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test() {
        double actual = solution.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4);
        assertThat(actual).isEqualTo(12.75);
    }
}