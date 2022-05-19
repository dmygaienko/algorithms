package com.mygaienko.common.algorithms.leetcode.find_minimum_in_rotated_sorted_array;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void test_231() {
        int actual = solution.findMin(new int[]{2,3,1});
        assertThat(actual).isEqualTo(1);
    }

    /**
     * [5,1,2,3,4]
     */
    @Test
    public void test_51234() {
        int actual = solution.findMin(new int[]{5,1,2,3,4});
        assertThat(actual).isEqualTo(1);
    }

}