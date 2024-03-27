package com.mygaienko.common.algorithms.leetcode.maximum_number_of_ones;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.maximumNumberOfOnes(3, 3, 2, 1);
        assertThat(actual).isEqualTo(4);
    }
}