package com.mygaienko.common.algorithms.leetcode.distinct_subsequences_ii;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test0() {
        int actual = solution.distinctSubseqII("abc");
        assertEquals(7, actual);
    }

    @Test
    public void test1() {
        int actual = solution.distinctSubseqII("aba");
        assertEquals(6, actual);
    }

    @Test
    public void test2() {
        int actual = solution.distinctSubseqII("aaa");
        assertEquals(3, actual);
    }

    @Test
    public void test3() {
        int actual = solution.distinctSubseqII("pcrdhwdxmqdznbenhwjsenjhvulyve");
        assertEquals(836817663, actual);
    }

}