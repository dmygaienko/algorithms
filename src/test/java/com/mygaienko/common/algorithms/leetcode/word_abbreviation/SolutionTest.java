package com.mygaienko.common.algorithms.leetcode.word_abbreviation;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.wordsAbbreviation(List.of("like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"));
        assertThat(actual).contains("l2e", "god", "internal", "me", "i6t", "interval", "inte4n", "f2e", "intr4n");
    }

    @Test
    public void test68() {
        var actual = solution.wordsAbbreviation(List.of("abcdefg", "abccefg", "abcckkg", "abccekg"));
        assertThat(actual).contains("abcd2g", "abccefg", "abcckkg", "abccekg");
    }
}