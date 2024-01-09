package com.mygaienko.common.algorithms.leetcode.tree_diameter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * graph
 * centroid
 */
class Solution {

    // trim the nodes off layer by layer, as if we are peel an "onion" till we reach its core (i.e. centroids)
    public int treeDiameter(int[][] edges) {
        if (edges.length == 0) return 0;
        //put each edge to adjacency map
        var N = 10000;
        var adjMap = new ArrayList<Set<Integer>>(N);
        for (int i = 0; i < N; i++) {
            adjMap.add(new HashSet<>());
        }

        for (var edge : edges) {
            adjMap.get(edge[0]).add(edge[1]);
            adjMap.get(edge[1]).add(edge[0]);
        }

        // find the outer most nodes, i.e. leaf nodes
        var leaves = new ArrayList<Integer>();
        for (int vertex = 0; vertex < adjMap.size(); ++vertex) {
            if (adjMap.get(vertex).size() == 1)
                leaves.add(vertex);
        }

        // "peel" the graph layer by layer,
        // until we have the centroids left.
        var layers = 0;
        var vertexLeft = edges.length + 1;
        while (vertexLeft > 2) {
            vertexLeft -= leaves.size();

            var nextLeaves = new ArrayList<Integer>();
            for (int leaf : leaves) {

                for (var neigh : adjMap.get(leaf)) {
                    var adjList = adjMap.get(neigh);
                    adjList.remove(leaf);
                    if (adjList.size() == 1) {
                        nextLeaves.add(neigh);
                    }
                }
            }

            leaves = nextLeaves;
            layers++;
        }

        if (vertexLeft == 1) {
            return layers * 2;
        } else {
            return layers * 2 + 1;
        }
    }
}
