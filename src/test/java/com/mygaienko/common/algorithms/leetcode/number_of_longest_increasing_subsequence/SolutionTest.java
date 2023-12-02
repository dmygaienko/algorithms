package com.mygaienko.common.algorithms.leetcode.number_of_longest_increasing_subsequence;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test1() {
        int actual = solution.findNumberOfLIS(new int[]{2, 2, 2, 2, 2});
        assertThat(actual).isEqualTo(5);
    }

    @Test
    public void test2() {
        int actual = solution.findNumberOfLIS(new int[]{1, 2, 3, 4, 100, 200, 5, 6, 7});
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test92() {
        int actual = solution.findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2});
        assertThat(actual).isEqualTo(3);
    }
}