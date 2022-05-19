package com.mygaienko.common.algorithms.leetcode.plus_one;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        int[] actual = solution.plusOne(new int[]{1, 2, 3});
        assertThat(actual).isEqualTo(new int[] {1, 2, 4});
    }

}