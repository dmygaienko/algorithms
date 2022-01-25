package com.mygaienko.common.algorithms.leetcode.evaluate_division;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    static final double NOT_FOUND = -1.0;
    static final double FOUND = 1.0;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int N = equations.size();

        UnionFind uf = new UnionFind(N * 2);
        for (int i = 0; i < N; i++) {
            List<String> ab = equations.get(i);
            uf.connect(ab.get(0), ab.get(1), values[i]);
        }

        int M = queries.size();
        double[] results = new double[M];
        for (int i = 0; i < M; i++) {
            List<String> query = queries.get(i);
            results[i] = uf.eval(query.get(0), query.get(1));
        }
        return results;
    }

    static class UnionFind {

        final int[] root;
        final int[] rank;
        final double[] eval;

        final Map<String, Integer> keyToIndex = new HashMap<>();
        int next = 0;

        UnionFind(int l) {
            root = new int[l];
            rank = new int[l];
            eval = new double[l];
            for (int i = 0; i < l; i++) {
                root[i] = i;
            }
            for (int i = 0; i < l; i++) {
                eval[i] = FOUND;
            }
            for (int i = 0; i < l; i++) {
                rank[i] = 1;
            }
        }

        void connect(String keyX, String keyY, double value) {   // x  :   y   = value
            int x = getOrNext(keyX);
            int y = getOrNext(keyY);
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) return;

            if (rank[rootX] > rank[rootY]) {
                boolean isRoot = y == rootX;
                if (rank[rootY] > 1) {
                    if (isRoot) {
                        updateEvals(rootY, rootX, eval[x] * value);
                    } else {
                        double v = eval[x] * value * 1 / eval[y];
                        eval[rootY] = v;
                        updateEvals(rootY, rootX, v);
                    }
                }
                root[rootY] = rootX;
                eval[y] = eval[x] * value;
            } else if (rank[rootX] < rank[rootY]) {
                boolean isRoot = x == rootX;// 1 : value
                if (rank[rootX] > 1) {
                    if (isRoot) {
                        updateEvals(rootX, rootY, eval[y] * 1/value);
                    } else {
                        double v = eval[y] * 1 / value * 1 / eval[x];
                        eval[rootX] = v;
                        updateEvals(rootX, rootY, v);
                    }
                }
                root[rootX] = rootY;
                eval[x] = eval[y] * 1/value;
            } else {
                boolean isRoot = x == rootX;
                if (rank[rootX] > 1) {
                    if (isRoot) {
                        updateEvals(rootX, rootY, eval[y] * 1/value);
                    } else {
                        double v = eval[y] * 1 / value * 1 / eval[x];
                        eval[rootX] = v;
                        updateEvals(rootX, rootY, v);
                    }
                }
                root[rootX] = rootY;
                rank[rootY] += 1;
                eval[x] = eval[y] * 1/value;
            }
        }

        private void updateEvals(int oldRoot, int newRoot, double multiplier) {
            for (int i = 0; i < eval.length; i++) {
                if (root[i] == oldRoot && i != oldRoot) {
                    eval[i] *= multiplier;
                    root[i] = newRoot;
                }
            }
        }

        boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

//        private int find(int x) {
//            if (x == root[x]) {
//                return x;
//            }
//            return root[x] = find(root[x]);
//        }

        private int find(int x) {
           while (root[x] != x) {
               x = root[x];
           }
           return x;
        }

        private Integer getOrNext(String key) {
            return keyToIndex.compute(key, (k, v) -> v == null ? next++ : v);
        }

        private double eval(String keyX, String keyY) {
            Integer x = keyToIndex.get(keyX);
            Integer y = keyToIndex.get(keyY);

            if (x == null || y == null) {
                return NOT_FOUND;
            } else if (x.equals(y)) {
                return FOUND;
            }

            return isConnected(x, y) ? 1/evalToRoot(x) * evalToRoot(y) : NOT_FOUND;
        }

        private double evalToRoot(int x) {
            double result = FOUND;
            while (root[x] != x) {
                result = result * eval[x];
                x = root[x];
            }
            return result;
        }
    }
}
