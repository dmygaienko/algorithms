package com.mygaienko.common.algorithms.leetcode.min_cost_climbing_stairs;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        assertEquals(15, solution.minCostClimbingStairs(new int[] {10, 15, 20}));
    }

    @Test
    public void test2() {
        assertEquals(6, solution.minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1}));
    }

}