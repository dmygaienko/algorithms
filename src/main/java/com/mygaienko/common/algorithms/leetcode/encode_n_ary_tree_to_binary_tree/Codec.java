package com.mygaienko.common.algorithms.leetcode.encode_n_ary_tree_to_binary_tree;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Codec {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null) return null;
        var head = new TreeNode(root.val);

        var queue = new ArrayDeque<Pair<TreeNode, Node>>();
        queue.offer(pair(head, root));

        while (!queue.isEmpty()) {
            var next = queue.poll();
            var binary = next.getKey();
            var nary = next.getValue();

            TreeNode childHead = null;
            TreeNode childTail = null;
            for (var child : nary.children) {
                var binaryChild = new TreeNode(child.val);

                if (childHead == null) {
                    childHead = binaryChild;
                } else {
                    childTail.right = binaryChild;
                }
                childTail = binaryChild;

                queue.offer(pair(binaryChild, child));
            }

            binary.left = childHead;
        }

        return head;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) return null;
        var head = new Node(root.val, new ArrayList<>());

        var queue = new ArrayDeque<Pair<Node, TreeNode>>();
        queue.offer(pair(head, root));

        while (!queue.isEmpty()) {
            var next = queue.poll();
            var nary = next.getKey();
            var binary = next.getValue();

            var sibling = binary.left;
            while (sibling != null) {
                var child = new Node(sibling.val, new ArrayList<>());
                nary.children.add(child);

                queue.offer(pair(child, sibling));

                sibling = sibling.right;
            }

        }

        return head;
    }

    private <K, V> Pair<K, V> pair(K key, V value) {
        return Pair.of(key, value);
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));