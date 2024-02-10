package com.mygaienko.common.algorithms.leetcode.basic_calculator_iii;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        assertThat(solution.calculate("1+1")).isEqualTo(2);
    }

    @Test
    public void test1() {
        assertThat(solution.calculate("6-4/2")).isEqualTo(4);
    }

    @Test
    public void test21() {
        assertThat(solution.calculate("2*(5+5*2)")).isEqualTo(30);
    }

    @Test
    public void test22() {
        assertThat(solution.calculate("2*(5+5*2)/3")).isEqualTo(10);
    }

    @Test
    public void test23() {
        assertThat(solution.calculate("(6/2+8)")).isEqualTo(11);
    }

    @Test
    public void test2() {
        assertThat(solution.calculate("2*(5+5*2)/3+(6/2+8)")).isEqualTo(21);
    }

    @Test
    public void test3() {
        assertThat(solution.calculate("(5+5*2)")).isEqualTo(15);
    }

    @Test
    public void test4() {
        assertThat(solution.calculate("1*2-3/4+5*6-7*8+9/10")).isEqualTo(-24);
    }

    @Test
    public void test222() {
        assertThat(solution.calculate("2-1+2")).isEqualTo(3);
    }

    @Test
    public void test223() {
        assertThat(solution.calculate("(1-(3-4))")).isEqualTo(3);
    }
}