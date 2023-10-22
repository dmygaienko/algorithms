package com.mygaienko.common.algorithms.leetcode.integer_break;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test2() {
        var actual = solution.integerBreak(2);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test26() {
        var actual = solution.integerBreak(26);
        assertThat(actual).isEqualTo(13122);
    }
}