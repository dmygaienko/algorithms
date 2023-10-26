package com.mygaienko.common.algorithms.leetcode.robot_bounded_in_circle;


// parse instruction and process in a loop
// add points to hash map, and check whether they are no repeated
class Solution {

    int[][] DIRS = new int[][]{
            {1, 0}, // NORTH
            {0, 1}, // EAST
            {-1, 0}, // SOUTH
            {0, -1} // WEST
    };

    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int dir = 0;

        for (int attempts = 0; attempts < 4; attempts++) {
            for (int i = 0; i < instructions.length(); i++) {
                char ch = instructions.charAt(i);

                if (ch == 'G') {
                    x = x + DIRS[dir][1];
                    y = y + DIRS[dir][0];
                    // if (!points.add(new Pair(x, y))) return true;
                } else if (ch == 'L') {
                    dir = dir - 1 >= 0 ? dir - 1 : DIRS.length - 1;
                } else {
                    dir = dir + 1 < DIRS.length ? dir + 1 : 0;
                }

                if (attempts > 2 && x == 0 && y == 0) return true;
            }
        }

        return false;
    }

}