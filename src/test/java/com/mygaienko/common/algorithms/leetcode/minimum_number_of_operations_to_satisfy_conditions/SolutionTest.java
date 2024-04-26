package com.mygaienko.common.algorithms.leetcode.minimum_number_of_operations_to_satisfy_conditions;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.minimumOperations(new int[][]{
                {1, 0, 2},
                {1, 0, 2}
        });

        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void test1() {
        int actual = solution.minimumOperations(new int[][]{
                {1, 1, 1},
                {0, 0, 0}
        });

        assertThat(actual).isEqualTo(3);
    }
}