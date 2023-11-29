package com.mygaienko.common.algorithms.leetcode.maximum_earnings_from_taxi;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        var actual = solution.maxTaxiEarnings(6, new int[][]
                {{2, 5, 4}, {1, 5, 1}});
        assertThat(actual).isEqualTo(7);
    }

    @Test
    public void test() {
        var actual = solution.maxTaxiEarnings(6, new int[][]
                {{1, 6, 1}, {3, 10, 2}, {10, 12, 3}, {11, 12, 2}, {12, 15, 2}, {13, 18, 1}});
        assertThat(actual).isEqualTo(20);
    }

}