package com.mygaienko.common.algorithms.leetcode.checking_existence_of_edge_length_limited_paths_ii;

import java.util.Arrays;

class DistanceLimitedPathsExist {

    UnionFind uf;

    public DistanceLimitedPathsExist(int n, int[][] edgeList) {
        Arrays.sort(edgeList, (e1, e2) -> e1[2] - e2[2]);
        uf = new UnionFind(n);

        for (var edge : edgeList) {
            uf.connect(edge[0], edge[1], edge[2]);
        }

    }

    public boolean query(int p, int q, int limit) {
        return uf.find(p, limit) == uf.find(q, limit);
    }

    private class UnionFind {

        int[] roots;
        int[] ranks;
        int[] limits;

        public UnionFind(int n) {
            roots = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
            }
            ranks = new int[n];
            Arrays.fill(ranks, 1);
            limits = new int[n];
        }

        public void connect(int p, int q, int limit) {
            var rootP = find(p);
            var rootQ = find(q);

            if (rootP == rootQ) return;

            if (ranks[rootP] > ranks[rootQ]) {
                roots[rootQ] = rootP;
                limits[rootQ] = limit;
            } else if (ranks[rootP] < ranks[rootQ]) {
                roots[rootP] = rootQ;
                limits[rootP] = limit;
            } else {
                roots[rootP] = rootQ;
                ranks[rootQ]++;
                limits[rootP] = limit;
            }
        }

        public int find(int p, int limit) {
            if (roots[p] == p || limits[p] >= limit) {
                return p;
            }

            return find(roots[p], limit);
        }

        public int find(int p) {
            if (roots[p] == p) {
                return p;
            }

            return find(roots[p]);
        }
    }
}