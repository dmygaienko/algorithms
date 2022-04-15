package com.mygaienko.common.algorithms.leetcode.n_ary_tree_postorder_traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Solution {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        BitSet bitSet = new BitSet();

        while (!stack.isEmpty()) {

            Node peek = stack.peek();
            int val = peek.val;

            if (peek.children == null || peek.children.size() == 0 || bitSet.get(val)) {
                Node pop = stack.pop();
                result.add(pop.val);
            } else {
                for (int i = peek.children.size() - 1; i >= 0; i--) {
                    Node child = peek.children.get(i);
                    stack.push(child);
                }
            }

            bitSet.set(val);
        }

        return result;
    }
}
