package com.mygaienko.common.algorithms.leetcode.next_closest_time;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test_19_34() {
        String actual = solution.nextClosestTime("19:34");
        assertThat(actual).isEqualTo("19:39");
    }

    @Test
    public void test_23_59() {
        String actual = solution.nextClosestTime("23:59");
        assertThat(actual).isEqualTo("22:22");
    }
}