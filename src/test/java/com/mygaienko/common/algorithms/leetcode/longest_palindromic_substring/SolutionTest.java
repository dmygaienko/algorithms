package com.mygaienko.common.algorithms.leetcode.longest_palindromic_substring;

import org.junit.Test;

import static org.junit.Assert.*;



public class SolutionTest {

    @Test
    public void testLongestPalindromeAc() {
        String palindrome = new Solution().longestPalindrome("ac");
        assertEquals("a", palindrome);
    }

    @Test
    public void testLongestPalindromeAa() {
        String palindrome = new Solution().longestPalindrome("aa");
        assertEquals("aa", palindrome);
    }

    @Test
    public void testLongestPalindromeBabad() {
        String palindrome = new Solution().longestPalindrome("bab");
        assertEquals("bab", palindrome);
    }

    @Test
    public void testLongestPalindromeVabad() {
        String palindrome = new Solution().longestPalindrome("babad");
        assertEquals("bab", palindrome);
    }

    @Test
    public void testLongestPalindromeDcbaabcde() {
        String palindrome = new Solution().longestPalindrome("dcbaabcde");
        assertEquals("dcbaabcd", palindrome);
    }

    @Test
    public void testLongestPalindromeCbbd() {
        String palindrome = new Solution().longestPalindrome("cbbd");
        assertEquals("bb", palindrome);
    }

    @Test
    public void testLongestPalindromeAbcba() {
        String palindrome = new Solution().longestPalindrome("abcba");
        assertEquals("abcba", palindrome);
    }

    @Test
    public void testLongestPalindromeXaabacxcabaaxcabaax() {
        String palindrome = new Solution().longestPalindrome("xaabacxcabaaxcabaax");
        assertEquals("xaabacxcabaax", palindrome);
    }

    @Test
    public void testLongestPalindromeZeusnilemacaronimaisanitratetartinasiaminoracamelinsuez() {
        String palindrome = new Solution().longestPalindrome("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez");
        assertEquals("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez", palindrome);
    }

}