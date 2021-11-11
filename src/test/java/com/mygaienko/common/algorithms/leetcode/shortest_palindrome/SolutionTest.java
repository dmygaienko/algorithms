package com.mygaienko.common.algorithms.leetcode.shortest_palindrome;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    /**
     * dcbaabcdeedcbaabcd
     */
    @Test
    public void testShortestPalindromeAcbaabcde() {
        String palindrome = new Solution().shortestPalindrome("dcbaabcde");
        assertEquals("edcbaabcde", palindrome);
    }

    @Test
    public void testShortestPalindromeEdcbaabcde() {
        String palindrome = new Solution().shortestPalindrome("edcbaabcde");
        assertEquals("edcbaabcde", palindrome);
    }

    @Test
    public void testShortestPalindromeAacecaaa() {
        String palindrome = new Solution().shortestPalindrome("aacecaaa");
        assertEquals("aaacecaaa", palindrome);
    }

    @Test
    public void testShortestPalindromeAbcd() {
        String palindrome = new Solution().shortestPalindrome("abcd");
        assertEquals("dcbabcd", palindrome);
    }

    @Test
    public void testShortestPalindrome1123456789() {
        String palindrome = new Solution().shortestPalindrome("1123456789");
        assertEquals("987654321123456789", palindrome);
    }

    @Test
    public void testShortestPalindrome21123456789() {
        String palindrome = new Solution().shortestPalindrome("21123456789");
        assertEquals("987654321123456789", palindrome);
    }

    @Test
    public void testShortestPalindrome321123456789() {
        String palindrome = new Solution().shortestPalindrome("321123456789");
        assertEquals("987654321123456789", palindrome);
    }

    @Test
    public void testShortestPalindromeAabba() {
        String palindrome = new Solution().shortestPalindrome("aabba");
        assertEquals("abbaabba", palindrome);
    }

    @Test
    public void testIsPalindromeAbcd() {
        boolean isPalindrome = Solution.isPalindrome("abcd");
        assertFalse(isPalindrome);
    }

    @Test
    public void testIsPalindromeAbba() {
        boolean isPalindrome = Solution.isPalindrome("abba");
        assertTrue(isPalindrome);
    }

    @Test
    public void testIsPalindromeAbdba() {
        boolean isPalindrome = Solution.isPalindrome("abdba");
        assertTrue(isPalindrome);
    }

}