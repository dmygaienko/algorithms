package com.mygaienko.common.algorithms.leetcode.best_meeting_point;

import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {

    int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // iterate over grid and find all friends
    // from each friend process bfs to reach every cell
    // for each cell calculate visitedFriendsCount and totalVisitedDistance
    // iterate over calculation and find cell where all friends were visited and minimal count
    public int minTotalDistance(int[][] grid) {
        var visitors = new int[grid.length][grid[0].length][2];
        var friends = new ArrayList<int[]>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    friends.add(new int[]{i, j});
                    visitors[i][j][0]++;
                }
            }
        }

        var minDistance = Integer.MAX_VALUE;
        var currFreeCell = 0;
        var currHouseCell = 1;
        for (var friend : friends) {
            var queue = new ArrayDeque<int[]>();
            queue.offer(new int[]{friend[0], friend[1], 0});
            grid[friend[0]][friend[1]]++;

            while (!queue.isEmpty()) {
                var next = queue.poll();

                for (var dir : DIRS) {
                    var nextI = next[0] + dir[0];
                    var nextJ = next[1] + dir[1];
                    var nextDistance = next[2] + 1;

                    if (isValid(nextI, grid.length) && isValid(nextJ, grid[0].length)) {
                        if (grid[nextI][nextJ] == currFreeCell) {
                            grid[nextI][nextJ]--;
                            visitors[nextI][nextJ][0]++;
                            visitors[nextI][nextJ][1] += nextDistance;
                            queue.offer(new int[]{nextI, nextJ, nextDistance});
                        } else if (grid[nextI][nextJ] == currHouseCell) {
                            grid[nextI][nextJ]++;
                            visitors[nextI][nextJ][0]++;
                            visitors[nextI][nextJ][1] += nextDistance;
                            queue.offer(new int[]{nextI, nextJ, nextDistance});
                        }

                        if (visitors[nextI][nextJ][0] == friends.size()) {
                            minDistance = Math.min(minDistance, visitors[nextI][nextJ][1]);
                        }
                    }
                }
            }
            currFreeCell--;
            currHouseCell++;
        }

        return minDistance;
    }

    boolean isValid(int val, int to) {
        return val >= 0 && val < to;
    }
}
