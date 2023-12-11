package com.mygaienko.common.algorithms.leetcode.lowest_common_ancestor_of_a_binary_tree_iv;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        var node15 = new TreeNode(15);
        var node18 = new TreeNode(18);
        node18.right = node15;

        TreeNode treeNode = solution.lowestCommonAncestor(node18, new TreeNode[]{node15, node18});
        assertThat(treeNode).isEqualTo(node18);
    }
}