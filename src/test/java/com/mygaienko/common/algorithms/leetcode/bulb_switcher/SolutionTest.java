package com.mygaienko.common.algorithms.leetcode.bulb_switcher;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.bulbSwitch(6);
        assertThat(actual).isEqualTo(2);
    }
}