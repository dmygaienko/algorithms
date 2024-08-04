package com.mygaienko.common.algorithms.leetcode.bag_of_tokens;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.bagOfTokensScore(new int[]{48, 87, 26}, 81);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test3() {
        int actual = solution.bagOfTokensScore(new int[]{100, 200, 300, 400}, 200);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test141() {
        int actual = solution.bagOfTokensScore(new int[]{71, 55, 82}, 54);
        assertThat(actual).isEqualTo(0);
    }
}