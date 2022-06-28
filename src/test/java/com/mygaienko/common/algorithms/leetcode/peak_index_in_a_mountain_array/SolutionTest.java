package com.mygaienko.common.algorithms.leetcode.peak_index_in_a_mountain_array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        assertThat(solution.peakIndexInMountainArray(new int[] {0,1,0})).isEqualTo(1);
    }

    @Test
    public void test1() {
        assertThat(solution.peakIndexInMountainArray(new int[] {24,69,100,99,79,78,67,36,26,19})).isEqualTo(2);
    }

    @Test
    public void test2() {
        assertThat(solution.peakIndexInMountainArray(new int[] {3,5,3,2,0})).isEqualTo(1);
    }


}