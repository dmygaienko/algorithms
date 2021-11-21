package com.mygaienko.common.algorithms.leetcode.split_a_string;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void testNumSplits() {
        assertEquals(0, solution.numSplits(""));
    }

}