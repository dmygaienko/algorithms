package com.mygaienko.common.algorithms.leetcode.minimize_the_difference_between;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.minimizeTheDifference(new int[][]{
                {1},
                {2},
                {3}
        }, 100);
        assertThat(actual).isEqualTo(94);
    }

    @Test
    public void test0() {
        var actual = solution.minimizeTheDifference(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 13);
        assertThat(actual).isEqualTo(0);
    }
}