package com.mygaienko.common.algorithms.leetcode.the_maze_ii;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.shortestDistance(
                new int[][]{
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0}},
                new int[]{0, 4},
                new int[]{4, 4}
        );
        assertThat(actual).isEqualTo(12);
    }
}