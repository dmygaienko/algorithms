package com.mygaienko.common.algorithms.leetcode.amount_of_time_for_binary_tree_to_be_infected;

import com.mygaienko.common.algorithms.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class Solution {

    public int amountOfTime(TreeNode root, int start) {
        var adjMap = getAdjacency(root, new HashMap<>());

        var queue = new ArrayDeque<>();
        queue.add(start);

        var time = 0;
        var seen = new HashSet<>();


        while (!queue.isEmpty()) {
            var levelSize = queue.size();

            while (levelSize > 0) {
                var next = queue.poll();

                if (seen.contains(next)) continue;
                seen.add(next);

                for (var neigh : adjMap.getOrDefault(next, List.of())) {
                    if (!seen.contains(neigh)) {
                        queue.add(neigh);
                    }
                }
                levelSize--;
            }

            time++;

        }

        return time - 1;
    }

    private Map<Integer, List<Integer>> getAdjacency(TreeNode root, Map<Integer, List<Integer>> adjacency) {
        if (root == null) return adjacency;

        if (root.left != null) {
            adjacency.computeIfAbsent(root.val, v -> new ArrayList<>()).add(root.left.val);
            adjacency.computeIfAbsent(root.left.val, v -> new ArrayList<>()).add(root.val);
            getAdjacency(root.left, adjacency);
        }

        if (root.right != null) {
            adjacency.computeIfAbsent(root.val, v -> new ArrayList<>()).add(root.right.val);
            adjacency.computeIfAbsent(root.right.val, v -> new ArrayList<>()).add(root.val);
            getAdjacency(root.right, adjacency);
        }

        return adjacency;
    }

}
