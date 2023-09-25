package com.mygaienko.common.algorithms.leetcode.can_i_win;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        boolean actual = solution.canIWin(10, 11);
        assertThat(actual).isFalse();
    }

    @Test
    public void test41() {
        boolean actual = solution.canIWin(10, 40);
        assertThat(actual).isFalse();
    }

    @Test
    public void test34() {
        boolean actual = solution.canIWin(4, 6);
        assertThat(actual).isTrue();
    }

    @Test
    public void test45() {
        boolean actual = solution.canIWin(18, 79);
        assertThat(actual).isTrue();
    }
}