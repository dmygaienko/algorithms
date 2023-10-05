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

    @Test
    public void test13() {
        int actual = solution.minimizeArrayValue(new int[]{13,13,20,0,8,9,9});
        assertThat(actual).isEqualTo(16);
    }


    @Test
    public void test11() {
        int actual = solution.minimizeArrayValue(new int[]{6,9,3,8,14});
        assertThat(actual).isEqualTo(8);
    }

}