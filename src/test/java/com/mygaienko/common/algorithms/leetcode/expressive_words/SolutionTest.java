package com.mygaienko.common.algorithms.leetcode.expressive_words;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test_heeellooo() {
        int actual = solution.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"});
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test_zzzzzyyyyy() {
        int actual = solution.expressiveWords("zzzzzyyyyy", new String[]{"zzyy", "zy", "zyy"});
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test_dddiiiinnssssssoooo() {
        int actual = solution.expressiveWords("dddiiiinnssssssoooo",
                new String[]{"dinnssoo",
                        "ddinso",
                        "ddiinnso", "ddiinnssoo",
                        "ddiinso","dinsoo","ddiinsso","dinssoo","dinso"});
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test_heeellooo_heeelloooworld() {
        int actual = solution.expressiveWords("heeellooo", new String[]{"heeelloooworld"});
        assertThat(actual).isEqualTo(0);
    }

}