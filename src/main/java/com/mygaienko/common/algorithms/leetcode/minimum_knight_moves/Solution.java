package com.mygaienko.common.algorithms.leetcode.minimum_knight_moves;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {

    public static final int OPP = -1;

    public static final int LONG = 2;
    public static final int SHORT = 1;

    public int minKnightMoves(int x, int y) {
        Position start = new Position();
        Position target = new Position(x, y);
        Map<Position, Integer> moves = new HashMap<>();
        LinkedList<PositionMove> queue = new LinkedList<>();

        PositionDistance positionDistance = calcDist(target, start);
        queue.offer(new PositionMove(positionDistance, 0)); // start

        int result = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            PositionMove currentMove = queue.poll();
            Position current = currentMove.position;

            if (current.equals(target)) {
                result = moves.compute(target, (k, v) -> v == null ? currentMove.move : Math.min(v, currentMove.move));
            } else if (result < currentMove.move) {
                return result;
            }

            int nextMove = currentMove.move + 1;

            List<PositionDistance> neighDistances = new ArrayList<>();
            neighDistances.add(calcDist(target, new Position(current.x + LONG, current.y + SHORT)));
            neighDistances.add(calcDist(target, new Position(current.x + LONG, current.y - SHORT)));
            neighDistances.add(calcDist(target, new Position(current.x - LONG, current.y + SHORT)));
            neighDistances.add(calcDist(target, new Position(current.x - LONG, current.y - SHORT)));

            neighDistances.add(calcDist(target, new Position(current.x - SHORT, current.y + LONG)));
            neighDistances.add(calcDist(target, new Position(current.x - SHORT, current.y - LONG)));
            neighDistances.add(calcDist(target, new Position(current.x + SHORT, current.y + LONG)));
            neighDistances.add(calcDist(target, new Position(current.x + SHORT, current.y - LONG)));

            if (currentMove.distance > 5) {
                PositionDistance closest = null;
                for (PositionDistance neighDistance : neighDistances) {
                    if (closest == null || closest.distance > neighDistance.distance) {
                        closest = neighDistance;
                    }
                }

                if (closest != null) {
                    queue.offer(new PositionMove(closest, nextMove));
                }
            } else {
                neighDistances.forEach(
                        nd -> queue.offer(new PositionMove(nd, nextMove)));
            }
        }

        return moves.getOrDefault(target, 0);
    }

    private PositionDistance calcDist(Position target, Position current) {
        return new PositionDistance(current, Math.sqrt(
                Math.pow(current.x - target.x, 2)  +
                        Math.pow(current.y - target.y, 2)
        ));
    }

    static class PositionDistance {
        Position position;
        double distance;

        public PositionDistance(Position position, double distance) {
            this.position = position;
            this.distance = distance;
        }

        public Position getPosition() {
            return position;
        }

        public double getDistance() {
            return distance;
        }
    }

    static class Position {
        int x = 0;
        int y = 0;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position() {
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

    static class PositionMove {
        Position position;
        double distance;
        int move = 0;

        public PositionMove(PositionDistance pd, int move) {
            this.position = pd.position;
            this.distance = pd.distance;
            this.move = move;
        }

        @Override
        public String toString() {
            return "PositionMove{" +
                    "position=" + position +
                    ", move=" + move +
                    ", distance=" + distance +
                    '}';
        }
    }

}
