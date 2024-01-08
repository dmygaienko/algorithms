package com.mygaienko.common.algorithms.leetcode.combination_sum_ii;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        assertThat(actual).isEqualTo(List.of(
                List.of(1, 2, 2),
                List.of(5)
        ));
    }

}