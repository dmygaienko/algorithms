package com.mygaienko.common.algorithms.leetcode.frequency_of_the_most_frequent_element;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.maxFrequency(new int[]{1, 2, 4}, 5);
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test2() {
        var actual = solution.maxFrequency(new int[]{1,4,8,13}, 5);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test3() {
        var actual = solution.maxFrequency(new int[]{3,9,6}, 2);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test5() {
        var actual = solution.maxFrequency(new int[]{
                9930,9923,9983,9997,9934,9952,9945,9914,9985,9982,
                9970,9932,9985,9902,9975,9990,9922,9990,9994,9937,
                9996,9964,9943,9963,9911,9925,9935,9945,9933,9916,
                9930,9938,10000,9916,9911,9959,9957,9907,9913,9916,
                9993,9930,9975,9924,9988,9923,9910,9925,9977,9981,
                9927,9930,9927,9925,9923,9904,9928,9928,9986,9903,
                9985,9954,9938,9911,9952,9974,9926,9920,9972,9983,
                9973,9917,9995,9973,9977,9947,9936,9975,9954,9932,
                9964,9972,9935,9946,9966}, 3056);
        assertThat(actual).isEqualTo(73);
    }
}