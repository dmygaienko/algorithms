package com.mygaienko.common.algorithms.leetcode.basic_calculator_ii;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void testCalculate1() {
        int actual = solution.calculate("3+2*2");
        assertThat(actual).isEqualTo(7);
    }

    @Test
    public void testCalculate2() {
        int actual = solution.calculate(" 3/2 ");
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void testCalculate3() {
        int actual = solution.calculate(" 3+5 / 2 ");
        assertThat(actual).isEqualTo(5);
    }

}