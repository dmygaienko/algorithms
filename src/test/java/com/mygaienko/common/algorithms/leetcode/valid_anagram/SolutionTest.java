package com.mygaienko.common.algorithms.leetcode.valid_anagram;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        assertThat(solution.isAnagram("cat", "rat")).isFalse();
    }

    @Test
    public void test1() {
        assertThat(solution.isAnagram("aacc", "ccac")).isFalse();
    }

}