package com.mygaienko.common.algorithms.leetcode.delete_and_earn;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        var actual = solution.deleteAndEarn(new int[] {3, 4, 2});
        assertThat(actual).isEqualTo(6);
    }

    @Test
    public void test2() {
        var actual = solution.deleteAndEarn(new int[] {1,1,1,2,4,5,5,5,6});
        assertThat(actual).isEqualTo(18);
    }

    @Test
    public void test() {
        var actual = solution.deleteAndEarn(new int[] {2,2,3,3,3,4});
        assertThat(actual).isEqualTo(9);
    }

    @Test
    public void test4() {
        var actual = solution.deleteAndEarn(new int[] {8,3,4,7,6,6,9,2,5,8,2,4,9,5,9,1,5,7,1,4});
        assertThat(actual).isEqualTo(61);
    }

    @Test
    public void test5() {
        var actual = solution.deleteAndEarn(new int[] {8,7,3,8,1,4,10,10,10,2});
        assertThat(actual).isEqualTo(52);
    }
}