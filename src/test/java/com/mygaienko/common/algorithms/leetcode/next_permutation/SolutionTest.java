package com.mygaienko.common.algorithms.leetcode.next_permutation;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int[] arr = new int[] {1,2,3,4,5};
        solution.nextPermutation(arr);
        assertArrayEquals(new int[] {1,2,3,5,4}, arr);
    }

    @Test
    public void test1() {
        int[] arr = new int[] {5,4,3,2,1};
        solution.nextPermutation(arr);
        assertArrayEquals(new int[] {1,2,3,4,5}, arr);
    }

}