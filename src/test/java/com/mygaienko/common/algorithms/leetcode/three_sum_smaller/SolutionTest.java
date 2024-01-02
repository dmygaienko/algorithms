package com.mygaienko.common.algorithms.leetcode.three_sum_smaller;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    /**
     * -2, 0, 1, 3
     * <p>
     * -2,0,3
     * -2,0,1
     */
    @Test
    public void test0() {
        int actual = solution.threeSumSmaller(new int[]{-2, 0, 1, 3}, 2);
        assertThat(actual).isEqualTo(2);
    }

    /**
     * -2, 0, 1, 1, 2
     * <p>
     * -2,0,2
     * -2,0,1
     * -2,1,1
     * -2,0,1
     */
    @Test
    public void test2() {
        int actual = solution.threeSumSmaller(new int[]{1, -2, 2, 1, 0}, 1);
        assertThat(actual).isEqualTo(4);
    }
}