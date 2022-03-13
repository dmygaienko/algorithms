package com.mygaienko.common.algorithms.leetcode.longest_substring_without_repeating_characters;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void testlengthOfLongestSubstringDcbaabcde() {
        int length = new Solution().lengthOfLongestSubstring("dcbaabcde");
        assertEquals(5, length);
    }

    @Test
    public void testlengthOfLongestSubstring_abcabcbb() {
        int length = new Solution().lengthOfLongestSubstring("abcabcbb");
        assertEquals(3, length);
    }

    @Test
    public void testlengthOfLongestSubstring_bbbbb() {
        int length = new Solution().lengthOfLongestSubstring("bbbbb");
        assertEquals(1, length);
    }

    @Test
    public void testlengthOfLongestSubstring_pwwkew() {
        int length = new Solution().lengthOfLongestSubstring("pwwkew");
        assertEquals(3, length);
    }

    @Test
    public void testlengthOfLongestSubstring_whitespace() {
        int length = new Solution().lengthOfLongestSubstring(" ");
        assertEquals(1, length);
    }

    @Test
    public void test_abba() {
        int length = new Solution().lengthOfLongestSubstring("abba");
        assertEquals(2, length);
    }

}