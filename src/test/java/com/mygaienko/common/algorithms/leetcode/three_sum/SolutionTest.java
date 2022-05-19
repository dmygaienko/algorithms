package com.mygaienko.common.algorithms.leetcode.three_sum;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        List<List<Integer>> lists = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertThat(lists).containsExactlyInAnyOrder(
                List.of(-1, -1, 2),
                List.of(-1, 0, 1)
        );
    }

    @Test
    public void test1() {
        List<List<Integer>> lists = solution.threeSum(new int[]{0, 0});
        assertThat(lists).isEmpty();
    }

    @Test
    public void test2() {
        List<List<Integer>> lists = solution.threeSum(new int[]{1,1,-2});
        assertThat(lists).containsExactlyInAnyOrder(
                List.of(-2, 1, 1)
        );
    }

    @Test
    public void test3() {
        List<List<Integer>> lists = solution.threeSum(new int[]{0, 0, 0});
        assertThat(lists).containsExactlyInAnyOrder(
                List.of(0, 0, 0)
        );
    }
}