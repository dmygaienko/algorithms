package com.mygaienko.common.algorithms.leetcode.robot_room_cleaner;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * breadth-first
 * failed tests
 */
class SolutionV2 {

    public void cleanRoom(Robot robot) {
        new SmartRobotV2(robot).cleanRoom();
    }

}

class SmartRobotV2 {
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
    Direction currentDirection = Direction.DOWN;

    public SmartRobotV2(Robot robot) {
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
        Map<Position, Integer> values = new HashMap<>();
        Map<Position, Position> minPathPrevPos = new HashMap<>();

        PriorityQueue<PositionPath> queue = new PriorityQueue<>();
        queue.add(new PositionPath(currentPosition, currentPosition, 0));

        while (!queue.isEmpty()) {
            PositionPath next = queue.poll();
            Position nextPos = next.position;

            Integer targetPathValue = values.get(target);
            int adjValue = next.val + 1;
            for (Direction direction : Direction.directions) {
                Position adjPos = nextPos.next(direction);

                if (adjPos == null) {
//                    System.out.println("skipping adjPos null");
                    continue;
                } else if (isPosition(adjPos, BLOCKED))  {
//                    System.out.println("skipping adjPos as BLOCKED: " + adjPos);
                    continue;
                } else if (isPosition(adjPos, UNKNOWN) && !adjPos.equals(target)) {
//                    System.out.println("skipping adjPos as UNKNOWN but not target: " + adjPos);
                    continue;
                }

                Integer value = values.get(adjPos);
                if (value == null || value >= adjValue && (targetPathValue == null || targetPathValue >= adjValue)) {
                    values.put(adjPos, adjValue);
                    if (adjPos != nextPos) {
                        minPathPrevPos.put(adjPos, nextPos);

                        if (adjPos.equals(target)) break;
                    }
                    queue.offer(new PositionPath(target, adjPos, adjValue));
                }
            }
        }

//        System.out.println("Finishing: addShortestPathToStack" + target + " from currentPosition: " + currentPosition);
//        System.out.println("Finishing: values.get(target)" + values.get(target));
        if (values.get(target) != null) {
            addToStack(target, minPathPrevPos, stack);
        }
    }

    private void addToStack(Position target, Map<Position, Position> minPathPrevPos, ArrayDeque<Position> stack) {
//        System.out.println("AddToStack: " + target);
        Position prevPos = target;
        while (prevPos != currentPosition) {
            stack.push(prevPos);
            prevPos = minPathPrevPos.get(prevPos);
        }
//        System.out.println("Stack: " + stack);
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
//            System.out.println("moved: " + pos);
            currentPosition = pos;
            tryClean(pos);
        } else {
            setPosition(pos, BLOCKED);
//            System.out.println("setPosition(pos, BLOCKED): " + pos);
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
