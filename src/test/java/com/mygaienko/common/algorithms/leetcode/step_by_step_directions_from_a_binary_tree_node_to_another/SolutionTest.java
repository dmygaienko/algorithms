package com.mygaienko.common.algorithms.leetcode.step_by_step_directions_from_a_binary_tree_node_to_another;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class SolutionTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode();
        root.left = new TreeNode(1, new TreeNode(3), null);
        root.right = new TreeNode(2, new TreeNode(6), new TreeNode(4));
        String actual = solution.getDirections(root, 3, 6);
        assertThat(actual).isEqualTo("UURL");
    }

    @Test
    public void test249() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        String actual = solution.getDirections(root, 2, 1);
        assertThat(actual).isEqualTo("U");
    }

    @Test
    public void test254() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(2));
        String actual = solution.getDirections(root, 2, 1);
        assertThat(actual).isEqualTo("UL");
    }

    /**
     * 5,
     * 8,3,
     * 1,null,4,7,
     * 6,null,null,null,null,null,null,2
     */
    @Test
    public void test247() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8,
                new TreeNode(1, new TreeNode(6), null),
                null);
        root.right = new TreeNode(3,
                new TreeNode(4),
                new TreeNode(7, null, new TreeNode(2)));
        String actual = solution.getDirections(root, 5, 6);
        assertThat(actual).isEqualTo("LLL");
    }

    @Test
    public void test260() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8,
                new TreeNode(1, new TreeNode(6), null),
                null);
        root.right = new TreeNode(3,
                new TreeNode(4),
                new TreeNode(7, null, new TreeNode(2)));
        String actual = solution.getDirections(root, 4, 3);
        assertThat(actual).isEqualTo("U");
    }

}