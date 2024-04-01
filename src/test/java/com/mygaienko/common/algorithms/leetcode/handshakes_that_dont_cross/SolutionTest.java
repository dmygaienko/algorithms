package com.mygaienko.common.algorithms.leetcode.handshakes_that_dont_cross;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        var actual = solution.numberOfWays(2);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test1() {
        var actual = solution.numberOfWays(4);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test2() {
        var actual = solution.numberOfWays(6);
        assertThat(actual).isEqualTo(5);
    }
}