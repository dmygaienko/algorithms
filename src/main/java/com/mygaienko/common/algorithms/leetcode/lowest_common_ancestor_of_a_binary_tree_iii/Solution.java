package com.mygaienko.common.algorithms.leetcode.lowest_common_ancestor_of_a_binary_tree_iii;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public Node lowestCommonAncestor(Node p, Node q) {
        return lowestCommonAncestor(p, q, new HashSet<>());
    }

    public Node lowestCommonAncestor(Node p, Node q, Set<Node> visited) {
        visited.add(p);
        visited.add(q);

        while (p.parent != null || q.parent != null) {

            if (p.parent != null) {
                p = p.parent;
                if (!visited.add(p)) return p;
            }

            if (q.parent != null) {
                q = q.parent;
                if (!visited.add(q)) return q;
            }

        }

        return p;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
