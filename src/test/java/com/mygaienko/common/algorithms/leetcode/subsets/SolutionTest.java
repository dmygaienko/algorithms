package com.mygaienko.common.algorithms.leetcode.subsets;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        List<List<Integer>> subsets = solution.subsets(new int[]{1, 2, 3});
        assertThat(subsets).containsExactlyInAnyOrder(
                List.of(),
                List.of(1),
                List.of(2),
                List.of(3),
                List.of(1,2),
                List.of(2,3),
                List.of(1,3),
                List.of(1,2, 3)
        );

    }
}