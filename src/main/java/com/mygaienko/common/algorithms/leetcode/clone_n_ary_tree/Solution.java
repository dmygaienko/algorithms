package com.mygaienko.common.algorithms.leetcode.clone_n_ary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public Node cloneTree(Node root) {
        if (root == null) return null;

        var queue = new ArrayDeque<Node[]>();
        var copy = new Node(root.val);
        queue.add(new Node[]{copy, root});

        while (!queue.isEmpty()) {
            var next = queue.poll();
            var copyNode = next[0];
            var node = next[1];

            for (var child : node.children) {
                var copyChild = new Node(child.val);
                copyNode.children.add(copyChild);
                queue.offer(new Node[]{copyChild, child});
            }
        }

        return copy;
    }

    public Node cloneTreeV2(Node root) {
        if (root == null) {
            return null;
        }
        Node node = new Node(root.val);
        if (root.children != null) {
            for (Node n : root.children) {
                node.children.add(cloneTree(n));
            }
        }
        return node;
    }

}

class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
