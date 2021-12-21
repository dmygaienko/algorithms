package com.mygaienko.common.algorithms.leetcode.minimum_knight_moves;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        int actual = solution.minKnightMoves(2, 1);
        assertEquals(1, actual);
    }

    @Test
    public void test1() {
        int actual = solution.minKnightMoves(4, 3);
        assertEquals(3, actual);
    }

    @Test
    public void test11() {
        int actual = solution.minKnightMoves(1, 1);
        assertEquals(2, actual);
    }

    @Test
    public void test2_122() {
        int actual = solution.minKnightMoves(2, 122);
        assertEquals(62, actual);
    }

}