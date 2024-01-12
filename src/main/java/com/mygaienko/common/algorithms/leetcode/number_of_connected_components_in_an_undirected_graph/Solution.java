package com.mygaienko.common.algorithms.leetcode.number_of_connected_components_in_an_undirected_graph;

import java.util.Arrays;

class Solution {

    public int countComponents(int n, int[][] edges) {

        var uf = new UnionFind(n);
        for (var edge : edges) {
            uf.connect(edge[0], edge[1]);
        }
        return uf.count();
    }

    class UnionFind {

        int[] root;
        int[] rank;
        int size;

        UnionFind(int n) {
            this.size = n;
            root = new int[n];
            rank = new int[n];
            Arrays.fill(rank, 1);
            for (int i = 0; i < root.length; i++) {
                root[i] = i;
            }
        }

        void connect(int a, int b) {
            var rootA = root(a);
            var rootB = root(b);

            if (isConnected(a, b)) {
                return;
            }

            if (rank[rootA] > rank[rootB]) {
                root[rootB] = rootA;
                rank[rootA]++;
            } else {
                root[rootA] = rootB;
                rank[rootB]++;
            }
            size--;
        }

        int root(int a) {
            if (root[a] == -1) {
                return a;
            }

            if (root[a] != a) {
                root[a] = root(root[a]);
            }
            return root[a];
        }

        boolean isConnected(int a, int b) {
            return root(a) == root(b);
        }

        int count() {
            return size;
        }
    }
}
