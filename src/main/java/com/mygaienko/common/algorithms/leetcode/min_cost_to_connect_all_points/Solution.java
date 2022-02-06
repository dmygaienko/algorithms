package com.mygaienko.common.algorithms.leetcode.min_cost_to_connect_all_points;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Kruskal Algorithm = Sort all edges + Union Find
 */
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int N = points.length;

        int minCost = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N && j != i; j++) {
                int dist = Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]);
                int[] edge = new int[]{i, j, dist};
                queue.offer(edge);
            }
        }
        UnionFind unionFind = new UnionFind(N);
        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            if (unionFind.union(next[0], next[1])) {
                minCost += next[2];
            }
        }

        return minCost;
    }

    static class UnionFind {
        int[] root;
        int[] rank;

        public UnionFind(int size) {
            root = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
            }
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                rank[i] = 1;
            }
        }

        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return false;
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootX] = rootY;
                rank[rootY] += 1;
            }
            return true;
        }

        int find(int x) {
            if (root[x] == x) {
                return x;
            }
            return root[x] = find(root[x]);
        }

    }
}
