package com.mygaienko.common.algorithms.leetcode.longest_common_subsequence;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        assertEquals(3, solution.longestCommonSubsequence("abcde", "ace"));
    }

    @Test
    public void test2() {
        assertEquals(3, solution.longestCommonSubsequence("abc", "abc"));
    }

    @Test
    public void test3() {
        assertEquals(1, solution.longestCommonSubsequence("bl", "yby"));
    }

    @Test
    public void test4() {
        assertEquals(1, solution.longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
    }
}