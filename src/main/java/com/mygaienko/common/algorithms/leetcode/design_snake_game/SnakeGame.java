package com.mygaienko.common.algorithms.leetcode.design_snake_game;

import java.util.ArrayDeque;
import java.util.Deque;

class SnakeGame {

    private final String[][] field;
    private final int[][] foods;

    private static final int GAME_OVER = -1;
    private static final String SNAKE = "S";
    private static final String EMPTY = "";

    private static final int[] UP = new int[]{-1, 0};
    private static final int[] DOWN = new int[]{1, 0};

    private static final int[] RIGHT = new int[]{0, 1};
    private static final int[] LEFT = new int[]{0, -1};

    Deque<int[]> snake = new ArrayDeque<>();

    int found = 0;

    public SnakeGame(int width, int height, int[][] food) {
        this.field = new String[height][width];
        this.foods = food;
        snake.offer(new int[] {0, 0});
    }

    public int move(String direction) {
        int nextX;
        int nextY;

        int[] head = snake.peekFirst();

        if (direction.equals("U")) {
            nextX = head[0] + UP[0];
            nextY = head[1] + UP[1];
        } else if (direction.equals("D")) {
            nextX = head[0] + DOWN[0];
            nextY = head[1] + DOWN[1];
        } else if (direction.equals("R")) {
            nextX = head[0] + RIGHT[0];
            nextY = head[1] + RIGHT[1];
        } else {
            nextX = head[0] + LEFT[0];
            nextY = head[1] + LEFT[1];
        }

        int[] tail = snake.peekLast();
        if (nextX < 0 || nextX >= field.length) return GAME_OVER;
        if (nextY < 0 || nextY >= field[0].length) return GAME_OVER;
        if (field[nextX][nextY] != null && field[nextX][nextY].equals(SNAKE)
                && (tail[0] != nextX || tail[1] != nextY)) return GAME_OVER;

        int[] nextPos = new int[] {nextX, nextY};
        if (found < foods.length && foods[found][0] == nextX && foods[found][1] == nextY) {
            found++;
        } else {
            tail = snake.pollLast();
            field[tail[0]][tail[1]] = EMPTY;
        }
        snake.push(nextPos);
        field[nextX][nextY] = SNAKE;

        return found;
    }
}