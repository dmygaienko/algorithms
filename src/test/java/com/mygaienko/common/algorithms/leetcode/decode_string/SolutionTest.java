package com.mygaienko.common.algorithms.leetcode.decode_string;


import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test0() {
        String actual = solution.decodeString("decodeString");
        assertEquals("decodeString", actual);
    }

    @Test
    public void test() {
        String actual = solution.decodeString("3[a]2[bc]");
        assertEquals("aaabcbc", actual);
    }

    @Test
    public void test2() {
        String actual = solution.decodeString("3[a2[c]]");
        assertEquals("accaccacc", actual);
    }

    @Test
    public void test3() {
        String actual = solution.decodeString("abc3[cd]xyz");
        assertEquals("abccdcdcdxyz", actual);
    }

}