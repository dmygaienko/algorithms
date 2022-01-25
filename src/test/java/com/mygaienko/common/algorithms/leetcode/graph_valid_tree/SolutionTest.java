package com.mygaienko.common.algorithms.leetcode.graph_valid_tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        assertTrue(solution.validTree(5, new int[][] {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 4}
        }));
    }

    @Test
    public void test1() {
        assertFalse(solution.validTree(5, new int[][] {
                {0, 1},
                {1, 2},
                {2, 3},
                {1, 3},
                {1, 4}
        }));
    }

    @Test
    public void test2() {
        assertFalse(solution.validTree(4, new int[][] {
                {0, 1},
                {2, 3}
        }));
    }

}