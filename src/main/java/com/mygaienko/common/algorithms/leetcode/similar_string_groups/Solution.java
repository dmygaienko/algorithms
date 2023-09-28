package com.mygaienko.common.algorithms.leetcode.similar_string_groups;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

    public int numSimilarGroups(String[] strs) {
        List<Map<Character, Set<Integer>>> strings = new ArrayList();
        for (var s : strs) {
            var charIndex = new HashMap<Character, Set<Integer>>();
            for (int i = 0; i < s.length(); i++) {
                charIndex.computeIfAbsent(s.charAt(i), v -> new LinkedHashSet<>()).add(i);
            }
            strings.add(charIndex);
        }
        return findGroup(strings, strs.length);
    }

    private int findGroup(List<Map<Character, Set<Integer>>> strings, int n) {
        int alone = 0;

        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < strings.size(); i++) {
            var curr = strings.get(i);
            var chars = curr.keySet();
            boolean found = false;

            for (int j = 0; j < strings.size(); j++) {
                if (i == j) continue;
                if (unionFind.isConnected(i, j)) {
                    found = true;
                    continue;
                }

                var next = strings.get(j);
                var diff = 0;
                for (var ch : chars) {
                    if (!curr.get(ch).equals(next.get(ch))) {
                        diff++;
                        if (diff > 2) {
                            break;
                        }
                    }
                }
                if (diff <= 2) {
                    unionFind.union(i, j);
                    found = true;
                }
            }
            if (!found) {
                alone++;
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
