package com.mygaienko.common.algorithms.leetcode.tree_diameter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class SolutionV2 {

    // put each edge to adjacency map
    // and calculate inputs
    // add edges with low inputs to priority queue with low priority
    // while open new edge, check whether exists already any opening before
    // sum if exist
    public int treeDiameter(int[][] edges) {
        if (edges.length == 0) return 0;
        //put each edge to adjacency map
        var N = 10000;
        var adjMap = new ArrayList<List<Integer>>(N);
        for (int i = 0; i < N; i++) {
            adjMap.add(new ArrayList<>());
        }
        for (var edge : edges) {
            adjMap.get(edge[0]).add(edge[1]);
            adjMap.get(edge[1]).add(edge[0]);
        }

        var from = 0;
        for (int i = 0; i < adjMap.size(); i++) {
            var list = adjMap.get(i);
            if (list.size() == 1) {
                from = i;
                break;
            }
        }
        // find longest path from any A to B
        var res = bfs(adjMap, from);
        // then longest path from B will be the tree diameter
        return bfs(adjMap, res[0])[1];
    }

    private static int[] bfs(ArrayList<List<Integer>> adjMap, int start) {
        var maxLength = 0;
        var maxTo = 0;

        var visited = new boolean[adjMap.size()];

        var queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{start, 0});

        while (!queue.isEmpty()) {
            var next = queue.poll();
            var from = next[0];
            var length = next[1];

            if (visited[from]) continue;
            visited[from] = true;

            if (maxLength < length) {
                maxLength = length;
                maxTo = from;
            }

            for (var adj : adjMap.get(from)) {
                if (!visited[adj]) {
                    queue.offer(new int[]{adj, length + 1});
                }
            }
        }
        return new int[]{maxTo, maxLength};
    }
}
