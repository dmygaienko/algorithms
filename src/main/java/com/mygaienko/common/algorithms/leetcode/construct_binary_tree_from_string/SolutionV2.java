package com.mygaienko.common.algorithms.leetcode.construct_binary_tree_from_string;

class SolutionV2 {

    int index = 0;

    public TreeNode str2tree(String s) {
        return build(s);
    }

    private TreeNode build(String s) {
        TreeNode treeNode = null;

        var sign = 1;
        if (index < s.length() && s.charAt(index) == '-') {
            index++;
            sign = -1;
        }

        Integer startIndex = null;
        Integer endIndex = null;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            if (startIndex == null) {
                startIndex = index;
            }
            endIndex = index;
            index++;
        }

        if (startIndex != null) {
            treeNode = new TreeNode(Integer.parseInt(s.substring(startIndex, endIndex + 1)) * sign);
        }

        if (index < s.length() && s.charAt(index) == '(') {
            index++;
            treeNode.left = build(s);
        }

        if (index < s.length() && s.charAt(index) == ')') {
            index++;
            return treeNode;
        }

        if (index < s.length() && s.charAt(index) == '(') {
            index++;
            treeNode.right = build(s);
        }

        if (index < s.length() && s.charAt(index) == ')') {
            index++;
            return treeNode;
        }

        return treeNode;
    }

}

