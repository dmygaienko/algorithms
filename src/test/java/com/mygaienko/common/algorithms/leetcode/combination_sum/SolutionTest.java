package com.mygaienko.common.algorithms.leetcode.combination_sum;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        assertThat(actual).containsOnly(
                List.of(2, 2, 3),
                List.of(7)
        );
    }

}