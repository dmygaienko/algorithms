package com.mygaienko.common.algorithms.leetcode.top_k_frequent_elements;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        int[] actual = solution.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2);
        assertArrayEquals(new int [] {-1, 2}, actual);
    }
}