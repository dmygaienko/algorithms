package com.mygaienko.common.algorithms.leetcode.diameter_of_n_ary_tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    int diameter = 0;

    public int diameter(Node root) {
        dfs(root);
        return diameter;
    }

    private int dfs(Node root) {
        var topDistance1 = 0;
        var topDistance2 = 0;

        for (var child : root.children) {
            var distance = 1 + dfs(child);

            if (distance > topDistance1) {
                topDistance2 = topDistance1;
                topDistance1 = distance;
            } else if (distance > topDistance2) {
                topDistance2 = distance;
            }

            diameter = Math.max(diameter, topDistance1 + topDistance2);
        }

        return topDistance1;
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
