package com.mygaienko.common.algorithms.leetcode.single_number;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        assertThat(solution.singleNumber(new int[] {2, 2, 3, 4, 5, 3, 4})).isEqualTo(5);
    }
}