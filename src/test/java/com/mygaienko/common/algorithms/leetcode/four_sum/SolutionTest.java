package com.mygaienko.common.algorithms.leetcode.four_sum;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        assertThat(actual).containsExactlyInAnyOrder(
                List.of(-2, -1, 1, 2),
                List.of(-2, 0, 0, 2),
                List.of(-1, 0, 0, 1));
    }

    @Test
    public void test4() {
        var actual = solution.fourSum(new int[]{-3,-1,0,2,4,5}, 0);
        assertThat(actual).containsExactlyInAnyOrder(
                List.of(-3,-1,0,4));
    }

    @Test
    public void test2() {
        var actual = solution.fourSum(new int[]{2,2,2,2,2}, 8);
        assertThat(actual).containsExactlyInAnyOrder(
                List.of(2,2,2,2));
    }

    @Test
    public void test2222() {
        var actual = solution.fourSum(new int[]
                {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2
                        ,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2
                        ,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2
                        ,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2
                        ,2,2,2,2,2,2,2,2}, 8);
        assertThat(actual).containsExactlyInAnyOrder(
                List.of(2,2,2,2));
    }

    @Test
    public void test123414() {
        var actual = solution.fourSum(new int[]
                {1000000000,1000000000,1000000000,1000000000}, -294967296);
        assertThat(actual).isEmpty();
    }
}