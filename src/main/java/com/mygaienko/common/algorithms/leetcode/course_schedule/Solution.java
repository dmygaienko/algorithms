package com.mygaienko.common.algorithms.leetcode.course_schedule;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import static java.util.Collections.emptyList;

/**
 * Kahn`s Algorithm
 * Topological Sort
 */
class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return true;

        Map<Integer, List<Integer>> dependents = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int child = prerequisite[0];
            int parent = prerequisite[1];
            dependents.computeIfAbsent(parent, v -> new ArrayList<>()).add(child);
            inDegree.compute(child, (k, v) -> v == null ? 1 : v + 1);
            inDegree.putIfAbsent(parent, 0);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        if (queue.isEmpty()) return false;

        int count = inDegree.size();

        while (!queue.isEmpty()) {
            Integer next = queue.poll();
            count--;

            List<Integer> nextDependents = dependents.getOrDefault(next, emptyList());
            for (Integer nextDependent : nextDependents) {
                Integer value = inDegree.compute(nextDependent, (k, v) -> v - 1);
                if (value == 0) {
                    queue.offer(nextDependent);
                }
            }
        }

        return count == 0;
    }

}
