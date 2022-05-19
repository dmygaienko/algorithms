package com.mygaienko.common.algorithms.leetcode.maximize_distance_to_closest_person;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test_01() {
        int actual = solution.maxDistToClosest(new int[]{0, 1});
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test_10() {
        int actual = solution.maxDistToClosest(new int[]{1, 0});
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test_1000() {
        int actual = solution.maxDistToClosest(new int[]{1, 0, 0, 0});
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test_1001() {
        int actual = solution.maxDistToClosest(new int[]{1, 0, 0, 1});
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test_1000101() {
        int actual = solution.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1});
        assertThat(actual).isEqualTo(2);
    }

}