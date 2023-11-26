package com.mygaienko.common.algorithms.leetcode.maximum_number_of_events_that_can_be_attended;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.maxEvents(new int[][]{
                {1, 2}, {2, 3}, {3, 4}
        });
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test2() {
        var actual = solution.maxEvents(new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {1, 2}
        });
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test13() {
        var actual = solution.maxEvents(new int[][]{
                {1, 2}, {2, 3}, {3, 3}, {1, 5}, {1, 5}
        });
        assertThat(actual).isEqualTo(5);
    }

    @Test
    public void test14() {
        var actual = solution.maxEvents(new int[][]{
                {1, 5}, {1, 5}, {1, 5}, {2, 3}, {2, 3}
        });
        assertThat(actual).isEqualTo(5);
    }

    @Test
    public void test16() {
        var actual = solution.maxEvents(new int[][]{
                {52, 79}, {7, 34}
        });
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test30() {
        var actual = solution.maxEvents(new int[][]{
                {1, 4}, {4, 4}, {2, 2}, {3, 4}, {1, 1}
        });
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test37() {
        var actual = solution.maxEvents(new int[][]{
                {1, 2}, {1, 2}, {1, 6}, {1, 2}, {1, 2}
        });
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test44() {
        var actual = solution.maxEvents(new int[][]{
                {1, 2}, {1, 2}, {1, 6}, {1, 2}, {1, 2}
        });
        assertThat(actual).isEqualTo(3);
    }
}