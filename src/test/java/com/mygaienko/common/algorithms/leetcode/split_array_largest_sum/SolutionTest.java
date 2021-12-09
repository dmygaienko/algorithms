package com.mygaienko.common.algorithms.leetcode.split_array_largest_sum;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        int actual = solution.splitArray(new int[]{7, 2, 5, 10, 8}, 2);
        assertEquals(18, actual);
    }

    @Test
    public void test2() {
        int actual = solution.splitArray(new int[]{1, 4, 4}, 3);
        assertEquals(4, actual);
    }

    @Test
    public void test3() {
        int actual = solution.splitArray(new int[]{7, 2, 5, 10, 8, 3, 13, 11, 8, 7, 6, 5, 12, 19}, 4);
        assertEquals(32, actual);
    }

}