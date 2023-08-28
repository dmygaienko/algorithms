package com.mygaienko.common.algorithms.leetcode.longest_line_of_consecutive_one_in_matrix;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.longestLine(new int[][]{
                {1, 1, 1, 1}, {0, 1, 1, 0}, {0, 0, 0, 1}
        });
        assertThat(actual).isEqualTo(4);
    }
}