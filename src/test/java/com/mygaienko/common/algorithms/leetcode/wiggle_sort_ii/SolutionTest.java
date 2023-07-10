package com.mygaienko.common.algorithms.leetcode.wiggle_sort_ii;


import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        int[] nums = new int[] {1,5,1,1,6,4};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
        assertThat(nums).containsExactly(1, 5, 1, 6, 1, 4);
    }

    @Test
    public void test2() {
        int[] nums = new int[] {1,3,2,2,3,1};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
        assertThat(nums).containsExactly(1, 3, 2, 3, 1, 2);
    }

    @Test
    public void test() {
        int[] nums = new int[] {1, 11, 3, 6, 8, 2, 3, 4, 5};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
        assertThat(nums).containsExactly(1, 11, 3, 6, 2, 8, 3, 5, 4);
    }

    @Test
    public void test_15() {
        int[] nums = new int[] {5,5,5,4,4,4,4};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
        assertThat(nums).containsExactly(4,5,4,5,4,5,4);
    }

    @Test
    public void test_16() {
        int[] nums = new int[] {1,4,3,4,1,2,1,3,1,3,2,3,3};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
        assertThat(nums).containsExactly(3, 4, 3, 4, 1, 2, 1, 3, 1, 3, 2, 3, 1);
    }

    @Test
    public void test_19() {
        int[] nums = new int[] {3,1,2,1,2,1,1,1,2};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
//        assertThat(nums).containsExactly(1, 3, 1, 2, 1, 2, 1, 2, 1);
    }

    @Test
    public void test_32() {
        int[] nums = new int[] {4,5,5,6};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
        assertThat(nums).containsExactly(5, 6, 4, 5);
    }

    @Test
    public void test_33() {
        int[] nums = new int[] {2,3,3,2,2,2,1,1};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
        assertThat(nums).containsExactly(2, 3, 2, 3, 1, 2, 1, 2);
    }

    @Test
    public void test_37() {
        int[] nums = new int[] {5,3,1,2,6,7,8,5,5};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
        assertThat(nums).containsExactly(1, 3, 2, 7, 5, 8, 5, 6, 5);
    }

    @Test
    public void test_39() {
        int[] nums = new int[] {3,2,1,3};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
        assertThat(nums).containsExactly(1, 3, 2, 3);
    }

    @Test
    public void test_47() {
        int[] nums = new int[] {3,2,3,3,2,1,1,2,3,1,1,3,2,1,2,2,2,2,1};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
//        assertThat(nums).containsExactly(1, 2, 1, 3, 2, 3, 2, 3, 2, 3, 2, 3, 1, 2, 1, 2, 1, 2, 1);
    }

    @Test
    public void test_51() {
        int[] nums = new int[] {0,1,0,6,2,2,2,2};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
//        assertThat(nums).containsExactly(2, 6, 0, 2, 1, 2, 0, 2);
    }

    @Test
    public void test_52() {
        int[] nums = new int[] {2,4,5,1,2,4,1,1,3,3,1,2,4,3};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
//        assertThat(nums).containsExactly(1, 2, 1, 3, 2, 3, 2, 3, 2, 3, 2, 3, 1, 2, 1, 2, 1, 2, 1);
    }

}