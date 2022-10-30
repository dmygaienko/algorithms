package com.mygaienko.common.algorithms.leetcode.design_snake_game;

import java.util.ArrayDeque;
import java.util.Deque;

public class Snake {

    final String[][] field;
    final int[][] foods;

    static final int GAME_OVER = -1;
    static final String SNAKE = "S";
    static final String EMPTY = "";

    static final int[] UP = {1, 0};
    static final int[] DOWN = {-1, 0};

    static final int[] RIGHT = {0, 1};
    static final int[] LEFT = {0, -1};

    Deque<int[]> snake = new ArrayDeque<>();

    int found = 0;

    public Snake(int width, int height, int[][] foods) {
        this.field = new String[width][height];
        this.foods = foods;
        snake.offer(new int[] {0, 0});
    }

    int move(String direction) {
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

        if (nextX < 0 || nextX >= field.length || nextY < 0 || nextY >= field[0].length || field[nextX][nextY].equals(SNAKE)) {
            return GAME_OVER;
        }

        int[] nextPos = new int[] {nextX, nextY};
        if (foods[found][0] == nextX && foods[found][1] == nextY) {
            found++;
            snake.push(nextPos);
            field[nextX][nextY] = SNAKE;
        } else {
            int[] tail = snake.poll();
            field[tail[0]][tail[1]] = EMPTY;
        }
        return found;
    }

}
