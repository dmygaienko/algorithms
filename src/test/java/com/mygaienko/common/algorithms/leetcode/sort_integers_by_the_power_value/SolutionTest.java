package com.mygaienko.common.algorithms.leetcode.sort_integers_by_the_power_value;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.getKth(12, 15, 2);
        assertThat(actual).isEqualTo(13);
    }

    @Test
    public void test2() {
        int actual = solution.getKth(7, 11, 4);
        assertThat(actual).isEqualTo(7);
    }

    @Test
    public void test3() {
        int actual = solution.getKth(2, 61, 41);
        assertThat(actual).isEqualTo(18);
    }
}