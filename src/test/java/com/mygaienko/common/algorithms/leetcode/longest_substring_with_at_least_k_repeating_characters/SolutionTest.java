package com.mygaienko.common.algorithms.leetcode.longest_substring_with_at_least_k_repeating_characters;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void test1() {
        Solution solution = new Solution();
        int actual = solution.longestSubstring("aaabb", 3);
        assertThat(actual).isEqualTo(3);
    }
    @Test
    public void test2() {
        Solution solution = new Solution();
        int actual = solution.longestSubstring("ababbc", 2);
        assertThat(actual).isEqualTo(5);
    }

    @Test
    public void test6() {
        Solution solution = new Solution();
        int actual = solution.longestSubstring("weitong", 2);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void test28() {
        Solution solution = new Solution();
        int actual = solution.longestSubstring("bbaaacbd", 3);
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test32() {
        Solution solution = new Solution();
        int actual = solution.longestSubstring("aaaaaaaaabbbcccccddddd", 5);
        assertThat(actual).isEqualTo(10);
    }

}