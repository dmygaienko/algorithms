package com.mygaienko.common.algorithms.leetcode.longest_non_decreasing_subarray_from_two_arrays;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.maxNonDecreasingLength(new int[]{2,3,1}, new int[]{1,2,1});
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test2() {
        var actual = solution.maxNonDecreasingLength(new int[]{1, 3, 2, 1}, new int[]{2, 2, 3, 4});
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test3() {
        var actual = solution.maxNonDecreasingLength(new int[]{1, 1}, new int[]{2, 2});
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test1252() {
        var actual = solution.maxNonDecreasingLength(new int[]{4, 16, 10, 8}, new int[]{8, 4, 1, 9});
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test1293() {
        var actual = solution.maxNonDecreasingLength(new int[]{8, 7, 4}, new int[]{13, 4, 4});
        assertThat(actual).isEqualTo(2);
    }
}