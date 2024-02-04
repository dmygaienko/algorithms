package com.mygaienko.common.algorithms.leetcode.put_boxes_into_the_warehouse_i;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    SolutionV2 solution = new SolutionV2();

    @Test
    public void test() {
        var actual = solution.maxBoxesInWarehouse(new int[]{4, 3, 4, 1}, new int[]{5, 3, 3, 4, 1});
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test2() {
        var actual = solution.maxBoxesInWarehouse(new int[]{1, 2, 2, 3, 4}, new int[]{3, 4, 1, 2});
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test3() {
        var actual = solution.maxBoxesInWarehouse(new int[]{1, 2, 3}, new int[]{1, 2, 3, 4});
        assertThat(actual).isEqualTo(1);
    }
}