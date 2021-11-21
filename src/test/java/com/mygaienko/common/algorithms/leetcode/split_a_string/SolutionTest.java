package com.mygaienko.common.algorithms.leetcode.split_a_string;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void testNumSplits() {
        assertEquals(2, solution.numSplits("aacaba"));
    }

    @Test
    public void testNumSplits2() {
        assertEquals(4, solution.numSplits("aaaaa"));
    }

    @Test
    public void testNumSplits3() {
        assertEquals(2, solution.numSplits("acbadbaada"));
    }

}