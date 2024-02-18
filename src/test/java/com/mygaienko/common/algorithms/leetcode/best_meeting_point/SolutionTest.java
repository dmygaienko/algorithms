package com.mygaienko.common.algorithms.leetcode.best_meeting_point;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.minTotalDistance(new int[][]{{1, 1}});
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test2() {
        var actual = solution.minTotalDistance(new int[][]{
                {0, 0, 1},
                {0, 0, 0},
                {1, 0, 0}
        });
        assertThat(actual).isEqualTo(4);
    }
}