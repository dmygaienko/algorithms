package com.mygaienko.common.algorithms.leetcode.longest_incr_path_in_matrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int[][] matrix = new int[][] {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        assertEquals(4, solution.longestIncreasingPath(matrix));
    }

    @Test
    public void test2() {
        int[][] matrix = new int[][] {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };
        assertEquals(4, solution.longestIncreasingPath(matrix));
    }

    @Test
    public void test3() {
        int[][] matrix = new int[][] {{1}};
        assertEquals(1, solution.longestIncreasingPath(matrix));
    }
}