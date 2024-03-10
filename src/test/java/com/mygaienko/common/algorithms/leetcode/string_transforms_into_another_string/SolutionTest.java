package com.mygaienko.common.algorithms.leetcode.string_transforms_into_another_string;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.canConvert("aabcc", "ccdee");
        assertThat(actual).isEqualTo(true);
    }

    @Test
    public void test1() {
        var actual = solution.canConvert("leetcode", "codeleet");
        assertThat(actual).isEqualTo(false);
    }

    @Test
    public void test2() {
        var actual = solution.canConvert("aabb", "cccc");
        assertThat(actual).isEqualTo(true);
    }

    @Test
    public void test3() {
        var actual = solution.canConvert("ab", "ba");
        assertThat(actual).isEqualTo(true);
    }

    @Test
    public void test4() {
        var actual = solution.canConvert("abc", "cba");
        assertThat(actual).isEqualTo(true);
    }
}