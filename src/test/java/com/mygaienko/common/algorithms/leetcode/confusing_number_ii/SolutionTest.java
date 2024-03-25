package com.mygaienko.common.algorithms.leetcode.confusing_number_ii;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test10() {
        int actual = solution.confusingNumberII(10);
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test20() {
        int actual = solution.confusingNumberII(20);
        assertThat(actual).isEqualTo(6);
    }

    @Test
    public void test100() {
        int actual = solution.confusingNumberII(100);
        assertThat(actual).isEqualTo(19);
    }

    @Test
    public void testRotate0() {
        var actual = solution.rotate(10);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void testRotate() {
        var actual = solution.rotate(11);
        assertThat(actual).isEqualTo(11);
    }

    @Test
    public void testRotate169961() {
        var actual = solution.rotate(1669961);
        assertThat(actual).isEqualTo(1966991);
    }

    @Test
    public void testRotate2() {
        var actual = solution.rotate(121);
        assertThat(actual).isEqualTo(121);
    }

    @Test
    public void testRotate3() {
        var actual = solution.rotate(1234567890);
        assertThat(actual).isEqualTo(687954321);
    }
}