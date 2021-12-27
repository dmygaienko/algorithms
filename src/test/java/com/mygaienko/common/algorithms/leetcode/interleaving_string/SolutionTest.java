package com.mygaienko.common.algorithms.leetcode.interleaving_string;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    SolutionV2 solution = new SolutionV2();

    @Test
    public void testAbcd() {
        assertTrue(solution.isInterleave("ac", "bd", "abcd"));
    }

    /**
     * "aabcc"
     * "dbbca"
     * "aadbbcbcac"
     */
    @Test
    public void test() {
        assertTrue(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}