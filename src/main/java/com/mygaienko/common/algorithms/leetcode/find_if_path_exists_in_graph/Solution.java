package com.mygaienko.common.algorithms.leetcode.find_if_path_exists_in_graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int v1 = edge[0];
            int v2 = edge[1];

            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }

        boolean[] seen = new boolean[n];
        Arrays.fill(seen, false);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            Integer next = stack.pop();

            if (next == destination) {
                return true;
            }

            if (seen[next]) continue;
            seen[next] = true;

            List<Integer> neighbours = adjList.get(next);
            for (Integer neighbour : neighbours) {
                stack.push(neighbour);
            }
        }

        return false;
    }

}
