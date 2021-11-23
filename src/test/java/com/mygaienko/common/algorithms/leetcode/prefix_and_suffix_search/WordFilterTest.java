package com.mygaienko.common.algorithms.leetcode.prefix_and_suffix_search;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordFilterTest {

    public static final String[] WORDS = {"cabaabaaaa", "ccbcababac", "bacaabccba", "bcbbcbacaa", "abcaccbcaa", "accabaccaa", "cabcbbbcca", "ababccabcb", "caccbbcbab", "bccbacbcba"};

    @Test
    public void testFilter() {
        WordFilter wordFilter = new WordFilter(new String[]{"apple"});
        int actual = wordFilter.f("a", "e");
        assertEquals(0, actual);
    }

    /**
     * ["WordFilter","f","f","f","f","f","f","f","f","f","f"]
     *
     * [[["cabaabaaaa","ccbcababac","bacaabccba","bcbbcbacaa","abcaccbcaa","accabaccaa","cabcbbbcca","ababccabcb","caccbbcbab","bccbacbcba"]],
     *
     * ["bccbacbcba","a"],["ab","abcaccbcaa"],["a","aa"],["cabaaba","abaaaa"],["cacc","accbbcbab"],["ccbcab","bac"],
     * ["bac","cba"],["ac","accabaccaa"],["bcbb","aa"],["ccbca","cbcababac"]]
     *
     * [null,9,4,5,0,8,1,2,5,3,1]
     */
    @Test
    public void testFilter1() {
        WordFilter wordFilter = new WordFilter(WORDS);
        int actual = wordFilter.f("bccbacbcba","a");
        assertEquals(9, actual);
    }

    @Test
    public void testFilter11() {
        WordFilter wordFilter = new WordFilter(WORDS);
        int actual = wordFilter.f("ab","abcaccbcaa");
        assertEquals(4, actual);
    }

    @Test
    public void testFilter12() {
        WordFilter wordFilter = new WordFilter(WORDS);
        int actual = wordFilter.f("a","aa");
        assertEquals(5, actual);
    }

    @Test
    public void testFilter13() {
        WordFilter wordFilter = new WordFilter(WORDS);
        int actual = wordFilter.f("cabaaba","abaaaa");
        assertEquals(0, actual);
    }

    @Test
    public void testFilter14() {
        WordFilter wordFilter = new WordFilter(WORDS);
        int actual = wordFilter.f("cacc","accbbcbab");
        assertEquals(8, actual);
    }

    @Test
    public void testFilter15() {
        WordFilter wordFilter = new WordFilter(WORDS);
        int actual = wordFilter.f("ccbcab","bac");
        assertEquals(1, actual);
    }

    @Test
    public void testFilter16() {
        WordFilter wordFilter = new WordFilter(WORDS);
        int actual = wordFilter.f("bac","cba");
        assertEquals(2, actual);
    }

    @Test
    public void testFilter17() {
        WordFilter wordFilter = new WordFilter(WORDS);
        int actual = wordFilter.f("ac","accabaccaa");
        assertEquals(5, actual);
    }

    @Test
    public void testFilter18() {
        WordFilter wordFilter = new WordFilter(WORDS);
        int actual = wordFilter.f("bcbb","aa");
        assertEquals(3, actual);
    }

    @Test
    public void testFilter19() {
        WordFilter wordFilter = new WordFilter(WORDS);
        int actual = wordFilter.f("ccbca","cbcababac");
        assertEquals(1, actual);
    }

    @Test
    public void testFilter20() {
        WordFilter wordFilter = new WordFilter(new String[]{"abbba", "abba"});
        int actual = wordFilter.f("ab","ba");
        assertEquals(1, actual);
    }

}