package com.mygaienko.common.algorithms.leetcode.number_of_islands_ii;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        List<Integer> expected = List.of(1, 1, 2, 3);
        List<Integer> actual = solution.numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}});
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        List<Integer> expected = List.of(1, 1, 2, 2);
        List<Integer> actual = solution.numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {1, 2}});
        assertEquals(expected, actual);
    }
}