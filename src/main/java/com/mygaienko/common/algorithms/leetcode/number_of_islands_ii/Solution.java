package com.mygaienko.common.algorithms.leetcode.number_of_islands_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * 305. Number of Islands II https://leetcode.com/problems/number-of-islands-ii/
 */
class Solution {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> islandsPerStep = new ArrayList<>();
        UnionFinder unionFinder = new UnionFinder(m, n);
        for (int i = 0; i < positions.length; i++) {
            int[] position = positions[i];
            int islands = unionFinder.turn(position[0], position[1]);
            islandsPerStep.add(islands);
        }
        return islandsPerStep;
    }

    static class UnionFinder {
        private final int m;
        private final int n;

        private final Point[][] grid;

        private int islands = 0;

        public UnionFinder(int m, int n) {
            this.m = m;
            this.n = n;
            grid = new Point[m][n];
        }

        public int turn(int x, int y) {
            Point turned = Point.of(x, y);
            if (grid[x][y] != null) return islands;
            grid[x][y] = turned;

            ++islands;

            Point adj;
            if (x - 1 >= 0) {
                adj = grid[x - 1][y];
                if (adj != null) {
                    connect(turned, adj);
                }
            }

            if (x + 1 < m) {
                adj = grid[x + 1][y];
                if (adj != null) {
                    connect(turned, adj);
                }
            }

            if (y - 1 >= 0) {
                adj = grid[x][y - 1];
                if (adj != null) {
                    connect(turned, adj);
                }
            }

            if (y + 1 < n) {
                adj = grid[x][y + 1];
                if (adj != null) {
                    connect(turned, adj);
                }
            }

            return islands;
        }

        private void connect(Point turned, Point adj) {
            Point rootT = root(turned);
            Point rootA = root(adj);

            if (!rootT.equals(rootA)) {
                grid[rootT.x][rootT.y] = rootA;
                --islands;
            }
        }

        private Point root(Point turned) {
            Point next = turned;
            while (grid[next.x][next.y] != null && !next.equals(grid[next.x][next.y])) {
                next = grid[next.x][next.y];
            }
            return next;
        }

    }

    static class Point {
        private final int x;
        private final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        static Point of(int x, int y) {
            return new Point(x, y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
