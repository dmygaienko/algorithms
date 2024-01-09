package com.mygaienko.common.algorithms.leetcode.palindrome_permutation_ii;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.generatePalindromes("aabbcc");
        assertThat(actual).containsOnly(
                "abccba", "acbbca", "baccab", "bcaacb", "cabbac", "cbaabc"
        );
    }
}