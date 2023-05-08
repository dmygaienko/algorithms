package com.mygaienko.common.algorithms.leetcode.evaluate_reverse_polish_notation;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test() {
        int val = solution.evalRPN(new String[]{"2", "1", "+", "3", "*"});
        assertThat(val).isEqualTo(9);
    }

    @Test
    public void test1() {
        int val = solution.evalRPN(new String[]{"4","13","5","/","+"});
        assertThat(val).isEqualTo(6);
    }

    @Test
    public void test2() {
        int val = solution.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
        assertThat(val).isEqualTo(9);
    }

}