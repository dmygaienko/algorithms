package com.mygaienko.common.algorithms.leetcode.bulls_and_cows;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void getHint() {
        String actual = solution.getHint("1807", "7810");
        assertEquals("1A3B", actual);
    }

    @Test
    public void getHint2() {
        String actual = solution.getHint("1123", "0111");
        assertEquals("1A1B", actual);
    }

    @Test
    public void getHint3() {
        String actual = solution.getHint("1122", "1222");
        assertEquals("3A0B", actual);
    }

}