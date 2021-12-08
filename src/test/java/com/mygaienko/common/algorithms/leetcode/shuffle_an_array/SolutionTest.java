package com.mygaienko.common.algorithms.leetcode.shuffle_an_array;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void test1() {
        int[] nums = new int[] {1,2,3};
        Solution solution = new Solution(nums);
        int[] resetted = solution.reset();
        int[] shuffle = solution.shuffle();
    }

    @Test
    public void test2() {
        int[] nums = new int[] {1,2,3,4,5,6,7,8,9,10,11,12};
        Solution solution = new Solution(nums);
        int[] resetted = solution.reset();
        int[] shuffle = solution.shuffle();
    }
}