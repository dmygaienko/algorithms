package com.mygaienko.common.algorithms.leetcode.convert_binary_search_tree_to_sorted_doubly_linked_list;

class Solution {

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Parts parts = new Parts();
        treeToDoublyList(root, parts);
        parts.end.right = parts.head;
        parts.head.left = parts.end;
        return parts.head;
    }

    private Nodes treeToDoublyList(Node root, Parts parts) {
        if (parts.head == null || root.val <= parts.head.val) parts.head = root;
        if (parts.end == null || root.val >= parts.end.val) parts.end = root;

        Nodes right;
        if (root.right != null) {
            right = treeToDoublyList(root.right, parts);
            Node minRight = right.min;

            root.right = minRight; //succ
            minRight.left = root; //pred
        } else {
            right = new Nodes(root, root);
        }

        Nodes left;
        if (root.left != null) {
            left = treeToDoublyList(root.left, parts);
            Node maxLeft = left.max;

            root.left = maxLeft; //pred
            maxLeft.right = root; //succ
        } else {
            left = new Nodes(root, root);
        }

        return new Nodes(left.min, right.max);
    }
}

class Parts {
    Node head;
    Node end;
}

class Nodes {
    Node min;
    Node max;

    public Nodes(Node min, Node max) {
        this.min = min;
        this.max = max;
    }
}


