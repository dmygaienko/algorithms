package com.mygaienko.common.algorithms.leetcode.campus_bikes_ii;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.assignBikes(
                new int[][]{{0, 0}, {2, 1}},
                new int[][]{{1, 2}, {3, 3}}
        );
        assertThat(actual).isEqualTo(6);
    }

    @Test
    public void test14() {
        int actual = solution.assignBikes(
                new int[][]{{0, 0}, {1, 0}, {2, 0}, {3, 0}, {4, 0}},
                new int[][]{{0, 999}, {1, 999}, {2, 999}, {3, 999}, {4, 999}, {5, 999}}
        );
        assertThat(actual).isEqualTo(4995);
    }
}