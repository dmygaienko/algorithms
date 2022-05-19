package com.mygaienko.common.algorithms.leetcode.cracking_the_safe;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test_1() {
        String s = solution.crackSafe(1, 2);
        assertThat(s).isEqualTo("10");
    }

    @Test
    public void test_2() {
        String s = solution.crackSafe(2, 2);
        assertThat(s).isEqualTo("00110");
    }

    @Test
    public void test_3() {
        String s = solution.crackSafe(3, 2);
        assertThat(s).isEqualTo("0011101000");
    }

    @Test
    public void test_3_1() {
        String s = solution.crackSafe(3, 1);
        assertThat(s).isEqualTo("000");
    }

    /**
     *
     * k ^ ( n -1 ) = nodes
     * each node has k edges
     */
    @Test
    public void test_4() {
        System.out.println(Math.pow(2, 4-1));
    }

}