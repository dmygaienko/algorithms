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
        assertThat(medianSortedArrays).isEqualTo(2.5d);
    }

    @Test
    public void test2() {
        double medianSortedArrays = solution.findMedianSortedArrays(new int[]{1, 3, 5, 7}, new int[] {0, 2, 4, 6});
        assertThat(medianSortedArrays).isEqualTo(3.5d);
    }

    @Test
    public void test3() {
        double medianSortedArrays = solution.findMedianSortedArrays(new int[]{}, new int[] {1});
        assertThat(medianSortedArrays).isEqualTo(1d);
    }

    /**
     * [0,0,0,0,0]
     * [-1,0,0,0,0,0,1]
     */
    @Test
    public void test4() {
        double medianSortedArrays = solution.findMedianSortedArrays(new int[]{0,0,0,0,0}, new int[] {-1,0,0,0,0,0,1});
        assertThat(medianSortedArrays).isEqualTo(0d);
    }

    @Test
    public void findMedian() {
        assertThat(solution.findMedian(new int[]{0, 1})).isEqualTo(0.5d);
        assertThat(solution.findMedian(new int[]{0, 1, 2, 3})).isEqualTo(1.5d);
        assertThat(solution.findMedian(new int[]{1, 3})).isEqualTo(2.0d);
        assertThat(solution.findMedian(new int[]{1, 2, 3})).isEqualTo(2.d);
        assertThat(solution.findMedian(new int[]{1, 2, 3, 4})).isEqualTo(2.5d);
    }

}