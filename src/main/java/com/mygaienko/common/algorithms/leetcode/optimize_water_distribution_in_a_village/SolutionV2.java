package com.mygaienko.common.algorithms.leetcode.optimize_water_distribution_in_a_village;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;


/**
 * Find minimum spanning tree
 * Prims algorithm
 */
public class SolutionV2 {

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        var queue = new PriorityQueue<Pair<Integer, Integer>>((a, b) -> a.getValue() - b.getValue());

        var adjList = new ArrayList<List<Pair<Integer, Integer>>>();
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (var pipe : pipes) {
            int from = pipe[0];
            int to = pipe[1];
            int cost = pipe[2];
            add(adjList, from, to, cost);
            add(adjList, to, from, cost);
        }

        for (int i = 0; i < wells.length; i++) {
            queue.add(pair(i + 1, wells[i]));
        }

        var total = 0;
        var visited = new HashSet<Integer>();
        while (!queue.isEmpty()) {
            var next = queue.poll();
            var home = next.getKey();
            var cost = next.getValue();

            if (visited.contains(home)) {
                continue;
            }

            visited.add(home);
            total += cost;
            for (var neigh : adjList.get(home)) {
                if (!visited.contains(neigh.getKey())) {
                    queue.offer(neigh);
                }
            }
        }
        return total;
    }

    private void add(ArrayList<List<Pair<Integer, Integer>>> adjList, int from, int to, int cost) {
        var list = adjList.get(from);
        if (list == null) {
            list = adjList.set(from, new ArrayList<>());
        }
        list.add(pair(to, cost));
    }

    Pair<Integer, Integer> pair(int key, int val) {
        return Pair.of(key, val);
    }
}
