package com.mygaienko.common.algorithms.leetcode.course_schedule;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        assertTrue(solution.canFinish(2, new int[][]{{1, 0}}));
    }

    @Test
    public void test1() {
        assertFalse(solution.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }

    @Test
    public void test2() {
        assertTrue(solution.canFinish(1, new int[][]{}));
    }

    @Test
    public void test3() {
        assertTrue(solution.canFinish(5, new int[][]{
                {1,4},
                {2,4},
                {3,1},
                {3,2}
        }));
    }
}