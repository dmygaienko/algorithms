package com.mygaienko.common.algorithms.leetcode.number_of_matching_subsequences;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void testNumMatchingSubseq() {
        assertEquals(3, solution.numMatchingSubseq("abcde", new String[]{"a","bb","acd","ace"}));
    }

    @Test
    public void testIsSubseq1() {
        assertTrue(solution.isSubseq("a", "abcde"));
    }

    @Test
    public void testIsSubseq2() {
        assertFalse(solution.isSubseq("bb", "abcde"));
    }

    @Test
    public void testIsSubseq3() {
        assertTrue(solution.isSubseq("acd", "abcde"));
    }

    @Test
    public void testIsSubseq4() {
        assertTrue(solution.isSubseq("ace", "abcde"));
    }

}