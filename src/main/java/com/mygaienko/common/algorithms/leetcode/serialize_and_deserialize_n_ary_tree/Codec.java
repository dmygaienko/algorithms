package com.mygaienko.common.algorithms.leetcode.serialize_and_deserialize_n_ary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();

        var queue = new ArrayDeque<Node>();
        queue.add(root);
        sb.append(root.val);
        sb.append(",null");

        while (!queue.isEmpty()) {
            var next = queue.poll();

            if (sb.length() != 0) {
                sb.append(',');
            }

            if (next.children != null) {
                for (var child : next.children) {
                    queue.offer(child);
                    sb.append(child.val);
                    sb.append(",");
                }
            }

            if (!queue.isEmpty()) {
                sb.append("null");
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        var lastChar = sb.charAt(sb.length() - 1);
        while (Character.isLetter(lastChar) || lastChar == ',') {
            sb.deleteCharAt(sb.length() - 1);
            lastChar = sb.charAt(sb.length() - 1);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.equals("")) return null;

        var split = data.split(",");

        int i = 0;
        var root = new Node(Integer.parseInt(split[i]), new ArrayList<>());
        i++;
        i++;

        var queue = new ArrayDeque<Node>();
        queue.add(root);

        while (!queue.isEmpty() && i < split.length) {
            var parent = queue.poll();

            while (i < split.length && split[i].charAt(0) != 'n') {
                var childNode = new Node(Integer.parseInt(split[i]), new ArrayList<>());
                parent.children.add(childNode);
                queue.offer(childNode);
                i++;
            }

            i++;

        }

        return root;
    }

}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (val != node.val) return false;
        return Objects.equals(children, node.children);
    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + (children != null ? children.hashCode() : 0);
        return result;
    }
}
