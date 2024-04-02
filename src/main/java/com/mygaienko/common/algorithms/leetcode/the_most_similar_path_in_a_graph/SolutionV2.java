package com.mygaienko.common.algorithms.leetcode.the_most_similar_path_in_a_graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * NOT MEET TIME LIMIT
 */
class SolutionV2 {
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPathStr) {
        var targetPath = toTargetPath(names, targetPathStr);
        var adjList = getAdjList(n, roads);

        var minEditDistance = Integer.MAX_VALUE;
        List<Integer> minPath = new ArrayList<>();

        var queue = new PriorityQueue<Path>(Comparator
                .comparing(Path::getSize, Comparator.reverseOrder())
                .thenComparing(Path::getEditDistance));
        for (int i = 0; i < adjList.size(); i++) {
            if (!adjList.get(i).isEmpty()) {
                var editDistance = targetPath.get(0).contains(i) ? 0 : 1;
                var path = List.of(i);
                queue.add(new Path(path, editDistance));
            }
        }

        while (!queue.isEmpty()) {
            var next = queue.poll();

            if (next.path.size() == targetPath.size()) {
                if (next.editDistance < minEditDistance) {
                    minPath = next.path;
                    minEditDistance = next.editDistance;
                }
                continue;
            }

            var currIndex = next.path.size() - 1;
            var lastCity = next.path.get(currIndex);
            for (var neigh : adjList.get(lastCity)) {
                var neighEditDistance = next.editDistance;
                var neighPath = new ArrayList<>(next.path);
                neighPath.add(neigh);
                if (!targetPath.get(currIndex + 1).contains(neigh)) {
                    neighEditDistance++;
                }
                queue.add(new Path(neighPath, neighEditDistance));
            }
        }

        return minPath;
    }

    private List<Set<Integer>> toTargetPath(String[] names, String[] targetPathStr) {
        var namesIndex = new HashMap<String, Set<Integer>>();
        for (int i = 0; i < names.length; i++) {
            namesIndex.computeIfAbsent(names[i], v -> new HashSet<>()).add(i);
        }
        var path = new ArrayList<Set<Integer>>();
        for (var city : targetPathStr) {
            path.add(namesIndex.getOrDefault(city, Set.of()));
        }
        return path;
    }

    private List<Set<Integer>> getAdjList(int n, int[][] roads) {
        var adjList = new ArrayList<Set<Integer>>();
        for (int i = 0; i < n; i++) {
            adjList.add(new HashSet<>());
        }

        for (var road : roads) {
            var from = road[0];
            var to = road[1];

            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
        return adjList;
    }

    private class Path {
        List<Integer> path = new ArrayList<>();

        int editDistance = 0;

        public Path(List<Integer> path, int editDistance) {
            this.path = path;
            this.editDistance = editDistance;
        }

        public int getEditDistance() {
            return editDistance;
        }

        public int getSize() {
            return path.size();
        }
    }
}