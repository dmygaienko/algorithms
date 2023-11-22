package com.mygaienko.common.algorithms.leetcode.maximum_length_of_pair_chain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    /**
     * -10,-8
     * -5,0
     * 1,7
     * 9,10
     */
    @Test
    public void test() {
        var actual = solution.findLongestChain(new int[][]{{-10, -8}, {8, 9}, {-5, 0}, {6, 10}, {-6, -4}, {1, 7}, {9, 10}, {-4, 7}});
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test51() {
        var actual = solution.findLongestChain(new int[][]{{-6, 9}, {1, 6}, {8, 10}, {-1, 4}, {-6, -2}, {-9, 8}, {-5, 3}, {0, 3}});
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test166() {
        var actual = solution.findLongestChain(new int[][]{{-3, 9}, {-5, 0}, {6, 7}, {2, 6}, {-9, -3}, {-5, -3}, {-7, 7}, {-2, 10}, {7, 8}, {-1, 10}});
        assertThat(actual).isEqualTo(3);
    }
}