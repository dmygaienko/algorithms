package com.mygaienko.common.algorithms.leetcode.longest_incr_path_in_matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * BFS Solution
 */
class SolutionV2 {

    public int longestIncreasingPath(int[][] matrix) {
        Map<Point, List<Point>> adj = new HashMap<>();
        Map<Point, Integer> longestPath = new HashMap<>();
        Map<Point, Integer> toVisit = new HashMap<>();

        int[][] offsets = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int next = matrix[i][j];

                for (int[] offset : offsets) {
                    int adjI = i + offset[0];
                    int adjJ = j + offset[1];

                    Point keyPoint = new Point(i, j, next);
                    toVisit.putIfAbsent(keyPoint, 0);

                    if (adjI > -1 && adjI < matrix.length
                            && adjJ > -1 && adjJ < matrix[adjI].length) {

                        int nextAdj = matrix[adjI][adjJ];

                        if (next > nextAdj) {

                            Point adjPoint = new Point(adjI, adjJ, nextAdj);
                            adj.putIfAbsent(keyPoint, new ArrayList<>());
                            adj.get(keyPoint).add(adjPoint);

                            toVisit.compute(adjPoint, (k, v) -> v == null ? 1 : v + 1);
                        }
                    }
                }
            }
        }

        Queue<Point> queue = new LinkedList<>();
        for (Map.Entry<Point, Integer> e : toVisit.entrySet()) {
            Integer value = e.getValue();
            if (value == 0) {
                queue.offer(e.getKey());
            }
        }

        while (!queue.isEmpty()) {
            Point next = queue.poll();
            int nextPath = longestPath.getOrDefault(next, 1);

            List<Point> adjacents = adj.get(next);

            if (adjacents == null) {
                longestPath.compute(next, (k, v) -> v == null ? nextPath : Math.max(v, nextPath));
                continue;
            }

            for (Point adjacent : adjacents) {
                Integer integer = toVisit.computeIfPresent(adjacent, (k, v) -> v - 1);
                if (integer != null && integer.equals(0)) {
                    queue.offer(adjacent);
                }

                int adjPath = nextPath + 1;
                longestPath.compute(adjacent, (k, v) -> v == null ? adjPath : Math.max(v, adjPath));
            }
        }

        return getMax(longestPath);
    }

    private Integer getMax(Map<Point, Integer> longestPath) {
        return longestPath.values()
                .stream()
                .mapToInt(i -> i)
                .max()
                .orElse(-1);
    }

    static class Point {
        int i;
        int j;
        int value;

        public Point(int i, int j, int v) {
            this.i = i;
            this.j = j;
            this.value = v;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (i != point.i) return false;
            return j == point.j;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "i=" + i +
                    ", j=" + j +
                    ", v=" + value +
                    '}';
        }
    }

}
