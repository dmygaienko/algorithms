package com.mygaienko.common.algorithms.leetcode.sum_of_subarray_ranges;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.subArrayRanges(new int[]{1, 2, 3});
        assertThat(actual).isEqualTo(4L);
    }

    @Test
    public void test1() {
        var actual = solution.subArrayRanges(new int[]{2, 4, 6, 4, 14, 5, 1, 3});
        assertThat(actual).isEqualTo(249);
    }
}