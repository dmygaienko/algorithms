package com.mygaienko.common.algorithms.leetcode.graph_valid_tree;

import java.util.Arrays;

class Solution {

    public boolean validTree(int n, int[][] edges) {
        int N = edges.length;

        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < N; i++) {
            int[] edge = edges[i];
            if (!unionFind.union(edge[0], edge[1])) {
                return false;
            }
        }
        return unionFind.getCount() == 1;
    }

    static class UnionFind {
        final int[] roots;
        final int[] rank;
        int count;

        public UnionFind(int size) {
            count = size;
            roots = new int[size];
            for (int i = 0; i < size; i++) {
                roots[i] = i;
            }
            rank = new int[size];
            Arrays.fill(rank, 1);
        }

        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (roots[rootX] != roots[rootY]) {
                if (rank[rootX] > rank[rootY]) {
                    roots[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    roots[rootX] = rootY;
                } else {
                    roots[rootX] = rootY;
                    rank[rootX] += 1;
                }
                count--;
            } else {
                return false;
            }

            return true;
        }

        int find(int x) {
            if (roots[x] == x) {
                return x;
            }
            return roots[x] = find(roots[x]);
        }

        public int getCount() {
            return count;
        }
    }
}
