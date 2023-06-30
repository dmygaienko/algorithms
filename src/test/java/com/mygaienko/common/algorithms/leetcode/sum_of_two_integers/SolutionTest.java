package com.mygaienko.common.algorithms.leetcode.sum_of_two_integers;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test15__15() {
        assertThat(solution.getSum(15, -15)).isEqualTo(0);
    }

    @Test
    public void test2_4() {
        assertThat(solution.getSum(2, 4)).isEqualTo(6);
    }

    @Test
    public void test4_4() {
        assertThat(solution.getSum(4, 4)).isEqualTo(8);
    }

    @Test
    public void test444_222() {
        assertThat(solution.getSum(444, 222)).isEqualTo(666);
    }

    @Test
    public void test6_4() {
        assertThat(solution.getSum(6, 4)).isEqualTo(10);
    }

    @Test
    public void test600_400() {
        assertThat(solution.getSum(600, 400)).isEqualTo(1000);
    }

    @Test
    public void test_600__400() {
        assertThat(solution.getSum(-600, -400)).isEqualTo(-1000);
    }

    @Test
    public void test_600_400() {
        assertThat(solution.getSum(-600, 400)).isEqualTo(-200);
    }

    @Test
    public void test_1__1() {
        assertThat(solution.getSum(-1, -1)).isEqualTo(-2);
    }
}