package com.mygaienko.common.algorithms.leetcode.max_area_of_island;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.maxAreaOfIsland(new int[][]{
                {1, 0, 1},
                {1, 1, 1},
                {0, 0, 1}
        });
        assertThat(actual).isEqualTo(6);
    }

    @Test
    public void test1() {
        var actual = solution.maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        });
        assertThat(actual).isEqualTo(6);
    }

    @Test
    public void test2() {
        var actual = solution.maxAreaOfIsland(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        });
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test3() {
        var actual = solution.maxAreaOfIsland(new int[][]{
                {1}
        });
        assertThat(actual).isEqualTo(1);
    }
}