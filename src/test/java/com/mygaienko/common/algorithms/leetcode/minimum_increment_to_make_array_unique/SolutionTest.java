package com.mygaienko.common.algorithms.leetcode.minimum_increment_to_make_array_unique;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7});
        assertThat(actual).isEqualTo(6);
    }
}