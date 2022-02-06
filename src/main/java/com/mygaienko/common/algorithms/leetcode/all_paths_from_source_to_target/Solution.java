package com.mygaienko.common.algorithms.leetcode.all_paths_from_source_to_target;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int start = 0;
        int end = graph.length - 1;
        return findPathsToTarget(graph, start, end);
    }

    private List<List<Integer>> findPathsToTarget(int[][] graph, int current, int end) {
        List<List<Integer>> paths = new ArrayList<>();
        for (int neigh : graph[current]) {
            List<ArrayDeque<Integer>> stacks = findPathToTarget(graph, neigh, end);
            if (!stacks.isEmpty()) {
                for (ArrayDeque<Integer> stack : stacks) {
                    stack.push(current);
                    paths.add(new ArrayList<>(stack));
                }

            }
        }
        return paths;
    }

    private List<ArrayDeque<Integer>> findPathToTarget(int[][] graph, int current, int end) {
        List<ArrayDeque<Integer>> notEmptyPaths = null;
        for (int neigh : graph[current]) {

            if (neigh == end) {
                ArrayDeque<Integer> stack = new ArrayDeque<>();
                stack.push(neigh);
                return List.of(stack);
            }

            List<ArrayDeque<Integer>> paths = findPathToTarget(graph, neigh, end);
            if (paths != null && !paths.isEmpty()) {
                if (notEmptyPaths == null) {
                    notEmptyPaths = new ArrayList<>();
                }

                for (ArrayDeque<Integer> path : paths) {
                    path.push(current);
                    notEmptyPaths.add(path);
                }

            }
        }
        return notEmptyPaths;
    }

}
