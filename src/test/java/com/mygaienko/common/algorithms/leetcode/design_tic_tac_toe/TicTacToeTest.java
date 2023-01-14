package com.mygaienko.common.algorithms.leetcode.design_tic_tac_toe;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TicTacToeTest {

    @Test
    public void test() {
        TicTacToe ticTacToe = new TicTacToe(3);
        assertThat(ticTacToe.move(0,0, 1)).isEqualTo(0);
        assertThat(ticTacToe.move(0,2, 2)).isEqualTo(0);
        assertThat(ticTacToe.move(2,2, 1)).isEqualTo(0);
        assertThat(ticTacToe.move(1,1, 2)).isEqualTo(0);
        assertThat(ticTacToe.move(2,0, 1)).isEqualTo(0);
        assertThat(ticTacToe.move(1,0, 2)).isEqualTo(0);
        assertThat(ticTacToe.move(2,1, 1)).isEqualTo(1);
    }


    @Test
    public void test2() {
        TicTacToe ticTacToe = new TicTacToe(3);
        assertThat(ticTacToe.move(1,1, 1)).isEqualTo(0);
        assertThat(ticTacToe.move(0,1, 2)).isEqualTo(0);
        assertThat(ticTacToe.move(0,0, 1)).isEqualTo(0);
        assertThat(ticTacToe.move(2,2, 2)).isEqualTo(0);
        assertThat(ticTacToe.move(0,2, 1)).isEqualTo(0);
        assertThat(ticTacToe.move(2,0, 2)).isEqualTo(0);
        assertThat(ticTacToe.move(1,0, 1)).isEqualTo(0);
        assertThat(ticTacToe.move(2,1, 2)).isEqualTo(2);
    }

    /**
     * [[3],[2,0,1],[0,0,2],[0,1,1],[0,2,2],[2,1,1],[1,1,2],[1,2,1],[2,2,2]]
     */
    @Test
    public void tes3() {
        TicTacToe ticTacToe = new TicTacToe(3);
        assertThat(ticTacToe.move(2,0, 1)).isEqualTo(0);
        assertThat(ticTacToe.move(0,0, 2)).isEqualTo(0);
        assertThat(ticTacToe.move(0,1, 1)).isEqualTo(0);
        assertThat(ticTacToe.move(0,2, 2)).isEqualTo(0);
        assertThat(ticTacToe.move(2,1, 1)).isEqualTo(0);
        assertThat(ticTacToe.move(1,1, 2)).isEqualTo(0);
        assertThat(ticTacToe.move(1,2, 1)).isEqualTo(0);
        assertThat(ticTacToe.move(2,2, 2)).isEqualTo(2);
    }

}