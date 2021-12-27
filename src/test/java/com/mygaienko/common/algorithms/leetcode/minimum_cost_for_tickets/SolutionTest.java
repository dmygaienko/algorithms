package com.mygaienko.common.algorithms.leetcode.minimum_cost_for_tickets;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        int actual = solution.mincostTickets(
                new int[]{1,4,6,7,8,20},
                new int[]{2, 7, 15}
        );
        assertEquals(11, actual);
    }

    @Test
    public void test2() {
        int actual = solution.mincostTickets(
                new int[]{1,2,3,4,5,6,7,8,9,10,30,31},
                new int[]{2, 7, 15}
        );
        assertEquals(17, actual);
    }

    @Test
    public void test3() {
        int actual = solution.mincostTickets(
                new int[]{1,4,6,7,8,20},
                new int[]{7, 2, 15}
        );
        assertEquals(6, actual);
    }

    /**
     * [1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28]
     * [3,13,45]
     */
    @Test
    public void test4() {
        int actual = solution.mincostTickets(
                new int[]{1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28},
                new int[]{3, 13, 45}
        );
        assertEquals(44, actual);
    }

    /**
     * [1,2,3,4,6,8,9,10,13,14,16,17,19,21,24,26,27,28,29]
     * [3,14,50]
     */
    @Test
    public void test5() {
        int actual = solution.mincostTickets(
                new int[]{1,2,3,4,6,8,9,10,13,14,16,17,19,21,24,26,27,28,29},
                new int[]{3, 14, 50}
        );
        assertEquals(50, actual);
    }


    /**
     * [6,8,9,18,20,21,23,25]
     * [2,10,41]
     */
    @Test
    public void test6() {
        int actual = solution.mincostTickets(
                new int[]{6,8,9,18,20,21,23,25},
                new int[]{2, 10, 41}
        );
        assertEquals(16, actual);
    }


    /**
     * [364]
     * [3,3,1]
     */
    @Test
    public void test7() {
        int actual = solution.mincostTickets(
                new int[]{364},
                new int[]{3, 3, 1}
        );
        assertEquals(1, actual);
    }

}