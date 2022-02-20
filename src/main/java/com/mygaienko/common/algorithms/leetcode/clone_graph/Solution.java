package com.mygaienko.common.algorithms.leetcode.clone_graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class Solution {

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Integer, Node> clonedNodes = new HashMap<>();
        Node cloned = new Node(node.val);
        clonedNodes.put(node.val, cloned);
        Deque<Node[]> stack = new ArrayDeque<>();
        stack.push(new Node[]{cloned, node});

        while(!stack.isEmpty()) {
            Node[] next = stack.pop();

            Node to = next[0];
            Node from = next[1];

            to.val = from.val;

            if (from.neighbors != null && !from.neighbors.isEmpty()) {
                to.neighbors = new ArrayList<>();
                for (Node neighbor : from.neighbors) {
                    int val = neighbor.val;
                    Node clonedNeighbor = clonedNodes.get(val);
                    if (clonedNeighbor == null) {
                        clonedNeighbor = new Node(val);
                        stack.push(new Node[] {clonedNeighbor, neighbor});
                        clonedNodes.put(val, clonedNeighbor);
                    }
                    to.neighbors.add(clonedNeighbor);
                }
            }

        }

        return cloned;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = new ArrayList<>(_neighbors);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return val == node.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}
