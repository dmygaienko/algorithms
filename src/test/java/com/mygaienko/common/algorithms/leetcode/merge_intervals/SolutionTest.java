package com.mygaienko.common.algorithms.leetcode.merge_intervals;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        int[][] actual = solution.merge(new int[][]{
                {0, 2}, {0, 4}, {3, 4}, {2, 5}
        });
        assertThat(actual).isEqualTo(new int[][]{{0, 5}});
    }

}