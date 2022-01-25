package com.mygaienko.common.algorithms.leetcode.earliest_moment_everyone_become_friends;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        assertEquals(2, solution.earliestAcq(new int[][]{
            {9, 3, 0},
            {0, 2, 1},
            {8, 0, 1},
            {1, 3, 2},
            {2, 2, 0},
            {3, 3, 1}
        }, 4));
    }
}