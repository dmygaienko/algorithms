package com.mygaienko.common.algorithms.leetcode.android_unlock_patterns;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test_1_1() {
        assertThat(solution.numberOfPatterns(1, 1)).isEqualTo(9);
    }

    @Test
    public void test_1_2() {
        assertThat(solution.numberOfPatterns(1, 2)).isEqualTo(65);
    }

    @Test
    public void test_1_3() {
        assertThat(solution.numberOfPatterns(1, 3)).isEqualTo(385);
    }

    @Test
    public void test_2_2() {
        assertThat(solution.numberOfPatterns(2, 2)).isEqualTo(56);
    }

    @Test
    public void test_2_3() {
        assertThat(solution.numberOfPatterns(2, 3)).isEqualTo(376);
    }

    @Test
    public void test_3_3() {
        assertThat(solution.numberOfPatterns(3, 3)).isEqualTo(320);
    }

    @Test
    public void test_3_4() {
        assertThat(solution.numberOfPatterns(3, 4)).isEqualTo(1944);
    }

    @Test
    public void test_4_4() {
        assertThat(solution.numberOfPatterns(4, 4)).isEqualTo(1624);
    }

    @Test
    public void test_5_5() {
        assertThat(solution.numberOfPatterns(5, 5)).isEqualTo(7152);
    }

    @Test
    public void test_6_6() {
        assertThat(solution.numberOfPatterns(6, 6)).isEqualTo(26016);
    }

    @Test
    public void test_7_7() {
        assertThat(solution.numberOfPatterns(7, 7)).isEqualTo(72912);
    }

    @Test
    public void test_8_8() {
        assertThat(solution.numberOfPatterns(8, 8)).isEqualTo(140704);
    }

    @Test
    public void test_9_9() {
        assertThat(solution.numberOfPatterns(9, 9)).isEqualTo(140704);
    }

}