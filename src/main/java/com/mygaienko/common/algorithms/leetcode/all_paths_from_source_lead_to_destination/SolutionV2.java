package com.mygaienko.common.algorithms.leetcode.all_paths_from_source_lead_to_destination;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Deque;
import java.util.List;

/**
 * tests are not green
 */
class SolutionV2 {

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int from = edge[0];
            int to = edge[1];
            if (adj[from] == null) adj[from] = new ArrayList<>();
            adj[from].add(to);
        }

        BitSet seen = new BitSet(n);
        BitSet onStack = new BitSet(n);

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(source);
        onStack.set(source);

        while (!stack.isEmpty()) {
            Integer next = stack.pop();
            seen.set(next);

            if (adj[next] != null) {
                for (int neighbour : adj[next]) {
                    if (!seen.get(neighbour)) {
                        stack.push(neighbour);
                        onStack.set(neighbour);
                    } else if (onStack.get(neighbour)) {
                        return false;
                    }
                }
            } else if (next == destination) {
                onStack.clear();
                seen.clear();
            } else { // next != destination
                return false;
            }
        }

        return true;
    }

}
