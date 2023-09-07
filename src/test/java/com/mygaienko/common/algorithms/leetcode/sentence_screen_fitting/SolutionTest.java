package com.mygaienko.common.algorithms.leetcode.sentence_screen_fitting;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.wordsTyping(new String[]{"i","had","apple","pie"}, 4, 5);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test1() {
        int actual = solution.wordsTyping(new String[]{"f", "p", "a"}, 8, 7);
        assertThat(actual).isEqualTo(10);
    }

    @Test
    public void test11() {
        int actual = solution.wordsTyping(new String[]{"f", "p", "a"}, 4, 7);
        assertThat(actual).isEqualTo(5);
    }

    @Test
    public void test30() {
        int actual = solution.wordsTyping(new String[]{"a"}, 20000, 20000);
        assertThat(actual).isEqualTo(200000000);
    }
}