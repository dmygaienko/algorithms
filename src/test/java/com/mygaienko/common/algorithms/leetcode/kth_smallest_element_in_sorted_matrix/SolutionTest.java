package com.mygaienko.common.algorithms.leetcode.kth_smallest_element_in_sorted_matrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    /**
     * [[1,5,9],[10,11,13],[12,13,15]], k = 8
     */
    @Test
    public void test0() {
        assertEquals(13, solution.kthSmallest(new int[][] {{1,5,9}, {10,11,13}, {12,13,15}}, 8));
    }

    /**
     * [[1,2,3,4,5,6,7],[2,3,4,5,6,7,8],[3,4,5,6,7,8,9],[4,5,6,7,8,9,10],[5,6,7,8,9,10,11],[6,7,8,9,10,11,12],[7,8,9,10,11,12,13]]
     * 3
     */
    @Test
    public void test1() {
        assertEquals(2, solution.kthSmallest(new int[][] {
                {1,2,3,4,5,6,7},
                {2,3,4,5,6,7,8},
                {3,4,5,6,7,8,9},
                {4,5,6,7,8,9,10},
                {5,6,7,8,9,10,11},
                {6,7,8,9,10,11,12},
                {7,8,9,10,11,12,13}
                }, 2));
    }
}