package com.mygaienko.common.algorithms.leetcode.inorder_traversal;

import com.mygaienko.common.algorithms.leetcode.common.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.inorderTraversal(new TreeNode(3, new TreeNode(1), new TreeNode(2)));
        assertThat(actual).isEqualTo(List.of(1, 3, 2));
    }
}