package com.mygaienko.common.algorithms.leetcode.maximal_square;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        char[][] input = {{'0', '1'}, {'1', '0'}};
        int actual = solution.maximalSquare(input);
        assertEquals(1, actual);
    }

    @Test
    public void test2() {
        char[][] input = {{
                '1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        int actual = solution.maximalSquare(input);
        assertEquals(4, actual);
    }

    @Test
    public void test3() {
        char[][] input = {
                {'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'}};
        int actual = solution.maximalSquare(input);
        assertEquals(9, actual);
    }

}