package com.mygaienko.common.algorithms.leetcode.optimize_water_distribution_in_a_village;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Find minimum spanning tree
 * Kruskal's Algorithm with Union-Find
 */
class Solution {
    // add house to priority queue due to its cost to connect pipe/building wells
    // iterate over queue and connect house with union find
    // if house is not connected increase total cost
    // if system is not connected proceed iterating queue:
    //       quantity of wells should be equal to quantity of roots)
    //       all houses should be connected (either to systems or wells)
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        var list = new ArrayList<int[]>();

        for (var pipe : pipes) {
            list.add(pipe);
        }

        for (int i = 0; i < wells.length; i++) {
            list.add(new int[]{0, i + 1, wells[i]});
        }

        list.sort((a, b) -> a[2] - b[2]);

        var unionFind = new UnionFind(n + 1);
        var total = 0;
        for (var next : list) {

            if (unionFind.connect(next[0], next[1])) {
                total += next[2];
            }

        }

        return total;
    }

    class UnionFind {

        int[] roots;
        int[] ranks;

        int totalCost;

        UnionFind(int n) {
            roots = new int[n];
            for (int i = 1; i < roots.length; i++) {
                roots[i] = i;
            }
            ranks = new int[n];
            Arrays.fill(ranks, 1);
        }

        boolean connect(int a, int b) {
            var rootA = findRoot(a);
            var rootB = findRoot(b);

            if (rootA == rootB) return false;

            if (ranks[rootA] > ranks[rootB]) {
                roots[rootB] = rootA;
            } else if (ranks[rootA] < ranks[rootB]) {
                roots[rootA] = rootB;
            } else {
                roots[rootB] = rootA;
                ranks[rootA] += 1;
            }
            return true;
        }

        int findRoot(int a) {
            if (roots[a] != a) {
                roots[a] = findRoot(roots[a]);
            }
            return roots[a];
        }

    }
}