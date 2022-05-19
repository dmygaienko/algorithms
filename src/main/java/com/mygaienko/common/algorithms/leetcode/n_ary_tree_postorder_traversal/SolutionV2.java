package com.mygaienko.common.algorithms.leetcode.n_ary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;

public class SolutionV2 {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList();
        postOrder(result, root);
        if (root != null) result.add(root.val);
        return result;
    }

    private void postOrder(List<Integer> result, Node root) {
        if (root == null) return;

        if (root.children != null && root.children.size() > 0) {
            for (Node child : root.children) {
                postOrder(result, child);
                result.add(child.val);
            }
        }
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
