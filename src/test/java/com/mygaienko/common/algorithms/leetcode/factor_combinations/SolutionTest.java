package com.mygaienko.common.algorithms.leetcode.factor_combinations;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var factors = solution.getFactors(12);
        assertThat(factors).containsOnly(
                List.of(2, 2, 3),
                List.of(4, 3),
                List.of(2, 6)
        );
    }

    @Test
    public void test32() {
        var factors = solution.getFactors(32);
        assertThat(factors).containsOnly(
                List.of(2, 16),
                List.of(4, 8),
                List.of(2, 2, 8),
                List.of(2, 4, 4),
                List.of(2, 2, 2, 4),
                List.of(2, 2, 2, 2, 2)
        );
    }
}