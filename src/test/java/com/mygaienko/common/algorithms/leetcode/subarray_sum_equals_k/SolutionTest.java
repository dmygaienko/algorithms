package com.mygaienko.common.algorithms.leetcode.subarray_sum_equals_k;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        int actual = solution.subarraySum(new int[]{-1, -1, 1}, 0);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test1() {
        int actual = solution.subarraySum(new int[]{1, 1, 1}, 2);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test3() {
        int actual = solution.subarraySum(new int[]{1, 2, 3}, 3);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test4() {
        int actual = solution.subarraySum(new int[]{1,-1,0}, 0);
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test5() {
        int actual = solution.subarraySum(new int[]{-92,-63,75,-86,-58,22,31,-16,-66,-67,420}, 100);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test39() {
        int actual = solution.subarraySum(new int[]{28,54,7,-70,22,65,-6}, 100);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test23() {
        int actual = solution.subarraySum(new int[]{1,2,1,2,1}, 3);
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test31() {
        int actual = solution.subarraySum(new int[]{100,1,2,3,4}, 6);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test48() {
        int actual = solution.subarraySum(new int[]{-19,-82,-70,-46,-29,7,15,-72,-7,100,303}, 100);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test45() {
        int actual = solution.subarraySum(new int[]{0,0,0,0,0,0,0,0,0,0}, 0);
        assertThat(actual).isEqualTo(55);
    }
}