package com.mygaienko.common.algorithms.leetcode.step_by_step_directions_from_a_binary_tree_node_to_another;

import java.util.ArrayList;
import java.util.List;

class Solution {

    String UP = "U";
    String LEFT = "L";
    String RIGHT = "R";

    boolean found = false;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<String> pathToStart = findNode(root, startValue, new ArrayList<>());
        found = false;
        List<String> pathToDest = findNode(root, destValue, new ArrayList<>());
        return mergePathes(pathToStart, pathToDest);
    }

    private List<String> findNode(TreeNode node, int value, List<String> path) {
        if (node.val == value) {
            found = true;
            return path;
        }

        if (node.left != null) {
            path.add(LEFT);
            findNode(node.left, value, path);

            if (found) {
                return path;
            }
        }

        if (node.right != null) {
            path.add(RIGHT);
            findNode(node.right, value, path);

            if (found) {
                return path;
            }
        }

        path.remove(path.size() - 1);

        return path;
    }

    private String mergePathes(List<String> pathToStart, List<String> pathToDest) {
        StringBuilder path = new StringBuilder();
        for (int i = 0; i < pathToStart.size() || i < pathToDest.size(); i++) {
            if (i < pathToStart.size() && i >= pathToDest.size()) {
                for (int l = i; l < pathToStart.size(); l++) {
                    path.append(UP);
                }
                break;
            } else if (i >= pathToStart.size() && i < pathToDest.size()) {
                for (int m = i; m < pathToDest.size(); m++) {
                    path.append(pathToDest.get(m));
                }
                break;
            }
            if (!pathToStart.get(i).equals(pathToDest.get(i))) {
                for (int l = i; l < pathToStart.size(); l++) {
                    path.append(UP);
                }

                for (int m = i; m < pathToDest.size(); m++) {
                    path.append(pathToDest.get(m));
                }
                break;
            }
        }
        return path.toString();
    }
}
