package com.mygaienko.common.algorithms.leetcode.number_of_wonderful_substrings;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.wonderfulSubstrings("aba");
        assertThat(actual).isEqualTo(4);
    }

}