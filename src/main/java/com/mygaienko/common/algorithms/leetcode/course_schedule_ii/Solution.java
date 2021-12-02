package com.mygaienko.common.algorithms.leetcode.course_schedule_ii;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Stack;

class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        BitSet visited = new BitSet(numCourses);
        BitSet onStack = new BitSet(numCourses);

        List<List<Integer>> adj = new ArrayList<>(numCourses);
        int n = numCourses;
        while (n-- > 0) adj.add(new ArrayList<>());

        for (int[] prerequisite : prerequisites) {
            int depended = prerequisite[0];
            int curr = prerequisite[1];

            List<Integer> adjacents = adj.get(depended);
            adjacents.add(curr);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < adj.size(); i++) {
            if (!visited.get(i) && !hasOrder(i, adj, visited, onStack, stack)) return new int[]{};
        }

        int [] order = new int[numCourses];
        for (int i = numCourses - 1; i > -1; i--) {
            order[i] = stack.pop();
        }

        return order;
    }

    private boolean hasOrder(int current, List<List<Integer>> adj, BitSet visited, BitSet onStack, Stack<Integer> stack) {
        visited.set(current);
        onStack.set(current);

        for (Integer next : adj.get(current)) {
            if (!visited.get(next)) {
                if (!hasOrder(next, adj, visited, onStack, stack)) {
                    return false;
                }
            } else if (onStack.get(next)) {
                return false;
            }
        }

        stack.push(current);
        onStack.clear(current);
        return true;
    }

}
