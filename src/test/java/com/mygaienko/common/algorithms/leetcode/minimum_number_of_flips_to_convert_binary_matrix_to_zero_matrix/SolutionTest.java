package com.mygaienko.common.algorithms.leetcode.minimum_number_of_flips_to_convert_binary_matrix_to_zero_matrix;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.minFlips(new int[][]{
                {1, 0, 0},
                {1, 0, 0}
        });
        assertThat(actual).isEqualTo(-1);
    }
}