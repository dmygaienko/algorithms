package com.mygaienko.common.algorithms.leetcode.array_and_strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        assertEquals("56088", solution.multiply("123", "456"));
    }

    @Test
    public void test168() {
        assertEquals("168", solution.multiply("12", "14"));
    }

    @Test
    public void test625() {
        assertEquals("625", solution.multiply("25", "25"));
    }

    @Test
    public void test361() {
        assertEquals("361", solution.multiply("19", "19"));
    }

    @Test
    public void test9133_0() {
        assertEquals("0", solution.multiply("9133", "0"));
    }
    @Test
    public void test123456789_987654321() {
        assertEquals("121932631112635269", solution.multiply("123456789", "987654321"));
    }

}