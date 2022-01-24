package com.mygaienko.common.algorithms.leetcode.number_of_provinces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        assertEquals(2, actual);
    }

    @Test
    public void test2() {
        int actual = solution.findCircleNum(new int[][]{
                {1,1,1,0,1,1,1,0,0,0},
                {1,1,0,0,0,0,0,1,0,0},
                {1,0,1,0,0,0,0,0,0,0},
                {0,0,0,1,1,0,0,0,1,0},
                {1,0,0,1,1,0,0,0,0,0},
                {1,0,0,0,0,1,0,0,0,0},
                {1,0,0,0,0,0,1,0,1,0},
                {0,1,0,0,0,0,0,1,0,1},
                {0,0,0,1,0,0,1,0,1,1},
                {0,0,0,0,0,0,0,1,1,1}});
        assertEquals(1, actual);
    }


}
