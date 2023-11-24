package com.mygaienko.common.algorithms.leetcode.binary_trees_with_factors;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.numFactoredBinaryTrees(new int[] {2, 4});
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test2() {
        var actual = solution.numFactoredBinaryTrees(new int[] {2, 4, 5, 10});
        assertThat(actual).isEqualTo(7);
    }

    @Test
    public void test3() {
        var actual = solution.numFactoredBinaryTrees(new int[] {2, 4, 5, 10, 40});
        assertThat(actual).isEqualTo(20);
    }

    @Test
    public void test4() {
        var actual = solution.numFactoredBinaryTrees(new int[] {45,42,2,18,23,1170,12,41,40,9,47,24,33,28,10,32,29,17,46,11,759,37,6,26,21,49,31,14,19,8,13,7,27,22,3,36,34,38,39,30,43,15,4,16,35,25,20,44,5,48});
        assertThat(actual).isEqualTo(777);
    }
}