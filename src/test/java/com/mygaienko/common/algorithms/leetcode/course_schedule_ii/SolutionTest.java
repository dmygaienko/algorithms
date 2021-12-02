package com.mygaienko.common.algorithms.leetcode.course_schedule_ii;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void findOrder1() {
        int[] actual = solution.findOrder(2, new int[][]{{1, 0}});
        assertArrayEquals( new int[]{0, 1}, actual);
    }

    /**
     * [[1,0],[2,0],[3,1],[3,2]]
     */
    @Test
    public void findOrder2() {
        int[] actual = solution.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        assertArrayEquals( new int[]{0, 1, 2, 3}, actual);
    }

    @Test
    public void findOrder3() {
        int[] actual = solution.findOrder(1, new int[][]{});
        assertArrayEquals( new int[]{0}, actual);
    }

    @Test
    public void findOrder4() {
        int[] actual = solution.findOrder(2, new int[][]{{0, 1}, {1, 0}});
        assertArrayEquals( new int[]{}, actual);
    }

}