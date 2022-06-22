package com.mygaienko.common.algorithms.leetcode.design_snake_game;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SnakeGameTest {

    @Test
    public void name() {
        SnakeGame snakeGame = new SnakeGame(2, 2, new int[][]{{1, 1}, {0, 0}});
        assertThat(snakeGame.move("R")).isEqualTo(0);
        assertThat(snakeGame.move("D")).isEqualTo(1);
        assertThat(snakeGame.move("L")).isEqualTo(1);
        assertThat(snakeGame.move("U")).isEqualTo(2);
        assertThat(snakeGame.move("R")).isEqualTo(2);
    }

    @Test
    public void test439() {
        SnakeGame snakeGame = new SnakeGame(3, 3, new int[][]{{2, 0}, {0, 0}, {0, 2}, {2, 2}});
        assertThat(snakeGame.move("D")).isEqualTo(0);
        assertThat(snakeGame.move("D")).isEqualTo(1);
        assertThat(snakeGame.move("R")).isEqualTo(1);
        assertThat(snakeGame.move("U")).isEqualTo(1);
        assertThat(snakeGame.move("U")).isEqualTo(1);
        assertThat(snakeGame.move("L")).isEqualTo(2);
        assertThat(snakeGame.move("D")).isEqualTo(2);
        assertThat(snakeGame.move("R")).isEqualTo(2);
        assertThat(snakeGame.move("R")).isEqualTo(2);
        assertThat(snakeGame.move("U")).isEqualTo(3);
        assertThat(snakeGame.move("L")).isEqualTo(3);
        assertThat(snakeGame.move("D")).isEqualTo(3);
    }

    @Test
    public void test77() {
        SnakeGame snakeGame = new SnakeGame(3, 3, new int[][]{{2, 0}, {0, 0}, {0, 2}, {0, 1}, {2, 2}, {0, 1}});
        assertThat(snakeGame.move("D")).isEqualTo(0);
        assertThat(snakeGame.move("D")).isEqualTo(1);
        assertThat(snakeGame.move("R")).isEqualTo(1);
        assertThat(snakeGame.move("U")).isEqualTo(1);
        assertThat(snakeGame.move("U")).isEqualTo(1);
        assertThat(snakeGame.move("L")).isEqualTo(2);
        assertThat(snakeGame.move("D")).isEqualTo(2);
        assertThat(snakeGame.move("R")).isEqualTo(2);
        assertThat(snakeGame.move("R")).isEqualTo(2);
        assertThat(snakeGame.move("U")).isEqualTo(3);
        assertThat(snakeGame.move("L")).isEqualTo(4);
        assertThat(snakeGame.move("L")).isEqualTo(4);
        assertThat(snakeGame.move("D")).isEqualTo(4);
        assertThat(snakeGame.move("R")).isEqualTo(4);
        assertThat(snakeGame.move("U")).isEqualTo(-1);
    }

}