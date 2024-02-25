package com.mygaienko.common.algorithms.leetcode.closest_binary_search_tree_value_ii;

import java.util.ArrayList;
import java.util.List;

public class SolutionV2 {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        var list = new ArrayList<Integer>();
        inorder(root, list);

        var closestIndex = 0;
        for (int i = 1; i < list.size(); i++) {
            var closestVal = list.get(closestIndex);
            var nextVal = list.get(i);
            if (Math.abs(closestVal - target) > Math.abs(nextVal - target)) {
                closestIndex = i;
            }
        }

        int left = closestIndex;
        int right = closestIndex;

        while (right - left + 1 < k) {
            if (left - 1 < 0) {
                right++;
                continue;
            }

            if (right + 1 >= list.size()) {
                left--;
                continue;
            }

            if (Math.abs(list.get(left - 1) - target) < Math.abs(list.get(right + 1) - target)) {
                left--;
            } else {
                right++;
            }
        }

        return list.subList(left, right + 1);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
