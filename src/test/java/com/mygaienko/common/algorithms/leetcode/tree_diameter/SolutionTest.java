package com.mygaienko.common.algorithms.leetcode.tree_diameter;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.treeDiameter(new int[][]{
                {0, 1},
                {1, 2},
                {2, 3},
                {1, 4},
                {4, 5}
        });
        assertThat(actual).isEqualTo(4);
    }
}