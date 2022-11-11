package com.mygaienko.common.algorithms.leetcode.shortest_way_to_form_string;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void test() {
        int i = solution.shortestWay("abc", "abcbc");
        assertThat(i).isEqualTo(2);
    }

    @Test
    public void test2() {
        int i = solution.shortestWay("abc", "acdbc");
        assertThat(i).isEqualTo(-1);
    }

    @Test
    public void test3() {
        int i = solution.shortestWay("xyz", "xzyxz");
        assertThat(i).isEqualTo(3);
    }

    @Test
    public void test4() {
        int i = solution.shortestWay("abc", "abcabcd");
        assertThat(i).isEqualTo(-1);
    }

    @Test
    public void test5() {
        int i = solution.shortestWay("fhgkqmzx", "fhgkqmzxfhgkqmzxfhgkqmzxfhgkqmzxfhgkqmzx");
        assertThat(i).isEqualTo(5);
    }
}