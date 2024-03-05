package com.mygaienko.common.algorithms.leetcode.the_maze_iii;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// use dijkstra

// put nearest points to the queue
// introduce visited matrix to keep already visited points
// introduce distance matrix to store minimal path
// introduce paths point -> prevPoint + command;

// if all points visited return impossible
class Solution {

    Map<Character, int[]> dirs = Map.of(
            'u', new int[]{-1, 0},
            'd', new int[]{1, 0},
            'l', new int[]{0, -1},
            'r', new int[]{0, 1}
    );

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int M = maze.length;
        int N = maze[0].length;

        var visited = new boolean[M][N];

        var queue = new PriorityQueue<>(Comparator
                .<Step>comparingInt(a -> a.distance)
                .thenComparing(a -> a.path)
        );

        queue.offer(new Step(ball[0], ball[1]));

        while (!queue.isEmpty()) {
            var curr = queue.poll();

            if (visited[curr.x][curr.y]) continue;
            visited[curr.x][curr.y] = true;

            if (curr.x == hole[0] && curr.y == hole[1]) return curr.path;

            for (var neigh : getNeighbours(maze, curr, hole)) {
                var nextDist = curr.distance + neigh.distance;
                var nextPath = curr.path + neigh.path;
                queue.offer(new Step(neigh.x, neigh.y, nextDist, nextPath));
            }

        }

        return "impossible";
    }

    private List<Step> getNeighbours(int[][] maze, Step curr, int[] hole) {
        var neighbours = new ArrayList<Step>();

        for (var dir : dirs.entrySet()) {
            var command = dir.getKey();
            int[] delta = dir.getValue();
            var x = curr.x;
            var y = curr.y;
            var distance = 0;
            while (isValid(x + delta[0], y + delta[1], maze)) {

                distance++;
                x += delta[0];
                y += delta[1];

                if (x == hole[0] && y == hole[1]) {
                    break;
                }
            }

            if (distance > 0) {
                neighbours.add(new Step(x, y, distance, String.valueOf(command)));
            }
        }
        return neighbours;
    }

    private int distTo(Step step, int[] hole) {
        return Math.abs(step.x - hole[0]) + Math.abs(step.y - hole[1]);
    }

    private boolean isValid(int x, int y, int[][] maze) {
        return 0 <= x && x < maze.length && 0 <= y && y < maze[0].length && maze[x][y] == 0;
    }

    class Step {
        int x;
        int y;
        int distance;
        String path = "";

        public Step(int x, int y) {
            this(x, y, 0, "");
        }

        public Step(int x, int y, int distance, String path) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.path = path;
        }

    }

}