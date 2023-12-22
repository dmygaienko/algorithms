package com.mygaienko.common.algorithms.leetcode.sliding_window_maximum;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        assertThat(actual).isEqualTo(new int[]{3, 3, 5, 5, 6, 7});
    }

    @Test
    public void test1() {
        var actual = solution.maxSlidingWindow(new int[]{1, -1}, 1);
        assertThat(actual).isEqualTo(new int[]{1, -1});
    }

    @Test
    public void test2() {
        var actual = solution.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
        assertThat(actual).isEqualTo(new int[]{3, 3, 2, 5});
    }

}