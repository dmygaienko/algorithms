package com.mygaienko.common.algorithms.leetcode.word_pattern_ii;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        var actual = solution.wordPatternMatch("abab", "redblueredblue");
        assertThat(actual).isTrue();
    }

    @Test
    public void test() {
        var actual = solution.wordPatternMatch("ab", "aa");
        assertThat(actual).isFalse();
    }

}