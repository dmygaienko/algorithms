package com.mygaienko.common.algorithms.leetcode.find_peak_element;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test_2() {
        int actual = solution.findPeakElement(new int[]{1, 2, 3, 1});
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test_5() {
        int actual = solution.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});
        assertThat(actual).isEqualTo(5);
    }
}