package com.mygaienko.common.algorithms.leetcode.number_of_corner_rectangles;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.countCornerRectangles(new int[][]{
                {1, 0, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1}});
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test21() {
        var actual = solution.countCornerRectangles(new int[][]{
                {1, 1, 1},
                {1, 1, 1}});
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test2() {
        var actual = solution.countCornerRectangles(new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}});
        assertThat(actual).isEqualTo(9);
    }
}