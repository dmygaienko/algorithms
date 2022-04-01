package com.mygaienko.common.algorithms.leetcode.trapping_rain_water;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test_6() {
        int actual = solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        assertEquals(6, actual);
    }

    @Test
    public void test_9() {
        int actual = solution.trap(new int[]{4,2,0,3,2,5});
        assertEquals(9, actual);
    }

    @Test
    public void test_1() {
        int actual = solution.trap(new int[]{4,2,3});
        assertEquals(1, actual);
    }

}