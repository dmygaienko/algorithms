package com.mygaienko.common.algorithms.leetcode.max_chunks_to_make_sorted_ii;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test2_2() {
        int actual = solution.maxChunksToSorted(new int[]{2,1,3,4,4});
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test2_69() {
        int actual = solution.maxChunksToSorted(new int[]{0,0,1,1,1});
        assertThat(actual).isEqualTo(5);
    }

    @Test
    public void test2_98() {
        int actual = solution.maxChunksToSorted(new int[]{1,1,0,0,1});
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test2_333() {
        int actual = solution.maxChunksToSorted(new int[]{0,3,0,3,2});
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test2_133() {
        int actual = solution.maxChunksToSorted(new int[]{0,0,1,1,0,1,1,1,1,0});
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test2_106() {
        int actual = solution.maxChunksToSorted(new int[]{4,0,0,2,4});
        assertThat(actual).isEqualTo(2);
    }

}