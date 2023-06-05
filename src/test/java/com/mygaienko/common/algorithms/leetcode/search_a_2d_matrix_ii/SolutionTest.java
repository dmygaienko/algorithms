package com.mygaienko.common.algorithms.leetcode.search_a_2d_matrix_ii;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void test1() {
        Solution solution = new Solution();
        boolean actual = solution.searchMatrix(new int[][]{
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}},
                5);
        assertThat(actual).isTrue();
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        boolean actual = solution.searchMatrix(new int[][]{
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}},
                20);
        assertThat(actual).isFalse();
    }

    @Test
    public void test5() {
        Solution solution = new Solution();
        boolean actual = solution.searchMatrix(new int[][]{
                        {1, 1}},
                0);
        assertThat(actual).isFalse();
    }

    @Test
    public void test14() {
        Solution solution = new Solution();
        boolean actual = solution.searchMatrix(new int[][]{
                        {-1},
                        {-1}},
                -2);
        assertThat(actual).isFalse();
    }

    @Test
    public void test18() {
        Solution solution = new Solution();
        boolean actual = solution.searchMatrix(new int[][]{
                        {-5}},
                -5);
        assertThat(actual).isTrue();
    }

    @Test
    public void test19() {
        Solution solution = new Solution();
        boolean actual = solution.searchMatrix(new int[][]{
                        {-1, 3}},
                3);
        assertThat(actual).isTrue();
    }

    @Test
    public void test120() {
        Solution solution = new Solution();
        boolean actual = solution.searchMatrix(new int[][]{
                        {1, 2, 3, 4, 5}},
                2);
        assertThat(actual).isTrue();
    }

    @Test
    public void test121() {
        Solution solution = new Solution();
        boolean actual = solution.searchMatrix(new int[][]{
                        {1, 4},
                        {2, 5}},
                2);
        assertThat(actual).isTrue();
    }

    @Test
    public void test123() {
        Solution solution = new Solution();
        boolean actual = solution.searchMatrix(new int[][]{
                        {1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 10},
                        {11, 12, 13, 14, 15},
                        {16, 17, 18, 19, 20},
                        {21, 22, 23, 24, 25}},
                10);
        assertThat(actual).isTrue();
    }

    @Test
    public void test76() {
        Solution solution = new Solution();
        boolean actual = solution.searchMatrix(new int[][]{
                        {2, 3, 6, 6, 10},
                        {5, 9, 12, 17, 19},
                        {10, 14, 17, 20, 20},
                        {15, 17, 20, 24, 24},
                        {20, 20, 25, 26, 29}},
                10);
        assertThat(actual).isTrue();
    }

}