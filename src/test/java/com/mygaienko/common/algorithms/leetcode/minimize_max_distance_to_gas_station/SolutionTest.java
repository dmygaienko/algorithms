package com.mygaienko.common.algorithms.leetcode.minimize_max_distance_to_gas_station;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.minmaxGasDist(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9);
        assertThat(actual).isEqualTo(0.5);
    }

    @Test
    public void test2() {
        var actual = solution.minmaxGasDist(new int[]{23, 24, 36, 39, 46, 56, 57, 65, 84, 98}, 1);
        assertThat(actual).isEqualTo(14);
    }

    @Test
    public void test3() {
        var actual = solution.minmaxGasDist(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 20);
        assertThat(actual).isEqualTo(0.33);
    }
}