package com.mygaienko.common.algorithms.leetcode.maximum_product_subarray;


import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.maxProduct(new int[]{2, 3, -2, 4});
        assertThat(actual).isEqualTo(6);
    }

    @Test
    public void test_2() {
        int actual = solution.maxProduct(new int[]{-2});
        assertThat(actual).isEqualTo(-2);
    }

    @Test
    public void test119() {
        int actual = solution.maxProduct(new int[]{-2,3,-4});
        assertThat(actual).isEqualTo(24);
    }

    @Test
    public void test144() {
        int actual = solution.maxProduct(new int[]{1,0,-1,2,3,-5,-2});
        assertThat(actual).isEqualTo(60);
    }
    @Test
    public void test147() {
        int actual = solution.maxProduct(new int[]{2,-5,-2,-4,3});
        assertThat(actual).isEqualTo(24);
    }

    @Test
    public void test168() {
        int actual = solution.maxProduct(new int[]{-1,-2,-9,-6});
        assertThat(actual).isEqualTo(108);
    }

    @Test
    public void test184() {
        int actual = solution.maxProduct(new int[]{-3,-1,3,5,-6,-6,-1,6,-3,-5,1,0,-6,-5,0,-2,6,1,0,5});
        assertThat(actual).isEqualTo(48600);
    }
}