package com.mygaienko.common.algorithms.leetcode.edit_distance;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.minDistance("horse", "ros");
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test1() {
        var actual = solution.minDistance("a", "ab");
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test903() {
        var actual = solution.minDistance("ab", "bc");
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test814() {
        var actual = solution.minDistance("sea", "eat");
        assertThat(actual).isEqualTo(2);
    }
}