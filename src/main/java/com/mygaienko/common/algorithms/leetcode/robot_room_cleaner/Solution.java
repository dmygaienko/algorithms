package com.mygaienko.common.algorithms.leetcode.robot_room_cleaner;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

import static com.mygaienko.common.algorithms.leetcode.robot_room_cleaner.Direction.directions;

class Solution {

    public void cleanRoom(Robot robot) {
        new SmartRobot(robot).cleanRoom();
    }

}

class SmartRobot {
    private static final int UNKNOWN = -1;
    private static final int CLEANED = 1;
    private static final int BLOCKED = 0;

    private final int[][] matrix = new int[200][400];

    private final Robot robot;

    int minX = 0; // out wall positions, should be narrowed
    int maxX = 199;

    int intY = 0; // out wall positions, should be narrowed
    int maxY = 399;

    Position currentPosition = Position.of(100, 200);
    Direction currentDirection = Direction.UP;

    public SmartRobot(Robot robot) {
        this.robot = robot;
        for (int[] ints : matrix) {
            Arrays.fill(ints, UNKNOWN);
        }
    }

    public void cleanRoom() {
        recognizeWalls();
        doClean();
    }

    private void doClean() {
        ArrayDeque<Position> stack = new ArrayDeque<>();
        stack.add(currentPosition);

        while (!stack.isEmpty() || addUnknowns(stack)) {
            Position next = stack.pop();
            if (move(next)) {
                for (Direction dir : directions) {
                    if (dir != currentDirection) {
                        pushIfUnknown(stack, dir);
                    }
                }
                pushIfUnknown(stack, currentDirection);
            }
        }
    }

    private void pushIfUnknown(ArrayDeque<Position> stack, Direction currentDirection) {
        Position next = currentPosition.next(currentDirection);
        if (isPosition(next, UNKNOWN)) {
            stack.push(next);
        }
    }

    private boolean addUnknowns(ArrayDeque<Position> stack) {
        return false;
    }

    private void recognizeWalls() {
        robot.turnLeft();
        boolean moved = true;
        boolean wallsRecognized = false;
        while (!wallsRecognized) {
            if (moved) {
                if (isPosition(currentPosition, CLEANED)) {
                    wallsRecognized = true;
                }
                robot.clean();
                moved = moveForward();
                robot.turnLeft();
            } else {
                markOppositeAsWall();
//                if (allWallsRecognized()) {
//                    wallsRecognized = true;
//                }
                robot.turnRight();
                moved = true;
            }
        }
    }

    private void markOppositeAsWall() {
        Position pos = currentPosition.next(currentDirection);
        matrix[pos.x][pos.y] = BLOCKED;
    }

//    private boolean allWallsRecognized() {
//        Position start = currentPosition.next(direction);
//        return findNextWall(start).equals(start);
//    }

//    private Position findNextWall(Position start) {
//        for (Direction direction : directions) {
//            Position next = start.next(direction);
//            if (isPositing(next, BRICK)) {
//                return findNextWall(next);
//            }
//        }
//        return null;
//    }

    private boolean moveForward() {
        Position next = currentPosition.next(currentDirection);
        return move(next);
    }

    private boolean move(Position pos) {
        //move // probably Dijkstra
        //find adjacencies not unknown and add to queue
        //move by circle
        //or move by vertices
        tryClean(pos);
        boolean move = robot.move();
        if (move) {
            currentPosition = pos;
        }
        return move;
    }

    private void tryClean(Position pos) {
        if (!isPosition(pos, CLEANED)) {
            robot.clean();
            setPosition(pos, CLEANED);
        }
    }

    private boolean isPosition(Position pos, int state) {
        return matrix[pos.x][pos.y] == state;
    }

    private void setPosition(Position pos, int state) {
        matrix[pos.x][pos.y] = state;
    }

}

enum Direction {
    UP, RIGHT, DOWN, LEFT;

    final static List<Direction> directions = List.of(UP, RIGHT, DOWN, LEFT);
}

class Position {
    final int x;
    final int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Position of(int x, int y) {
        return new Position(x, y);
    }

    public Position next(Direction direction) {
        if (direction == Direction.UP) {
            return of(x, y + 1);
        } else if (direction == Direction.DOWN) {
            return of(x, y - 1);
        } else if (direction == Direction.RIGHT) {
            return of(x + 1, y);
        } else {
            return of (x - 1, y);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

interface Robot {
    // returns true if next cell is open and robot moves into the cell.
    // returns false if next cell is obstacle and robot stays on the current cell.
    boolean move();

    // Robot will stay on the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();
    void turnRight();

    // Clean the current cell.
    void clean();

}
