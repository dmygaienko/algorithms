package com.mygaienko.common.algorithms.leetcode.remove_duplicate_letters;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        String actual = solution.removeDuplicateLetters("bcabc");
        assertThat(actual).isEqualTo("abc");
    }

    @Test
    public void test2() {
        String actual = solution.removeDuplicateLetters("cbacdcbc");
        assertThat(actual).isEqualTo("acdb");
    }

    @Test
    public void test3() {
        String actual = solution.removeDuplicateLetters("bbcaac");
        assertThat(actual).isEqualTo("bac");
    }

    @Test
    public void test4() {
        String actual = solution.removeDuplicateLetters("edebbed");
        assertThat(actual).isEqualTo("bed");
    }
}