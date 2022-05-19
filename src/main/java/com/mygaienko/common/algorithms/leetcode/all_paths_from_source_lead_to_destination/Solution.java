package com.mygaienko.common.algorithms.leetcode.all_paths_from_source_lead_to_destination;

import java.util.*;

class Solution {

    int NOT_PROCESSED = -1;
    int PROCESSING = 0;
    int PROCESSED = 1;

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int from = edge[0];
            int to = edge[1];
            if (adj[from] == null) adj[from] = new ArrayList<>();
            adj[from].add(to);
        }

        int[] state = new int[n];
        Arrays.fill(state, NOT_PROCESSED);
        return leadsToDestination(state, adj, source, destination);
    }

    public boolean leadsToDestination(int[] state, List<Integer>[] adj, int source, int destination) {
        if (state[source] != NOT_PROCESSED) return state[source] == PROCESSED; // loop detected
        if (adj[source] == null || adj[source].isEmpty()) return source == destination;

        state[source] = PROCESSING;
        for (Integer neighbour : adj[source]) {
            if (!leadsToDestination(state, adj, neighbour, destination)) {
                return false;
            }
        }

        state[source] = PROCESSED;
        return true;
    }

}
