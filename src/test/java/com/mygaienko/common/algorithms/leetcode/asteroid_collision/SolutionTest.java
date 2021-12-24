package com.mygaienko.common.algorithms.leetcode.asteroid_collision;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        int[] actual = solution.asteroidCollision(new int[]{5, 10, -5});
        assertArrayEquals(actual, new int[] {5, 10});
    }

    @Test
    public void test2() {
        int[] actual = solution.asteroidCollision(new int[]{8, -8});
        assertArrayEquals(actual, new int[] {});
    }

    @Test
    public void test3() {
        int[] actual = solution.asteroidCollision(new int[]{10, 2, -5});
        assertArrayEquals(actual, new int[] {10});
    }

    @Test
    public void test4() {
        int[] actual = solution.asteroidCollision(new int[]{1, -2, -2, -2});
        assertArrayEquals(actual, new int[] {-2, -2, -2});
    }

    @Test
    public void testMy() {
        int[] actual = solution.asteroidCollision(new int[] {10, 2, -5, 11, -3, 33, 35, -100, -6, 4, -3, 2, 12, 20, 22, -28, 24});
        assertArrayEquals(actual, new int[] {5, 10});
    }
}