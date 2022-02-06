package com.mygaienko.common.algorithms.leetcode.rotting_oranges;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        assertEquals(4, solution.orangesRotting(new int[][] {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        }));
    }

    @Test
    public void test1() {
        assertEquals(-1, solution.orangesRotting(new int[][] {
                {2,1,1},
                {0,1,1},
                {1,0,1}
        }));
    }

    @Test
    public void test2() {
        assertEquals(0, solution.orangesRotting(new int[][] {
                {0,2}
        }));
    }

    @Test
    public void test3() {
        assertEquals(1, solution.orangesRotting(new int[][] {
                {1,2}
        }));
    }
}