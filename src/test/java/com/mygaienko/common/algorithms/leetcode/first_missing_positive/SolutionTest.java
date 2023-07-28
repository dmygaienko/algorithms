package com.mygaienko.common.algorithms.leetcode.first_missing_positive;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int i = solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12});
        assertThat(i).isEqualTo(1);
    }
}