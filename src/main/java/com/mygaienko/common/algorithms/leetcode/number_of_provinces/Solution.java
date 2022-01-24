package com.mygaienko.common.algorithms.leetcode.number_of_provinces;



class Solution {

    int CONNECTED = 1;

    public int findCircleNum(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        UnionFind unionFind = new UnionFind(M);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (CONNECTED == matrix[i][j]) {
                    unionFind.union(i, j);
                }
            }
        }

        return unionFind.getUniqueRoots();
    }

    static class UnionFind {

        private final int[] root;
        private final int[] rank;

        int rootsCount;

        UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            rootsCount = size;
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                rootsCount--;
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootY] > rank[rootX]) {
                    root[rootX] = rootY;
                } else {
                    root[rootX] = rootY;
                    rank[rootY] += 1;
                }
            }
        };

        boolean connected(int x, int y) {
            return find(x) == find(y);
        };

        public int getUniqueRoots() {
            return rootsCount;
        }

    }
}
