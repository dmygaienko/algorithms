package com.mygaienko.common.algorithms.leetcode.minimum_height_trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 */
class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges == null || edges.length == 0) return List.of(0);
        if (edges.length == 1) return List.of(edges[0][0], edges[0][1]);

        Set<Integer>[] adj = new Set[n];

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            if (adj[from] == null) adj[from] = new HashSet<>();
            adj[from].add(to);

            if (adj[to] == null) adj[to] = new HashSet<>();
            adj[to].add(from);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < adj.length; i++) {
            Set<Integer> neighbours = adj[i];
            if (neighbours != null && neighbours.size() == 1) {
                queue.offer(i);
            }
        }

        int round = queue.size();

        while (n > 1 && round > 0) {
            Integer next = queue.poll();

            Set<Integer> neighbours = adj[next];
            if (neighbours != null) {
                for (Integer neighbour : neighbours) {
                    Set<Integer> neighAdjs = adj[neighbour];

                    if (neighAdjs != null) {
                        neighAdjs.remove(next);

                        if (neighAdjs.size() == 1) {
                            queue.offer(neighbour);
                        }
                    }
                }
            }

            n--; round--;
            if (round == 0 && n > 2) {
                round = queue.size();
            }

        }

        return new ArrayList<>(queue);
    }
}