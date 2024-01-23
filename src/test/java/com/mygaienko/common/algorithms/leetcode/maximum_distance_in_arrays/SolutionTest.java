package com.mygaienko.common.algorithms.leetcode.maximum_distance_in_arrays;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.maxDistance(List.of(
                List.of(1, 4, 5),
                List.of(0, 2)
        ));
        assertThat(actual).isEqualTo(5);
    }

    @Test
    public void test1() {
        var actual = solution.maxDistance(List.of(
                List.of(-3, -2),
                List.of(-2, -2, -2)
        ));
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test2() {
        var actual = solution.maxDistance(List.of(
                List.of(1, 4),
                List.of(0, 5)
        ));
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test5() {
        var actual = solution.maxDistance(List.of(
                List.of(-8, -7, -7, -5, 1, 1, 3, 4),
                List.of(-2),
                List.of(-10, -10, -7, 0, 1, 3),
                List.of(2)
        ));
        assertThat(actual).isEqualTo(14);
    }

    @Test
    public void test83() {
        var actual = solution.maxDistance(List.of(
                List.of(-1, 1),
                List.of(-3, 1, 4),
                List.of(-2, -1, 0, 2)
        ));
        assertThat(actual).isEqualTo(6);
    }

    @Test
    public void test104() {
        var actual = solution.maxDistance(List.of(
                List.of(-10, -9, -9, -9, -7, -2, -1, 2, 4),
                List.of(-9, -7, -6, -6, -3, 0, 1, 3),
                List.of(-10, -9, -2, -1, 1, 3)
        ));
        assertThat(actual).isEqualTo(14);
    }
}