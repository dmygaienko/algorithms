package com.mygaienko.common.algorithms.leetcode.minimum_cost_to_set_cooking_time;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.minCostSetTime(9, 100000, 1, 6039);
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test235() {
        int actual = solution.minCostSetTime(7, 220, 479, 6000);
        assertThat(actual).isEqualTo(2576);
    }

}