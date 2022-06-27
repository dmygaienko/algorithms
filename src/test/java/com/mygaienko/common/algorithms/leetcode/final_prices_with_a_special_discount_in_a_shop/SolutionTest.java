package com.mygaienko.common.algorithms.leetcode.final_prices_with_a_special_discount_in_a_shop;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int[] actual = solution.finalPrices(new int[]{8, 4, 6, 2, 3});
        assertThat(actual).isEqualTo(new int[] {4,2,4,2,3});
    }

    /**
     * [10,1,1,6]
     */
    @Test
    public void test0() {
        int[] actual = solution.finalPrices(new int[]{10,1,1,6});
        assertThat(actual).isEqualTo(new int[] {9,0,1,6});
    }
}