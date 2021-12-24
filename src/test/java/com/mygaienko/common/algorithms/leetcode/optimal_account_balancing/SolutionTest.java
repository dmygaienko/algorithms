package com.mygaienko.common.algorithms.leetcode.optimal_account_balancing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    SolutionV2 solution = new SolutionV2();

    @Test
    public void test0() {
        int actual = solution.minTransfers(new int[][]{{0, 1, 10}, {2, 0, 5}});
        assertEquals(2, actual);
    }

    @Test
    public void test01() {
        int actual = solution.minTransfers(new int[][]{{0, 1, 10}, {1, 0, 10}});
        assertEquals(0, actual);
    }

    @Test
    public void test1() {
        int actual = solution.minTransfers(new int[][]{{1000, 1001, 10}, {1001, 1000, 1}, {1001, 1002, 5}, {1002, 1000, 5}});
        assertEquals(1, actual);
    }

    @Test
    public void test2() {
        int actual = solution.minTransfers(new int[][]{
                {1000, 1001, 10},
                {1001, 1000, 1},
                {1001, 1002, 5},
                {1002, 1000, 5},
                {1003, 1000, 6},
                {1004, 1000, 7},
                {1005, 1004, 2},
                {1006, 1003, 3},
                {1006, 1002, 4},
        });
        assertEquals(1, actual);
    }

}