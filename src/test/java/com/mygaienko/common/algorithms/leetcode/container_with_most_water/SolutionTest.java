package com.mygaienko.common.algorithms.leetcode.container_with_most_water;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        int actual = solution.maxArea(new int[]{1, 2, 1});
        assertEquals(2, actual);
    }

}