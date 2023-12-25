package com.mygaienko.common.algorithms.leetcode.knight_probability_in_chessboard;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.knightProbability(3, 2, 0, 0);
        assertThat(actual).isEqualTo(0.0625d);
    }

    @Test
    public void test1() {
        var actual = solution.knightProbability(1, 0, 0, 0);
        assertThat(actual).isEqualTo(1.0d);
    }

    @Test
    public void test2() {
        var actual = solution.knightProbability(3, 3, 0, 0);
        assertThat(actual).isEqualTo(0.015625);
    }

    @Test
    public void test3() {
        var actual = solution.knightProbability(8, 30, 6, 4);
        assertThat(actual).isEqualTo(1.9052566298333648E-4);
    }
}