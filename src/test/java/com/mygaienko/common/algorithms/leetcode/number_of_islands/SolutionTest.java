package com.mygaienko.common.algorithms.leetcode.number_of_islands;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    
    Solution solution = new Solution();

    @Test
    public void test() {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        assertEquals(1, solution.numIslands(grid));
    }
}