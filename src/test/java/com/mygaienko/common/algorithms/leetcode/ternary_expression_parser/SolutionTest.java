package com.mygaienko.common.algorithms.leetcode.ternary_expression_parser;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        var actual = solution.parseTernary("T?2:3");
        assertThat(actual).isEqualTo("2");
    }

    @Test
    public void test01() {
        var actual = solution.parseTernary("F?2:3");
        assertThat(actual).isEqualTo("3");
    }

    @Test
    public void test2() {
        var actual = solution.parseTernary("F?1:T?4:5");
        assertThat(actual).isEqualTo("4");
    }

    @Test
    public void test5() {
        var actual = solution.parseTernary("F?4:F?F:5");
        assertThat(actual).isEqualTo("5");
    }

    @Test
    public void test6() {
        var actual = solution.parseTernary("F?T:F?T?1:2:F?3:4");
        assertThat(actual).isEqualTo("4");
    }

}