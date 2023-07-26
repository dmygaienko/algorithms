package com.mygaienko.common.algorithms.leetcode.surrounded_regions;

class Solution {

    public void solve(char[][] board) {
        // for each cell in matrix try to connect to nearest unions
        // if cell surrounded by 'O' or 'X' then cell is ready to be capture
        // if cell is on the edge then cell is not availablle for capturing

        // after full scan capture all available regions

        // if parent cell captured then us should be captured as well
    }

}

class UnionFind {


    void connect(int x1, int y1, int x2, int y2) {
        getRoot(x1, y1);
        getRoot(x2, y2);
    }

    private int[] getRoot(int x1, int y1) {
        return new int[0];
    }

}
