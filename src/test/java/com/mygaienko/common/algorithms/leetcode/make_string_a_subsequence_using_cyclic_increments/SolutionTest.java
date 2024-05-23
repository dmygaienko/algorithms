package com.mygaienko.common.algorithms.leetcode.make_string_a_subsequence_using_cyclic_increments;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test0() {
        var actual = solution.canMakeSubsequence("abc", "ad");
        assertThat(actual).isTrue();
    }

    @Test
    public void test1() {
        var actual = solution.canMakeSubsequence("wfrgr", "wfsg");
        assertThat(actual).isTrue();
    }
}