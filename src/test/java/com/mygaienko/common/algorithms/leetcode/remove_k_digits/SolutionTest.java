package com.mygaienko.common.algorithms.leetcode.remove_k_digits;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        String s = solution.removeKdigits("1432219", 3);
        assertThat(s).isEqualTo("1219");
    }

    @Test
    public void test2() {
        String s = solution.removeKdigits("10200", 1);
        assertThat(s).isEqualTo("200");
    }

    @Test
    public void test3() {
        String s = solution.removeKdigits("10", 2);
        assertThat(s).isEqualTo("0");
    }

    @Test
    public void test4() {
        String s = solution.removeKdigits("9", 1);
        assertThat(s).isEqualTo("0");
    }

    @Test
    public void test29() {
        String s = solution.removeKdigits("112", 1);
        assertThat(s).isEqualTo("11");
    }

    @Test
    public void test34() {
        String s = solution.removeKdigits("10", 1);
        assertThat(s).isEqualTo("0");
    }

    @Test
    public void test345() {
        String s = solution.removeKdigits("110", 1);
        assertThat(s).isEqualTo("10");
    }

    @Test
    public void test38() {
        String s = solution.removeKdigits("10001", 4);
        assertThat(s).isEqualTo("0");
    }

    @Test
    public void test39() {
        String s = solution.removeKdigits("9999999999991", 8);
        assertThat(s).isEqualTo("99991");
    }

}