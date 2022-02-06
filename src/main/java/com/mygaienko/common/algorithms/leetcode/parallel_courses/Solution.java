package com.mygaienko.common.algorithms.leetcode.parallel_courses;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import static java.util.Collections.emptyList;

class Solution {

    private static int NOT_POSSIBLE = -1;

    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, List<Integer>> dependents = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        for (int[] relation : relations) {
            int prev = relation[0];
            int next = relation[1];
            dependents.computeIfAbsent(prev, v -> new ArrayList<>()).add(next);
            inDegree.putIfAbsent(prev, 0);
            inDegree.compute(next, (k, v) -> v == null ? 1 : v + 1);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int currSemester = 0;
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
                currSemester++;
            }
        }

        if (currSemester == 0) return NOT_POSSIBLE;

        int nextSemester = 0;
        int minSemesters = 0;
        int left = inDegree.size();
        while (!queue.isEmpty()) {
            Integer next = queue.poll();

            List<Integer> nextDependents = dependents.getOrDefault(next, emptyList());
            for (Integer nextDependent : nextDependents) {
                Integer value = inDegree.compute(nextDependent, (k, v) -> v - 1);
                if (value == 0) {
                    queue.offer(nextDependent);
                    nextSemester++;
                }
            }

            currSemester--;
            left--;
            if (currSemester == 0) {
                minSemesters++;
                currSemester = nextSemester;
                nextSemester = 0;
            }
        }

        return left == 0 ? minSemesters : NOT_POSSIBLE;
    }
}
