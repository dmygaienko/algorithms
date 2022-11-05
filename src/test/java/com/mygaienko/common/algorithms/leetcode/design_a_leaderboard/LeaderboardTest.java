package com.mygaienko.common.algorithms.leetcode.design_a_leaderboard;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LeaderboardTest {

    /**
     * ["Leaderboard","addScore","addScore","addScore","addScore","addScore","top","reset","reset","addScore","top"]
     * [[],[1,73],[2,56],[3,39],[4,51],[5,4],[1],[1],[2],[2,51],[3]]
     */
    @Test
    public void test1() {
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.addScore(1, 73);
        leaderboard.addScore(2, 56);
        leaderboard.addScore(3, 39);
        leaderboard.addScore(4, 51);
        leaderboard.addScore(5, 4);
        assertThat(leaderboard.top(1)).isEqualTo(73);
        leaderboard.reset(1);
        leaderboard.reset(2);
        leaderboard.addScore(2, 51);
        assertThat(leaderboard.top(3)).isEqualTo(141);
    }
}