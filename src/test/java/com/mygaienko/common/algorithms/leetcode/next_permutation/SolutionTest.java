package com.mygaienko.common.algorithms.leetcode.next_permutation;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int[] arr = new int[] {1,2,3,4,5};
        solution.nextPermutation(arr);
        assertThat(arr).isEqualTo(new int[] {1,2,3,5,4});
    }

    @Test
    public void test1() {
        int[] arr = new int[] {5,4,3,2,1};
        solution.nextPermutation(arr);
        assertThat(arr).isEqualTo(new int[] {1,2,3,4,5});
    }

    @Test
    public void test2() {
        int[] arr = new int[] {4,5,3,2,1};
        solution.nextPermutation(arr);
        assertThat(arr).isEqualTo(new int[] {5,1,2,3,4});
    }

    @Test
    public void test3() {
        int[] arr = new int[] {6,7,5,4,3,1};
        solution.nextPermutation(arr);
        assertThat(arr).isEqualTo(new int[] {7,1,3,4,5,6});
    }

}