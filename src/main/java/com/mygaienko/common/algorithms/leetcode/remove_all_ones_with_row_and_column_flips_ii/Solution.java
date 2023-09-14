package com.mygaienko.common.algorithms.leetcode.remove_all_ones_with_row_and_column_flips_ii;

import java.util.*;

class Solution {

    private static final int ONE = 1;
    private static final int ZERO = 0;
    private static final int REMOVED = -1;

    int min = Integer.MAX_VALUE;
    int removed = 0;
    int count = 0;

    public int removeOnes(int[][] grid) {
        List<Point> points = findPoints(grid);
        findMin(grid, points, 1);
        return count == 0 ? count : min;
    }

    private List<Point> findPoints(int[][] grid) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == ONE) {
                    points.add(Point.of(i, j));
                    count++;
                }
            }
        }
        return points;
    }

    private void findMin(int[][] grid, List<Point> points, int steps) {
        if (min <= steps) return;

        for (var p : points) {
            if (grid[p.i][p.j] == ONE) {
                int marker = REMOVED * steps;
                remove(grid, p, marker);
                if (removed == count) {
                    min = Math.min(min, steps);
                } else {
                    findMin(grid, points, steps + 1);
                }
                rollBack(grid, p, marker);
            }
        }

    }

    private void remove(int[][] grid, Point p, int marker) {
        removeInRow(grid, p, marker);
        removeInColumn(grid, p, marker);
    }

    private void removeInColumn(int[][] grid, Point p, int marker) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][p.j] == ONE) {
                grid[i][p.j] = marker;
                removed++;
            }
        }
    }

    private void removeInRow(int[][] grid, Point p, int marker) {
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[p.i][j] == ONE) {
                grid[p.i][j] = marker;
                removed++;
            }
        }
    }

    private void rollBack(int[][] grid, Point p, int marker) {
        rollBackRow(grid, p, marker);
        rollbackColumn(grid, p, marker);
    }

    private void rollBackRow(int[][] grid, Point p, int marker) {
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[p.i][j] == marker) {
                grid[p.i][j] = ONE;
                removed--;
            }
        }
    }

    private void rollbackColumn(int[][] grid, Point p, int marker) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][p.j] == marker) {
                grid[i][p.j] = ONE;
                removed--;
            }
        }
    }

    private TreeSet<Point> reverse(Map<Point, Integer> neighs, Map<Point, Point> bimap) {
        var treeSet = new TreeSet<>(Comparator.comparingInt(Point::getWeight)
                .thenComparing(Point::getI)
                .thenComparing(Point::getJ));
        for (var entry : neighs.entrySet()) {
            entry.getKey().weight = entry.getValue();
            treeSet.add(entry.getKey());
            bimap.put(entry.getKey(), entry.getKey());
        }
        return treeSet;
    }

    private void accumulateRows(int[][] grid, Map<Point, Integer> neighs) {
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            List<Integer> rowOnes = new ArrayList<>();
            for (int j = 0; j < row.length; j++) {
                if (row[j] == ONE) {
                    count++;
                    rowOnes.add(j);
                }
            }

            if (!rowOnes.isEmpty()) {
                for (Integer j : rowOnes) {
                    neighs.put(Point.of(i, j), rowOnes.size());
                }
            }

        }
    }

    private void accumulateColumns(int[][] grid, Map<Point, Integer> neighs) {
        if (grid == null || grid[0] == null) return;

        for (int j = 0; j < grid[0].length; j++) {
            List<Integer> columnOnes = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == ONE) {
                    columnOnes.add(i);
                }
            }

            if (columnOnes.size() > 1) {
                int columnOnesSize = columnOnes.size() - 1;
                for (Integer i : columnOnes) {
                    neighs.compute(Point.of(i, j), (k, v) -> v == null ? columnOnesSize : v + columnOnesSize);
                }
            }
        }
    }

    static class Point {
        int i;
        int j;
        int weight;


        static Point of(int i, int j) {
            Point point = new Point();
            point.i = i;
            point.j = j;
            return point;
        }

        static Point of(int i, int j, int weight) {
            Point point = new Point();
            point.i = i;
            point.j = j;
            point.weight = weight;
            return point;
        }

        static Point of(Point p) {
            Point point = new Point();
            point.i = p.i;
            point.j = p.j;
            point.weight = p.weight;
            return point;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return i == point.i &&
                    j == point.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        public int getWeight() {
            return weight;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "i=" + i +
                    ", j=" + j +
                    ", weight=" + weight +
                    '}';
        }
    }

}
