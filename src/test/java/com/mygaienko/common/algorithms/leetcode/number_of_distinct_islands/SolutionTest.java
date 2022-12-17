package com.mygaienko.common.algorithms.leetcode.number_of_distinct_islands;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.numDistinctIslands(new int[][]{{1, 1}, {1, 0}});
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test1() {
        int actual = solution.numDistinctIslands(new int[][]{
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0}
        });
        assertThat(actual).isEqualTo(2);
    }

}