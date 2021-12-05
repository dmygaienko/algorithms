package com.mygaienko.common.algorithms.leetcode.number_of_islands;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 *
 * https://dou.ua/lenta/articles/union-find/
 */
class Solution {

    static final char LAND = '1';

    public int numIslands(char[][] grid) {
        Point[][] union = new Point[grid.length][grid[0].length];
        Set<Point> roots = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                Point current = Point.of(i, j);
                char c = grid[i][j];

                Point adj;
                if (c == LAND) {
                    boolean foundAny = false;
//                    if (j - 1 >= 0) {
//                        adj = Point.of(i, j-1);
//                        foundAny = connectIfLand(grid, union, roots, current, adj);
//                    }

                    if (j + 1 < grid[i].length) {
                        adj =  Point.of(i,j+1);
                        foundAny = connectIfLand(grid, union, roots, current, adj);
                    }

//                    if (i - 1 >= 0) {
//                        adj = Point.of(i-1, j);
//                        foundAny = connectIfLand(grid, union, roots, current, adj) || foundAny;
//                    }

                    if (i + 1 < grid.length) {
                        adj = Point.of(i+1, j);
                        foundAny = connectIfLand(grid, union, roots, current, adj) || foundAny;
                    }

                    if (!foundAny && union[current.x][current.y]==null) {
                        add(roots, current);
                    }
                }
            }
        }
        return roots.size();
    }

    private boolean connectIfLand(char[][] grid, Point[][] union, Set<Point> roots, Point current, Point adj) {
        char c = grid[adj.x][adj.y];
        if (c == LAND) {
            connect(union, roots, current, adj);
            return true;
        } else {
            return false;
        }
    }

    private void connect(Point[][] union, Set<Point> roots, Point current, Point adj) {
        Point rootC = root(union, current);
        Point rootA = root(union, adj);

        if (rootC.equals(rootA)) {
            return;
        }

        if (!rootA.equals(adj)) { // big island A
            add(roots, rootA);
            remove(roots, rootC);
            union[rootC.x][rootC.y] = rootA;
        } else { // big island C
            add(roots, rootC);
            remove(roots, rootA);
            union[rootA.x][rootA.y] = rootC;
        }
    }

    private void remove(Set<Point> roots, Point current) {
        roots.remove(current);
    }

    private void add(Set<Point> roots, Point adj) {
        roots.add(adj);
    }

    private Point root(Point[][] union, Point point) {
        Point next = point;
        while (union[next.x][next.y] != null && !next.equals(union[next.x][next.y])) {
            next = union[next.x][next.y];
        }
        return next;
    }

    static class Point {
        int x;
        int y;

        static Point of (int x, int y) {
            return new Point(x, y);
        }

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}
