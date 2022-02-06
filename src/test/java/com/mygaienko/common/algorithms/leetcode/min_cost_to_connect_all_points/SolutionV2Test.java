package com.mygaienko.common.algorithms.leetcode.min_cost_to_connect_all_points;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionV2Test {
    
    SolutionV2 solution = new SolutionV2();

    @Test
    public void test0() {
        assertEquals(20, solution.minCostConnectPoints(new int[][] {{0,0},{2,2},{3,10},{5,2},{7,0}}));
    }

}