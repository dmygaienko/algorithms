package com.mygaienko.common.algorithms.leetcode.find_k_closest_elements;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    private Solution solution = new Solution();

    /**
     * [1,2,3,4,5]
     * 4
     * -1
     */
    @Test
    public void test_0() {
        List<Integer> actual = solution.findClosestElements(new int[]{1,2,3,4,5}, 4, -1);
        assertThat(actual).isEqualTo(List.of(1,2,3,4));
    }

    /**
     * [1,1,1,10,10,10]
     * 1
     * 9
     */
    @Test
    public void test() {
        List<Integer> actual = solution.findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9);
        assertThat(actual).isEqualTo(List.of(10));
    }

    /**
     [-2,-1,1,2,3,4,5]
     7
     3
     */
    @Test
    public void test1() {
        List<Integer> actual = solution.findClosestElements(new int[]{-2,-1,1,2,3,4,5}, 7, 3);
        assertThat(actual).isEqualTo(List.of(-2, -1, 1, 2, 3, 4, 5));
    }

    /**
     [0,0,1,2,3,3,4,7,7,8]
     */
    @Test
    public void test2() {
        List<Integer> actual = solution.findClosestElements(new int[]{0,0,1,2,3,3,4,7,7,8}, 3, 5);
        assertThat(actual).isEqualTo(List.of(3,3,4));
    }

    /**
     [1,10,15,25,35,45,50,59]
     1
     30
     */
    @Test
    public void test3() {
        List<Integer> actual = solution.findClosestElements(new int[]{1,10,15,25,35,45,50,59}, 1, 30);
        assertThat(actual).isEqualTo(List.of(25));
    }

    /**
     [1,1,2,2,3,3,6,7,8,9,9,11,11,12,12,12,13,15,18,18,21,22,22,23,25,25,32,33,34,37,37,38,38,39,39,40,41,43,43,45,45,46,
     46,48,48,49,50,50,53,53,54,54,56,57,57,58,58,60,60,61,62,63,63,66,69,70,71,71,71,74,75,75,76,76,80,81,81,82,84,86,86,
     87,87,87,88,90,91,93,93,93,94,94,94,95,96,97,98,98,98,99]
     3
     13
     */
    @Test
    public void test4() {
        List<Integer> actual = solution.findClosestElements(new int[]{1,1,2,2,3,3,6,7,8,9,9,11,11,12,12,12,13,15,18,18,21,22,22,23,25,25,32,33,34,37,37,38,38,39,39,40,41,43,43,45,45,46,
                46,48,48,49,50,50,53,53,54,54,56,57,57,58,58,60,60,61,62,63,63,66,69,70,71,71,71,74,75,75,76,76,80,81,81,82,84,86,86,
                87,87,87,88,90,91,93,93,93,94,94,94,95,96,97,98,98,98,99}, 3, 13);
        assertThat(actual).isEqualTo(List.of(12,12,13));
    }

}
