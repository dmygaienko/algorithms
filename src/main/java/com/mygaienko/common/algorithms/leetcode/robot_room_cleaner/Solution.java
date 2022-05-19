package com.mygaienko.common.algorithms.leetcode.robot_room_cleaner;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

    public void cleanRoom(Robot robot) {
        new SmartRobot(robot).cleanRoom();
    }

}

class SmartRobot {
    private static final int UNKNOWN = 1;
    private static final int CLEANED = 2;
    private static final int BLOCKED = 0;

    private final int[][] matrix = new int[200][400];

    private final Robot robot;

    static final int minX = 0; // out wall positions, should be narrowed
    static final int maxX = 199;

    static final int minY = 0; // out wall positions, should be narrowed
    static final int maxY = 399;

    private int cleans = 0;

    Position currentPosition = Position.of(100, 200);
    Direction currentDirection = Direction.UP;

    public SmartRobot(Robot robot) {
        this.robot = robot;
        for (int[] ints : matrix) {
            Arrays.fill(ints, UNKNOWN);
        }
    }

    public void cleanRoom() {
        doClean();
    }

    private void doClean() {
        ArrayDeque<Position> stack = new ArrayDeque<>();
        stack.add(currentPosition);
        tryClean(currentPosition);

        while (!stack.isEmpty()) {
            Position next = stack.pop();
            if (isNearest(next)) {
                if (next.equals(currentPosition) || move(next)) {
                    Direction direction = currentDirection;
                    for (int i = 0; i < 4; i++) {
                        pushIfUnknown(stack, direction);
                        direction = direction.next();
                    }
                }
            } else {
                addShortestPathToStack(next, stack);
            }
        }
    }

    private void addShortestPathToStack(Position target, ArrayDeque<Position> stack) {
        // System.out.println("addShortestPathToStack - target: " + target);
        Map<Position, Integer> values = new HashMap<>();
        Map<Position, Position> minPathPrevPos = new HashMap<>();

        ArrayDeque<PositionPath> sStack = new ArrayDeque<>();
        sStack.push(new PositionPath(currentPosition, currentPosition, 0));

        boolean found = false;
        while (!sStack.isEmpty() && !found) {
            PositionPath next = sStack.pop();
            Position nextPos = next.position;
             System.out.println("popped nextPos: " + nextPos);

            int adjValue = next.val + 1;

            PriorityQueue<PositionPath> queue = new PriorityQueue<>(4);

            Direction direction = currentDirection;
            for (int i = 0; i < 4; i++, direction = direction.next()) {
                Position adjPos = nextPos.next(direction);

                if (adjPos == null) {
//                     System.out.println("skipping adjPos null");
                    continue;
                } else if (isPosition(adjPos, BLOCKED))  {
//                     System.out.println("skipping adjPos as BLOCKED: " + adjPos);
                    continue;
                } else if (isPosition(adjPos, UNKNOWN) && !adjPos.equals(target)) {
//                     System.out.println("skipping adjPos as UNKNOWN but not target: " + adjPos);
                    continue;
                }

                Integer value = values.get(adjPos);
                if (value == null || value >= adjValue) {
                    values.put(adjPos, adjValue);
                    if (adjPos != nextPos) {
//                         System.out.println("minPathPrevPos.put(adjPos, nextPos); " + adjPos + " , " + nextPos);
                        minPathPrevPos.put(adjPos, nextPos);

                        if (adjPos.equals(target)) {
//                            System.out.println("found = true" + target);
                            found = true;
                            break;
                        }
                    }
                    queue.offer(new PositionPath(target, adjPos, adjValue));
//                    System.out.println("queue after offer: " + queue);
                }
            }

//             System.out.println("sStack: " + sStack);
//             System.out.println("queue: " + queue);
            while (!queue.isEmpty() && !found) {
                sStack.push(queue.poll());
            }
//             System.out.println("sStack: " + sStack);
//             System.out.println("queue: " + queue);
        }

//        System.out.println("Finishing: addShortestPathToStack" + target + " from currentPosition: " + currentPosition);
//        System.out.println("Finishing: values.get(target)" + values.get(target));
        if (found) {
            addToStack(target, minPathPrevPos, stack);
        }
    }

    private void addToStack(Position target, Map<Position, Position> minPathPrevPos, ArrayDeque<Position> stack) {
        // System.out.println("AddToStack: " + target);
        Position prevPos = target;
        while (prevPos != currentPosition) {
            stack.push(prevPos);
            prevPos = minPathPrevPos.get(prevPos);
        }
        // System.out.println("Stack: " + stack);
    }

    private boolean isNearest(Position nextPosition) {
        if (nextPosition.equals(currentPosition)) return true;

        Direction direction = currentDirection;

        boolean result = false;
        int i = 0;
        for (; i < 4; i++) {
            Position next = currentPosition.next(direction);
            if (next != null && next.equals(nextPosition)) {
                currentDirection = direction;
                result = true;
                break;
            }
            direction = direction.next();
        }

        while (result && i > 0) {
            robot.turnRight();
            i--;
        }

        return result;
    }

    private void pushIfUnknown(ArrayDeque<Position> stack, Direction direction) {
        Position next = currentPosition.next(direction);
        if (next != null && isPosition(next, UNKNOWN)) {
            stack.push(next);
//            System.out.println("pushIfUnknown: " + next);
        }
    }

    private boolean move(Position pos) {
        boolean move = robot.move();
        if (move) {
            // System.out.println("moved: " + pos);
            currentPosition = pos;
            tryClean(pos);
        } else {
            setPosition(pos, BLOCKED);
            // System.out.println("setPosition(pos, BLOCKED): " + pos);
        }
        return move;
    }

    private void tryClean(Position pos) {
        if (isPosition(pos, UNKNOWN)/*|| !isPosition(pos, BLOCKED)*/) {
            robot.clean();
            System.out.println("robot.clean():" + (++cleans) + " pos:" + pos);
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

    UP {
        Direction next() {
            return RIGHT;
        }
    }, RIGHT {
        Direction next() {
            return DOWN;
        }
    }, DOWN {
        Direction next() {
            return LEFT;
        }
    }, LEFT {
        Direction next() {
            return UP;
        }
    };

    final static List<Direction> directions = List.of(UP, RIGHT, DOWN, LEFT);

    abstract Direction next();

}

class Position {
    final int x;
    final int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Position of(int x, int y) {
        return x >= SmartRobot.minX &&
                x < SmartRobot.maxX &&
                y >= SmartRobot.minY &&
                y < SmartRobot.maxY
                ? new Position(x, y)
                : null;
    }

    public Position next(Direction direction) {
        if (direction == Direction.UP) {
            return of(x - 1, y);
        } else if (direction == Direction.DOWN) {
            return of(x + 1, y);
        } else if (direction == Direction.RIGHT) {
            return of(x, y + 1);
        } else { // Direction.LEFT
            return of(x, y - 1);
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

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class PositionPath implements Comparable<PositionPath> {
    final Position position;
    final int val;
    final int distToTarget;

    public PositionPath(Position target, Position position, int val) {
        this.position = position;
        this.val = val;
        this.distToTarget = (int) Math.sqrt(Math.pow(target.x - position.x, 2) + Math.pow(target.y - position.y, 2));
    }

    @Override
    public int compareTo(PositionPath other) {
        int cDist = other.distToTarget - this.distToTarget;
        int cVal = other.val - this.val;
        return cDist != 0 ? cDist : cVal;
    }

    @Override
    public String toString() {
        return "PositionPath{" +
                "position=" + position +
                ", val=" + val +
                ", distToTarget=" + distToTarget +
                '}';
    }
}
