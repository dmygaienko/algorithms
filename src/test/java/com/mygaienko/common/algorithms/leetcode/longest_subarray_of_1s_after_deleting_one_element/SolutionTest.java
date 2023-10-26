package com.mygaienko.common.algorithms.leetcode.longest_subarray_of_1s_after_deleting_one_element;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1});
        assertThat(actual).isEqualTo(5);
    }

    @Test
    public void test1() {
        var actual = solution.longestSubarray(new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1});
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test2() {
        var actual = solution.longestSubarray(new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1});
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test3() {
        var actual = solution.longestSubarray(new int[]{1, 0, 0, 0, 0});
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test4() {
        var actual = solution.longestSubarray(new int[]{1, 0, 1, 0, 1, 0});
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test5() {
        var actual = solution.longestSubarray(new int[]{0, 1, 0, 1});
        assertThat(actual).isEqualTo(2);
    }

}