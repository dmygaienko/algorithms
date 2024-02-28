package com.mygaienko.common.algorithms.leetcode.cheapest_flights_within_k_stops;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    SolutionV2 solution = new SolutionV2();

    @Test
    public void test() {
        var actual = solution.findCheapestPrice(4,
                new int[][]{
                        {0, 1, 100},
                        {1, 2, 100},
                        {2, 0, 100},
                        {1, 3, 600},
                        {2, 3, 200}
                },
                0, 3, 1);

        assertThat(actual).isEqualTo(700);
    }

    @Test
    public void test4() {
        var actual = solution.findCheapestPrice(5,
                new int[][]{
                        {4, 1, 1},
                        {1, 2, 3},
                        {0, 3, 2},
                        {0, 4, 10},
                        {2, 3, 200},
                        {1, 4, 3}
                },
                2, 1, 1);

        assertThat(actual).isEqualTo(-1);
    }

    @Test
    public void test5() {
        var actual = solution.findCheapestPrice(2,
                new int[][]{
                        {1, 0, 5}
                },
                0, 1, 1);

        assertThat(actual).isEqualTo(-1);
    }

    @Test
    public void test6() {
        var actual = solution.findCheapestPrice(3,
                new int[][]{
                        {0, 1, 2},
                        {1, 2, 1},
                        {2, 0, 10}
                },
                1, 2, 1);

        assertThat(actual).isEqualTo(1);
    }
}