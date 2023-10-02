package com.mygaienko.common.algorithms.leetcode.rearrange_string_k_distance_apart;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        var actual = solution.rearrangeString("aabbcc", 3);
        assertThat(actual).isEqualTo("cbacba");
    }

    @Test
    public void test3() {
        var actual = solution.rearrangeString("aaadbbcc", 2);
        assertThat(actual).isEqualTo("acbadcba");
    }

    @Test
    public void test39() {
        var actual = solution.rearrangeString("aa", 0);
        assertThat(actual).isEqualTo("aa");
    }

    @Test
    public void test49() {
        var actual = solution.rearrangeString("abb", 2);
        assertThat(actual).isEqualTo("bab");
    }

    @Test
    public void test59() {
        var actual = solution.rearrangeString("aaabc", 2);
        assertThat(actual).isEqualTo("acaba");
    }

    @Test
    public void test62() {
        var actual = solution.rearrangeString("bfcfceaeaadgebb", 6);
        assertThat(actual).isEqualTo("ebafcgebafdceba");
    }
}
