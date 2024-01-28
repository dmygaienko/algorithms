package com.mygaienko.common.algorithms.leetcode.connecting_cities_with_minimum_cost;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Kruskal Algorithm = Sort all edges + Union Find
 */
class Solution {

    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, Comparator.comparingInt(arr -> arr[2]));
        var unionFind = new UnionFind(n + 1);
        var minCost = 0;
        var connected = 0;
        for (var connection : connections) {
            if (unionFind.connect(connection[0], connection[1])) {
                minCost += connection[2];
                connected++;
            }
        }
        return connected + 1 == n ? minCost : -1;
    }

    class UnionFind {
        int[] root;
        int[] rank;

        UnionFind(int n) {
            root = new int[n];
            for (int i = 0; i < root.length; i++) {
                root[i] = i;
            }
            rank = new int[n];
            Arrays.fill(rank, 1);
        }

        boolean connect(int a, int b) {
            var rootA = findRoot(a);
            var rootB = findRoot(b);
            if (rootA == rootB) return false;

            if (rank[rootA] > rank[rootB]) {
                root[rootB] = rootA;
            } else if (rank[rootA] < rank[rootB]) {
                root[rootA] = rootB;
            } else {
                root[rootA] = rootB;
                rank[rootB]++;
            }

            return true;
        }

        int findRoot(int a) {
            if (root[a] == a) {
                return a;
            }

            root[a] = findRoot(root[a]);
            return root[a];
        }
    }
}