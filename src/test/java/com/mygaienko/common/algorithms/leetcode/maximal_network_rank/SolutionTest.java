package com.mygaienko.common.algorithms.leetcode.maximal_network_rank;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.maximalNetworkRank(4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}});
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test81() {
        int actual = solution.maximalNetworkRank(4, new int[][]{{2, 3}, {0, 3}, {0, 4}, {4, 1}});
        assertThat(actual).isEqualTo(4);
    }
}