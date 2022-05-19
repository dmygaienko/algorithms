package com.mygaienko.common.algorithms.leetcode.n_ary_tree_postorder_traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList();
        if (root == null) return result;

        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        Set<Node> seen = new HashSet<>(); // could be bitset if input doesn't have duplicates

        while (!stack.isEmpty()) {

            Node peek = stack.peek();

            if (peek.children == null || peek.children.size() == 0 || seen.contains(peek)) {
                Node pop = stack.pop();
                result.add(pop.val);
            } else {
                for (int i = peek.children.size() - 1; i >= 0; i--) {
                    Node child = peek.children.get(i);
                    stack.push(child);
                }
            }

            seen.add(peek);
        }

        return result;
    }
}
