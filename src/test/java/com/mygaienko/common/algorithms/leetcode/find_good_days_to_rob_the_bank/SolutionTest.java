package com.mygaienko.common.algorithms.leetcode.find_good_days_to_rob_the_bank;


import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    public static final Solution solution = new Solution();

    @Test
    public void test0() {
        int[] security = {5, 3, 3, 3, 5, 6, 2};
        int time = 2;
        var result = solution.goodDaysToRobBank(security, time);
        assertThat(result).isEqualTo(List.of(2, 3));
    }

    @Test
    public void test1() {
        int[] security = {1, 1, 1, 1, 1};
        int time = 0;
        var result = solution.goodDaysToRobBank(security, time);
        assertThat(result).isEqualTo(List.of(0, 1, 2, 3, 4));
    }

    @Test
    public void test2() {
        int[] security = {1, 2, 3, 4};
        int time = 0;
        var result = solution.goodDaysToRobBank(security, time);
        assertThat(result).isEqualTo(List.of(0, 1, 2, 3));
    }

    @Test
    public void test3() {
        int[] security = {4, 3, 2, 1};
        int time = 0;
        var result = solution.goodDaysToRobBank(security, time);
        assertThat(result).isEqualTo(List.of(0, 1, 2, 3));
    }

}