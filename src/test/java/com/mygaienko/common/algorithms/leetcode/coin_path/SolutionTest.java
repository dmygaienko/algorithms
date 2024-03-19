package com.mygaienko.common.algorithms.leetcode.coin_path;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        List<Integer> actual = solution.cheapestJump(new int[]{1, 2, 4, -1, 2}, 2);
        assertThat(actual).isEqualTo(List.of(1, 3, 5));
    }

    @Test
    public void test2() {
        List<Integer> actual = solution.cheapestJump(new int[]{1, 2, 4, -1, 2}, 1);
        assertThat(actual).isEmpty();
    }

    @Test
    public void test3() {
        List<Integer> actual = solution.cheapestJump(new int[]{0, 0, 0, 0, 0, 0}, 3);
        assertThat(actual).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void test4() {
        List<Integer> actual = solution.cheapestJump(
                new int[]{
                        74, 69, 8, 72, 41, 52, 74, 10, 53, 52,
                        23, 2, 89, 5, 9, 55, 76, 53, 70, 0,
                        89, 50, 33, 54, 67, 26, 62, 90, 36, 5,
                        37, -1, 52, 54, 37, 79, 71, 88, 97, 51,
                        36, 97, 20, 64, 85, 58, 6, 39, 71, 26,
                        30, 40, 76, 96, 80, 83, 14, 36, 41, 32,
                        57, 72, 88, 54, 57, 0, 75, 96, 87, 38,
                        21, 76, 88, 99, 17, 78, 56, 44, 0, 80,
                        77, 36, 85, 4, 68, 14, 6, -1, 1, 2}, 9);
        assertThat(actual).isEqualTo(List.of(1, 3, 12, 20, 26, 35, 43, 50, 57, 66, 75, 79, 84, 90));
    }

    @Test
    public void test8() {
        List<Integer> actual = solution.cheapestJump(
                new int[]{
                        0, -1, 0, 0, 0, 0}, 3);
        assertThat(actual).isEqualTo(List.of(1, 3, 4, 5, 6));
    }

    @Test
    public void test198() {
        List<Integer> actual = solution.cheapestJump(
                new int[]{
                        33, 90, 57, 39, 42, 45, 29, 90, 81, 87,
                        88, 37, 58, 97, 80, 2, 77, 64, 82, 41,
                        2, 33, 34, 95, 85, 77, 92, 3, 8, 15,
                        71, 84, 58, 65, 46, 48, 3, 74, 4, 83,
                        23, 12, 15, 77, 33, 65, 17, 86, 21, 62,
                        71, 55, 80, 63, 75, 55, 11, 34, -1, 64,
                        81, 18, 77, 82, 8, 12, 14, 6, 46, 39,
                        71, 14, 6, 46, 89, 37, 88, 70, 88, 33,
                        89, 92, 60, 0, 78, 10, 88, 99, 20}, 74);
        assertThat(actual).isEqualTo(List.of(1, 16, 84, 89));
    }
}