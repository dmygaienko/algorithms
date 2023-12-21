package com.mygaienko.common.algorithms.leetcode.path_with_maximum_minimum_value;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.maximumMinimumPath(new int[][]{
                {5, 4, 5},
                {1, 2, 6},
                {7, 4, 6}
        });

        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test4() {
        var actual = solution.maximumMinimumPath(new int[][]{
                {5, 4, 3, 1},
                {7, 4, 5, 2},
                {4, 9, 8, 2},
                {2, 3, 6, 6}
        });

        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test5() {
        var actual = solution.maximumMinimumPath(new int[][]{
                {0, 1, 0, 0, 0, 1},
                {0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 1},
                {0, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1}
        });

        assertThat(actual).isEqualTo(0);
    }
}