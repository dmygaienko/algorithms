package com.mygaienko.common.algorithms.leetcode.optimize_water_distribution_in_a_village;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.minCostToSupplyWater(3, new int[]{1, 2, 2}, new int[][]{{1, 2, 1}, {2, 3, 1}});
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test2() {
        var actual = solution.minCostToSupplyWater(
                5,
                new int[]{46012, 72474, 64965, 751, 33304},
                new int[][]{{2, 1, 6719}, {3, 2, 75312}, {5, 3, 44918}});
        assertThat(actual).isEqualTo(131704);
    }

    @Test
    public void test6() {
        var actual = solution.minCostToSupplyWater(
                6,
                new int[]{4625, 65696, 86292, 68291, 37147, 7880},
                new int[][]{{2, 1, 79394}, {3, 1, 45649}, {4, 1, 75810}, {5, 3, 22340}, {6, 1, 6222}});
        assertThat(actual).isEqualTo(204321);
    }

}