package com.mygaienko.common.algorithms.leetcode.diagonal_traverse_ii;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test123() {
        var actual = solution.findDiagonalOrder(List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        ));
        assertThat(actual).isEqualTo(new int[]{1, 4, 2, 7, 5, 3, 8, 6, 9});
    }

    @Test
    public void test() {
        var actual = solution.findDiagonalOrder(List.of(
                List.of(14, 12, 19, 16, 9),
                List.of(13, 14, 15, 8, 11),
                List.of(11, 13, 1)
        ));
        assertThat(actual).isEqualTo(new int[]{14, 13, 12, 11, 14, 19, 13, 15, 16, 1, 8, 9, 11});
    }
}