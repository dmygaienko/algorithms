package com.mygaienko.common.algorithms.leetcode.minimum_deletions_to_make_character_frequencies_unique;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.minDeletions("aaabbbcc");
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test73() {
        var actual = solution.minDeletions("abcabc");
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test74() {
        var actual = solution.minDeletions("fblkeacljlekiiddgbdibbhfafgmigghfiejilnjbclejlcabgkocbbbhnalmikjojildlfhjdgbgdhooiddbniedaabmk");
        assertThat(actual).isEqualTo(27);
    }

}