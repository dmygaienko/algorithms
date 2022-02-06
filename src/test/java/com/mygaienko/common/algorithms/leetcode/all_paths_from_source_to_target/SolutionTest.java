package com.mygaienko.common.algorithms.leetcode.all_paths_from_source_to_target;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        List<List<Integer>> actual = solution.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}});
        assertEquals(List.of(
                List.of(0, 1, 3),
                List.of(0, 2, 3)
        ), actual);
    }

    @Test
    public void test1() {
        List<List<Integer>> actual = solution.allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}});
        assertEquals(List.of(
                List.of(0, 4),
                List.of(0, 3, 4),
                List.of(0, 1, 3, 4),
                List.of(0, 1, 2, 3, 4),
                List.of(0, 1, 4)
        ), actual);
    }

}