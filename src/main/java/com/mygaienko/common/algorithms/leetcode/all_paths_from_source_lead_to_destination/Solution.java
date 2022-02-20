package com.mygaienko.common.algorithms.leetcode.all_paths_from_source_lead_to_destination;

import java.util.*;

class Solution {

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List[] adj = new List[n];
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int from = edge[0];
            int to = edge[1];
            if (from == to) {
                return false;
            }
            if (adj[from] == null) adj[from] = new ArrayList<>();
            adj[from].add(to);
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(source);

        BitSet seen = new BitSet(n);

        while(!stack.isEmpty()) {
            Integer next = stack.pop();
            if (next == destination && adj[next]==null) {
                seen.clear();
                continue;
            }

            if (seen.get(next)) return false;
            seen.set(next);

            if (adj[next]==null) {
                return false;
            } else {
                for (Object neighbor : adj[next]) {
                    stack.push((Integer) neighbor);
                }
            }
        }

        return true;
    }

}
