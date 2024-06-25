package com.mygaienko.common.algorithms.leetcode.max_area_of_island;

import java.util.Arrays;

public class Solution {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        var unionFind = new UnionFind(grid);

        var maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(1, maxArea);
                    for (var dir : dirs) {
                        var nextX = i + dir[0];
                        var nextY = j + dir[1];
                        if (nextX >= 0 && nextX < grid.length &&
                                nextY >= 0 && nextY < grid[0].length &&
                                grid[nextX][nextY] == 1) {
                            var area = unionFind.connect(
                                    getIndex(grid[0].length, i, j),
                                    getIndex(grid[0].length, nextX, nextY));
                            maxArea = Math.max(maxArea, area);
                        }
                    }
                }
            }
        }

        return maxArea;
    }

    int getIndex(int rowLength, int i, int j) {
        return rowLength * i + j;
    }
}

class UnionFind {
    int[] rank;
    int[] root;

    UnionFind(int[][] grid) {
        var length = grid.length * grid[0].length;
        rank = new int[length];
        Arrays.fill(rank, 1);
        root = new int[length];
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
    }

    int find(int a) {
        if (root[a] != a) {
            root[a] = find(root[a]);
        }
        return root[a];
    }

    int connect(int a, int b) {
        var rootA = find(a);
        var rootB = find(b);

        if (rootA == rootB) {
            return rank[rootA];
        }

        if (rank[rootA] > rank[rootB]) {
            root[rootB] = rootA;
            rank[rootA] += rank[rootB];

            return rank[rootA];
        } else {
            root[rootA] = rootB;
            rank[rootB] += rank[rootA];

            return rank[rootB];
        }
    }
}
