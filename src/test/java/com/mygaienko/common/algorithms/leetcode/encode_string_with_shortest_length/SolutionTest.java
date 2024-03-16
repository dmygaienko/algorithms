package com.mygaienko.common.algorithms.leetcode.encode_string_with_shortest_length;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        var actual = solution.encode("aaa");
        assertThat(actual).isEqualTo("aaa");
    }

    @Test
    public void test() {
        var actual = solution.encode("aaaaa");
        assertThat(actual).isEqualTo("5[a]");
    }

    @Test
    public void test2() {
        var actual = solution.encode("aaaaaaaaaa");
        assertThat(actual).satisfiesAnyOf(
                a -> assertThat(a).isEqualTo("10[a]"),
                a -> assertThat(a).isEqualTo("5[aa]")
        );
    }

    @Test
    public void test31() {
        var actual = solution.encode("aabaab");
        assertThat(actual).satisfiesAnyOf(
                a -> assertThat(a).isEqualTo("aabaab"),
                a -> assertThat(actual).isEqualTo("2[aab]")
        );
    }

    @Test
    public void test3() {
        var actual = solution.encode("aabaabaaba");
        assertThat(actual).satisfiesAnyOf(
                a -> assertThat(a).isEqualTo("a3[aba]"),
                a -> assertThat(actual).isEqualTo("3[aab]a")
        );
    }

    @Test
    public void test4() {
        var actual = solution.encode("abeedbbbdbbbbbb");
        assertThat(actual).satisfiesAnyOf(
                a -> assertThat(a).isEqualTo("a3[aba]"),
                a -> assertThat(actual).isEqualTo("3[aab]a")
        );
    }
}