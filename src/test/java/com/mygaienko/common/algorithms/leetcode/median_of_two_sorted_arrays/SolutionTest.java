package com.mygaienko.common.algorithms.leetcode.median_of_two_sorted_arrays;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        double medianSortedArrays = solution.findMedianSortedArrays(new int[]{1, 3}, new int[] {2});
        assertThat(medianSortedArrays).isEqualTo(2.d);
    }

    @Test
    public void test1() {
        double medianSortedArrays = solution.findMedianSortedArrays(new int[]{1, 2}, new int[] {3, 4});
        assertThat(medianSortedArrays).isEqualTo(2.d);
    }

}