package com.mygaienko.common.algorithms.leetcode.earliest_moment_everyone_become_friends;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    private static final int NOT_FOUND = -1;

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        Arrays.sort(nums, (n1, n2) -> apply(n1, a, b, c) - apply(n2, a, b, c));
        return nums;
    }

    private int apply(Integer n, int a, int b, int c) {
        return 0;
    }

    public int earliestAcq(int[][] logs, int n) {


        Arrays.sort(logs, Comparator.comparingInt(log -> log[0]));
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < logs.length; i++) {
            int[] log = logs[i];
            int time = log[0];
            int x = log[1];
            int y = log[2];
            if (unionFind.union(x, y)) {
                return time;
            }
        }
        return NOT_FOUND;
    }

    static class UnionFind {
        private final int[] roots;
        private final int[] rank;
        private int count;

        public UnionFind(int size) {
            this.count = size;
            roots = new int[size];
            for (int i = 0; i < size; i++) {
                roots[i] = i;
            }
            rank = new int[size];
            Arrays.fill(rank, 1);
        }

        int find(int x) {
            if (roots[x] == x) {
                return x;
            }
            return roots[x] = find(roots[x]);
        }

        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (roots[rootX] != roots[rootY]) {
                count--;

                if (rank[rootX] > rank[rootY]) {
                    roots[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    roots[rootX] = rootY;
                } else {
                    roots[rootX] = rootY;
                    rank[rootX] += 1;
                }
            }

            return count == 1;
        }

    }
}
