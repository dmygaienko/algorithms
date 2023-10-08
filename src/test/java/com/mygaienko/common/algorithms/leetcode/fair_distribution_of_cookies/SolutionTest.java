package com.mygaienko.common.algorithms.leetcode.fair_distribution_of_cookies;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.distributeCookies(new int[]{8, 15, 10, 20, 8}, 2);
        assertThat(actual).isEqualTo(31);
    }

    @Test
    public void test1() {
        var actual = solution.distributeCookies(new int[]{6,1,3,2,2,4,1,2}, 3);
        assertThat(actual).isEqualTo(7);
    }

    @Test
    public void test2() {
        var actual = solution.distributeCookies(new int[]{20,13,18}, 2);
        assertThat(actual).isEqualTo(31);
    }

    @Test
    public void test37() {
        var actual = solution.distributeCookies(new int[]{941,797,1475,638,191,712}, 3);
        assertThat(actual).isEqualTo(1653);
    }

    @Test
    public void test38() {
        var actual = solution.distributeCookies(new int[]{76265,7826,16834,63341,68901,58882,50651,75609}, 8);
        assertThat(actual).isEqualTo(1653);
    }
}