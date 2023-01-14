package com.mygaienko.common.algorithms.leetcode.design_tic_tac_toe;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class TicTacToe {

    private int NO_WIN = 0;

    private int FIRST_PLAYER = 1;
    private int SECOND_PLAYER = 2;

    private int[] UP = {-1, 0};
    private int[] DOWN = {1, 0};
    private int[] LEFT = {0, -1};
    private int[] RIGHT = {0, 1};

    private int[] UP_LEFT = {-1, -1};
    private int[] UP_RIGHT = {-1, 1};
    private int[] DOWN_LEFT = {1, -1};
    private int[] DOWN_RIGHT = {1, 1};

    private final Map<Point, Point> horizontals = new HashMap<>();
    private final Map<Point, Point> verticals = new HashMap<>();
    private final Map<Point, Point> diagonals = new HashMap<>();
    private final Map<Point, Point> antiDiagonals = new HashMap<>();

    private final Map<Point, Point> horizontalsSecond = new HashMap<>();
    private final Map<Point, Point> verticalsSecond = new HashMap<>();
    private final Map<Point, Point> diagonalsSecond = new HashMap<>();
    private final Map<Point, Point> antiDiagonalsSecond = new HashMap<>();

    private int N;

    public TicTacToe(int n) {
        N = n;
    }

    public int move(int row, int col, int player) {
        Point point = new Point(row, col);

        if (player == FIRST_PLAYER) {
            if (check(point, horizontals, verticals, diagonals, antiDiagonals)) return player;
        } else {
            if (check(point, horizontalsSecond, verticalsSecond, diagonalsSecond, antiDiagonalsSecond)) return player;
        }

        return NO_WIN;
    }

    private boolean check(Point point, Map<Point, Point> horizontals, Map<Point, Point> verticals, Map<Point, Point> diagonals, Map<Point, Point> antiDiagonals) {
        if (isRow(horizontals, point, LEFT, RIGHT)) return true;
        else if (isRow(verticals, point, UP, DOWN)) return true;
        else if (isRow(diagonals, point, UP_LEFT, DOWN_RIGHT)) return true;
        else return isRow(antiDiagonals, point, UP_RIGHT, DOWN_LEFT);
    }

    private boolean isRow(Map<Point, Point> segments, Point point, int[] firstNeigh, int[] secondNeigh) {
        Point end = point;
        Point secondEnd = point;

        Point firstStart = new Point(point.getRow() + firstNeigh[0], point.getCol() + firstNeigh[1]);
        Point secondStart = new Point(point.getRow() + secondNeigh[0], point.getCol() + secondNeigh[1]);
        
        if (segments.containsKey(firstStart)) {
            end = segments.get(firstStart);
            
            if (segments.containsKey(secondStart)) {
                secondEnd = segments.get(secondStart);
                segments.remove(firstStart);
                segments.remove(secondStart);
                segments.put(end, secondEnd);
                segments.put(secondEnd, end);
            } else {
                segments.remove(firstStart);
                segments.put(end, point);
                segments.put(point, end);
            }
        } else if (segments.containsKey(secondStart)) {
            secondEnd = segments.get(secondStart);
            segments.remove(secondStart);
            segments.put(secondEnd, point);
            segments.put(point, secondEnd);
        } else {
            segments.put(point, point);
        }

        int length = Math.max(Math.abs(end.getRow() - secondEnd.getRow()), Math.abs(end.getCol() - secondEnd.getCol()));
        return length == N - 1;
    }
    
    class Point {
        private final int row;
        private final int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return row == point.row &&
                    col == point.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

}