package com.mygaienko.common.algorithms.leetcode.count_words_obtained_after_adding_a_letter;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    @Test
    public void test() {
        var solution = new Solution();
        int actual = solution.wordCount(
                new String[]{"ant", "act", "tack"},
                new String[]{"tack", "act", "acti"});
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test_1() {
        var solution = new Solution();
        int actual = solution.wordCount(
                new String[]{"ant"},
                new String[]{"act"});
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void test2() {
        var solution = new Solution();
        int actual = solution.wordCount(
                new String[]{"ab", "a"},
                new String[]{"abc", "abcd"});
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test17() {
        var solution = new Solution();
        int actual = solution.wordCount(
                new String[]{"uh"},
                new String[]{"u","hur","k","b","u","yse","giqoy","lni","olqb","nemc"});
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test17_1() {
        var solution = new Solution();
        int actual = solution.wordCount(
                new String[]{"uh"},
                new String[]{"hur"});
        assertThat(actual).isEqualTo(1);
    }

    /**
     *  a       -> da
     *  y       -> yt
     *  dmf     -> emdf
     *  zrl     -> lzkr
     *  ljxd    -> jdxlz
     */
    @Test
    public void test20() {
        var solution = new Solution();
        int actual = solution.wordCount(
                new String[]{"lhum","bim","cyjhm","h","a","ljxd","run","zrl","dmf","y"},
                new String[]{"da","lzkr","uzc","jdxlz","yt","emdf"}); //
        assertThat(actual).isEqualTo(5);
    }

    @Test
    public void test20_1() {
        var solution = new Solution();
        int actual = solution.wordCount(
                new String[]{"zrl"},
                new String[]{"lzkr"}); //
        assertThat(actual).isEqualTo(1);
    }

}