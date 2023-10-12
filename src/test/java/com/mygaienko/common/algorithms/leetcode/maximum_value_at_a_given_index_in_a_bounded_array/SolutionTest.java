package com.mygaienko.common.algorithms.leetcode.maximum_value_at_a_given_index_in_a_bounded_array;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        var actual = solution.maxValue(4, 2, 6);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test1() {
        var actual = solution.maxValue(6, 1, 10);
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test12() {
        var actual = solution.maxValue(3, 2, 18);
        assertThat(actual).isEqualTo(7);
    }

    @Test
    public void test66() {
        var actual = solution.maxValue(4, 0, 4);
        assertThat(actual).isEqualTo(1);
    }
}