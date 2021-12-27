package com.mygaienko.common.algorithms.leetcode.kill_process;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        List<Integer> actual = solution.killProcess(List.of(1, 3, 10, 5), List.of(3, 0, 5, 3), 5);
        assertEquals(List.of(5, 10), actual);
    }

}