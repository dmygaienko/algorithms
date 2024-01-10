package com.mygaienko.common.algorithms.leetcode.diameter_of_n_ary_tree;

import java.util.ArrayList;
import java.util.List;

public class SolutionV2 {

    int diameter = 0;

    public int diameter(Node root) {
        maxDepth(root, 0);
        return diameter;
    }

    private int maxDepth(Node node, int currDepth) {
        if (node.children.size() == 0) return currDepth;

        var maxDepth1 = 0;
        var maxDepth2 = 0;

        for (var child : node.children) {
            var depth = maxDepth(child, currDepth + 1);

            if (depth > maxDepth1) {
                maxDepth2 = maxDepth1;
                maxDepth1 = depth;
            } else if (depth > maxDepth2) {
                maxDepth2 = depth;
            }

            diameter = Math.max(diameter, maxDepth1 + maxDepth2 - 2 * currDepth);
        }

        return maxDepth1;
    }

}

