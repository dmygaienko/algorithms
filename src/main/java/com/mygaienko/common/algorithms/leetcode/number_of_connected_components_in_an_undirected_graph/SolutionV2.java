package com.mygaienko.common.algorithms.leetcode.number_of_connected_components_in_an_undirected_graph;

import java.util.ArrayList;
import java.util.List;

public class SolutionV2 {

    public int countComponents(int n, int[][] edges) {
        var adjLists = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            adjLists.add(new ArrayList<>());
        }
        for (var edge : edges) {
            adjLists.get(edge[0]).add(edge[1]);
            adjLists.get(edge[1]).add(edge[0]);
        }

        var count = 0;
        var visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adjLists, visited);
            }

        }

        return count;
    }

    private void dfs(int i, List<List<Integer>> adjLists, boolean[] visited) {
        if (visited[i]) return;
        visited[i] = true;

        var adjList = adjLists.get(i);
        for (var neigh : adjList) {
            dfs(neigh, adjLists, visited);
        }
    }

}
