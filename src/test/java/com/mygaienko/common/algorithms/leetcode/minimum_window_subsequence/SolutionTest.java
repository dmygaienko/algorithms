package com.mygaienko.common.algorithms.leetcode.minimum_window_subsequence;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        String actual = solution.minWindow("abcdebdde", "bde");
        assertEquals("bcde", actual);
    }

    @Test
    public void test2() {
        String actual = solution.minWindow("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "u");
        assertEquals("", actual);
    }

    @Test
    public void test3() {
        String actual = solution.minWindow("cnhczmccqouqadqtmjjzl", "cm");
        assertEquals("czm", actual);
    }

}