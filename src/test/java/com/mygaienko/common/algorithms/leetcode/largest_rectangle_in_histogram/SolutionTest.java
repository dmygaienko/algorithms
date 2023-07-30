package com.mygaienko.common.algorithms.leetcode.largest_rectangle_in_histogram;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        int actual = solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        assertThat(actual).isEqualTo(10);
    }

    @Test
    public void test0_9() {
        int actual = solution.largestRectangleArea(new int[]{0, 9});
        assertThat(actual).isEqualTo(9);
    }

    @Test
    public void test9_0() {
        int actual = solution.largestRectangleArea(new int[]{9, 0});
        assertThat(actual).isEqualTo(9);
    }

    @Test
    public void test23() {
        int actual = solution.largestRectangleArea(new int[]{1, 1});
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test42() {
        int actual = solution.largestRectangleArea(new int[]{2,1,2});
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test86() {
        int actual = solution.largestRectangleArea(new int[]{4,7,6,8,5,9,1,26});
        assertThat(actual).isEqualTo(26);
    }
}