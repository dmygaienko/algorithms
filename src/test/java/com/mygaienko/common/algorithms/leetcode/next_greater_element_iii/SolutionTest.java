package com.mygaienko.common.algorithms.leetcode.next_greater_element_iii;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test12() {
        var actual = solution.nextGreaterElement(12);
        assertThat(actual).isEqualTo(21);
    }

    @Test
    public void test21() {
        var actual = solution.nextGreaterElement(21);
        assertThat(actual).isEqualTo(-1);
    }


    @Test
    public void test2147483486() {
        var actual = solution.nextGreaterElement(2147483486);
        assertThat(actual).isEqualTo(-1);
    }

    @Test
    public void test2147483476() {
        var actual = solution.nextGreaterElement(2147483476);
        assertThat(actual).isEqualTo(2147483647);
    }

    @Test
    public void test230241() {
        var actual = solution.nextGreaterElement(230241);
        assertThat(actual).isEqualTo(230412);
    }

    @Test
    public void testToDecimals1234609123() {
        var actual = solution.toDecimals(1234609123);
        assertThat(actual).isEqualTo(new Integer[]{3, 2, 1, 9, 0, 6, 4, 3, 2, 1});
    }

    @Test
    public void testToDecimals30() {
        var actual = solution.toDecimals(30);
        assertThat(actual).isEqualTo(new Integer[]{0, 3});
    }
}