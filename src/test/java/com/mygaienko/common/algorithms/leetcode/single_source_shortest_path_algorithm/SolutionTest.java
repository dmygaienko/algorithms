package com.mygaienko.common.algorithms.leetcode.single_source_shortest_path_algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    
    Solution solution = new Solution();

    @Test
    public void test0() {
        assertEquals(2, solution.minimumEffortPath(new int[][] {
                {1,2,2},{3,8,2},{5,3,5}
        }));
    }

    @Test
    public void test1() {
        assertEquals(1, solution.minimumEffortPath(new int[][] {
                {1,2,3},{3,8,4},{5,3,5}
        }));
    }

    @Test
    public void test2() {
        assertEquals(0, solution.minimumEffortPath(new int[][] {
                {1,2,1,1,1},
                {1,2,1,2,1},
                {1,2,1,2,1},
                {1,2,1,2,1},
                {1,1,1,2,1}
        }));
    }

    @Test
    public void test3() {
        assertEquals(0, solution.minimumEffortPath(new int[][] {
                {3}
        }));
    }

    @Test
    public void test4() {
        assertEquals(9, solution.minimumEffortPath(new int[][] {
                {1,10,6,7,9,10,4,9}
        }));
    }
}