package com.mygaienko.common.algorithms.leetcode.minimum_swaps_to_group_all_1s_together;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void test1() {
        Solution solution = new Solution();
        assertThat(solution.minSwaps(new int [] {1,0,1,0,1})).isEqualTo(1);
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        assertThat(solution.minSwaps(new int [] {1,0,1,0,1,0,0,1,1,0,1})).isEqualTo(3);
    }

    @Test
    public void test4() {
        Solution solution = new Solution();
        assertThat(solution.minSwaps(new int [] {1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1})).isEqualTo(1);
    }

}