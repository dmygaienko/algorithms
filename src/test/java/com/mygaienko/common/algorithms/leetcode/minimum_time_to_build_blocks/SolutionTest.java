package com.mygaienko.common.algorithms.leetcode.minimum_time_to_build_blocks;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.minBuildTime(new int[]{1}, 1);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test2() {
        int actual = solution.minBuildTime(new int[]{1, 2}, 5);
        assertThat(actual).isEqualTo(7);
    }

    @Test
    public void test3() {
        int actual = solution.minBuildTime(new int[]{1, 2, 3}, 1);
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test4() {
        int actual = solution.minBuildTime(new int[]{94961, 39414, 41263, 7809, 41473}, 90);
        assertThat(actual).isEqualTo(95051);
    }


}