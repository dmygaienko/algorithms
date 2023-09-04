package com.mygaienko.common.algorithms.leetcode.strings_differ_by_one_character;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        assertThat(solution.differByOne(new String[]{"abcd", "acbd", "aacd"})).isTrue();
    }

    @Test
    public void test16() {
        assertThat(solution.differByOne(new String[] {"abcde","abaaa","aaade"})).isFalse();
    }

    @Test
    public void test17() {
        assertThat(solution.differByOne(new String[] {"abcde","addde","abbbe","xbcde","feabc"})).isTrue();
    }

    @Test
    public void test17_1() {
        assertThat(solution.differByOne(new String[] {"abcde","xbcde"})).isTrue();
    }

    @Test
    public void test58() {
        assertThat(solution.differByOne(new String[] {"abc","dfe","abf"})).isTrue();
    }

    @Test
    public void test72() {
        assertThat(solution.differByOne(new String[] {"aaaddb","aaaacd","aaacda","aaaaba","aaaccd"})).isTrue();
    }

    @Test
    public void test72_1() {
        assertThat(solution.differByOne(new String[] {"aaaacd","aaaccd"})).isTrue();
    }
}