package com.mygaienko.common.algorithms.leetcode.one_edit_distance;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.isOneEditDistance("a", "ac");
        assertThat(actual).isTrue();
    }

    @Test
    public void test1() {
        var actual = solution.isOneEditDistance("teacher", "tache");
        assertThat(actual).isFalse();
    }
}