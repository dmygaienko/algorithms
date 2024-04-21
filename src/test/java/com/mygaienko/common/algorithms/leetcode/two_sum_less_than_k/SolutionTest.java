package com.mygaienko.common.algorithms.leetcode.two_sum_less_than_k;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.twoSumLessThanK(new int[]{
                358, 898, 450, 732, 672, 672, 256, 542, 320, 573, 423,
                543, 591, 280, 399, 923, 920, 254, 135, 952, 115, 536,
                143, 896, 411, 722, 815, 635, 353, 486, 127, 146, 974,
                495, 229, 21, 733, 918, 314, 670, 671, 537, 533, 716,
                140, 599, 758, 777, 185, 549}, 1800);

        assertThat(actual).isEqualTo(1794);
    }
}