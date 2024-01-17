package com.mygaienko.common.algorithms.leetcode.four_keys_keyboard;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test7() {
        var actual = solution.maxA(7);
        assertThat(actual).isEqualTo(9);
    }

    @Test
    public void test9() {
        var actual = solution.maxA(9);
        assertThat(actual).isEqualTo(16);
    }

}