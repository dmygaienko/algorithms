package com.mygaienko.common.algorithms.leetcode.walls_and_gates;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    private static final int GATE = 0;

    public void wallsAndGates(int[][] rooms) {
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                int next = rooms[i][j];
                if (next ==  GATE) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            if (rooms[x][y] > distance) {
                rooms[x][y] = distance;
            }

            int nextDistance = distance + 1;

            if (x - 1 >= 0 && rooms[x - 1][y] > nextDistance) {
                queue.offer(new int[]{x - 1, y, nextDistance});
            }

            if (x + 1 < rooms.length && rooms[x + 1][y] > nextDistance) {
                queue.offer(new int[]{x + 1, y, nextDistance});
            }

            if (y - 1 >= 0 && rooms[x][y - 1] > nextDistance) {
                queue.offer(new int[]{x, y - 1, nextDistance});
            }

            if (y + 1 < rooms[0].length && rooms[x][y + 1] > nextDistance) {
                queue.offer(new int[]{x, y + 1, nextDistance});
            }
        }
    }

}