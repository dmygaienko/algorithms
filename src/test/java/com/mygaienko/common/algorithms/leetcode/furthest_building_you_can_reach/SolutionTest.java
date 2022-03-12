package com.mygaienko.common.algorithms.leetcode.furthest_building_you_can_reach;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    /**
     * [4,12,2,7,3,18,20,3,19]
     * 10
     * 2
     */
    @Test
    public void test0() {
        int actual = solution.furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2);
        assertEquals(7, actual);
    }

    /**
     * [14,3,19,3]
     * 17
     * 0
     */
    @Test
    public void test1() {
        int actual = solution.furthestBuilding(new int[]{14,3,19,3}, 17, 0);
        assertEquals(3, actual);
    }

}