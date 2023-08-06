package com.mygaienko.common.algorithms.leetcode.max_chunks_to_make_sorted;


import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test2() {
        int actual = solution.maxChunksToSorted(new int[]{1,0,2,3,4});
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test30() {
        int actual = solution.maxChunksToSorted(new int[]{1,2,0,3});
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test37() {
        int actual = solution.maxChunksToSorted(new int[]{1,2,3,4,5,0});
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test38() {
        int actual = solution.maxChunksToSorted(new int[]{0, 2, 1});
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test48() {
        int actual = solution.maxChunksToSorted(new int[]{0,4,5,2,1,3});
        assertThat(actual).isEqualTo(2);
    }



}