package com.mygaienko.common.algorithms.leetcode.similar_string_groups;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public int numSimilarGroups(String[] strs) {
        UnionFind unionFind = new UnionFind(strs.length);

        for (int i = 0; i < strs.length; i++) {
            var curr = strs[i];

            for (int j = 0; j < strs.length; j++) {
                if (i == j) continue;
                if (unionFind.isConnected(i, j)) continue;

                var next = strs[j];
                var diff = 0;
                for (int s = 0; s < curr.length(); s++) {
                    if (curr.charAt(s) != next.charAt(s)) {
                        diff++;
                        if (diff > 2) {
                            break;
                        }
                    }
                }
                if (diff <= 2) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.unique();
    }

}

class UnionFind {

    int[] root;
    int[] rank;

    public UnionFind(int size) {
        this.root = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i; //every one has itself as a root
            rank[i] = 1; //with default rank
        }
    }

    public int findRoot(int x) {
        if (x == root[x]) {
            return x;
        }

        root[x] = findRoot(root[x]);
        return root[x];
    }

    public void union(int x, int y) {
        int rootX = findRoot(x);
        int rootY = findRoot(y);

        if (rootX == rootY) return;

        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            root[rootX] = rootY;
        } else {
            root[rootY] = rootX;
            rank[rootX] += 1;
        }
    }

    public boolean isConnected(int x, int y) {
        return findRoot(x) == findRoot(y);
    }

    public int unique() {
        Set<Integer> set = new HashSet<>();
        for (int i : root) {
            set.add(i);
        }
        return set.size();
    }
}
