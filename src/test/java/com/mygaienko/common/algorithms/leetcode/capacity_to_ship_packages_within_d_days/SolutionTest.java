package com.mygaienko.common.algorithms.leetcode.capacity_to_ship_packages_within_d_days;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
        assertThat(actual).isEqualTo(15);
    }

    @Test
    public void test3() {
        int actual = solution.shipWithinDays(new int[]{1,2,3,1,1}, 4);
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test73() {
        int actual = solution.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 1);
        assertThat(actual).isEqualTo(55);
    }
}