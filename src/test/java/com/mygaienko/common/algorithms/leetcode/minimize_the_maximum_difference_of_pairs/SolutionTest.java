package com.mygaienko.common.algorithms.leetcode.minimize_the_maximum_difference_of_pairs;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.minimizeMax(new int[]{4, 0, 2, 1, 2, 5, 5, 3}, 3);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test12() {
        var actual = solution.minimizeMax(new int[]{4, 2, 1, 2}, 1);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void test2() {
        var actual = solution.minimizeMax(new int[]{3, 4, 2, 3, 2, 1, 2}, 3);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test3() {
        var actual = solution.minimizeMax(new int[]{4, 5, 4, 0, 4, 3, 2}, 3);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test4() {
        var actual = solution.minimizeMax(new int[]{0, 5, 3, 4}, 0);
        assertThat(actual).isEqualTo(0);
    }

    /**
     * 0    1    1   3
     */
    @Test
    public void test1117() {
        var actual = solution.minimizeMax(new int[]{2, 0}, 1);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test1352() {
        var actual = solution.minimizeMax(new int[]{1, 1, 0, 3}, 2);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test1353() {
        var actual = solution.minimizeMax(new int[]{3, 11, 4, 3, 5, 7, 4, 4, 5, 5}, 3);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void test1321() {
        var actual = solution.minimizeMax(new int[]{7, 7, 16, 7, 7, 2, 6, 5, 5, 0}, 3);
        assertThat(actual).isEqualTo(0);
    }

}