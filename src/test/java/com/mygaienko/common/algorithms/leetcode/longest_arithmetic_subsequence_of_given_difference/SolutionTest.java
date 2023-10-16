package com.mygaienko.common.algorithms.leetcode.longest_arithmetic_subsequence_of_given_difference;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        var actual = solution.longestSubsequence(new int[] {1,2,3,4}, 1);
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test1() {
        var actual = solution.longestSubsequence(new int[] {1,3,5,7}, 1);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test2() {
        var actual = solution.longestSubsequence(new int[] {1,5,7,8,5,3,4,2,1}, -2);
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test() {
        var actual = solution.longestSubsequence(new int[] {4,12,10,0,-2,7,-8,9,-9,-12,-12,8,8}, 0);
        assertThat(actual).isEqualTo(2);
    }
}