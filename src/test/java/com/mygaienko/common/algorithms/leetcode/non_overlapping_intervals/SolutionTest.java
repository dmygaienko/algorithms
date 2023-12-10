package com.mygaienko.common.algorithms.leetcode.non_overlapping_intervals;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.eraseOverlapIntervals(new int[][]{{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}});
        assertThat(actual).isEqualTo(2);
    }
}