package com.mygaienko.common.algorithms.bitwise_ors_of_subarrays;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        int actual = solution.subarrayBitwiseORs(new int[]{0});
        assertThat(actual).isEqualTo(1);
    }


    @Test
    public void test2() {
        int actual = solution.subarrayBitwiseORs(new int[]{1, 1, 2});
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test3() {
        int actual = solution.subarrayBitwiseORs(new int[]{1, 2, 4});
        assertThat(actual).isEqualTo(6);
    }

    @Test
    public void test27() {
        int actual = solution.subarrayBitwiseORs(new int[]{6, 12, 7});
        assertThat(actual).isEqualTo(5);
    }

}