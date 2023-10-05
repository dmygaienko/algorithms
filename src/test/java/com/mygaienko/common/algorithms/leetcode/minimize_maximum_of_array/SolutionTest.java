package com.mygaienko.common.algorithms.leetcode.minimize_maximum_of_array;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.minimizeArrayValue(new int[]{3, 7, 1, 6});
        assertThat(actual).isEqualTo(5);
    }

}