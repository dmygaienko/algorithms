package com.mygaienko.common.algorithms.leetcode.reveal_cards_in_increasing_order;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7});
        assertThat(actual).isEqualTo(new int[]{2, 13, 3, 11, 5, 17, 7});
    }

    @Test
    public void test01() {
        var actual = solution.deckRevealedIncreasing(new int[]{13, 11, 2, 3, 5, 7});
        assertThat(actual).isEqualTo(new int[]{2, 7, 3, 13, 5, 11});
    }

    @Test
    public void test1() {
        var actual = solution.deckRevealedIncreasing(new int[]{1, 1000});
        assertThat(actual).isEqualTo(new int[]{1, 1000});
    }

    @Test
    public void test1234() {
        var actual = solution.deckRevealedIncreasing(new int[]{1, 2, 3, 4});
        assertThat(actual).isEqualTo(new int[]{1, 3, 2, 4});
    }

    @Test
    public void test12345() {
        var actual = solution.deckRevealedIncreasing(new int[]{1, 2, 3, 4, 5});
        assertThat(actual).isEqualTo(new int[]{1, 5, 2, 4, 3});
    }
}