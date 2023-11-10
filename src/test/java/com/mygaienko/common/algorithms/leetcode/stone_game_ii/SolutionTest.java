package com.mygaienko.common.algorithms.leetcode.stone_game_ii;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.stoneGameII(new int[]{2, 7, 9, 4, 4});
        assertThat(actual).isEqualTo(10);
    }
}