package com.mygaienko.common.algorithms.leetcode.construct_binary_tree_from_preorder_and_inorder_traversal;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    private final Solution solution = new Solution();

    /**
     * [3,9,20,15,7], inorder = [9,3,15,20,7]
     */
    @Test
    public void test() {
        TreeNode treeNode = solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
        assertThat(treeNode).isEqualTo(new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))));
    }

    @Test
    public void test3() {
        TreeNode treeNode = solution.buildTree(new int[]{1, 2}, new int[]{1, 2});
        System.out.println(treeNode);
        assertThat(treeNode).isEqualTo(new TreeNode(1,
                null,
                new TreeNode(2)));
    }

    @Test
    public void test5() {
        TreeNode treeNode = solution.buildTree(new int[]{1, 2}, new int[]{2, 1});
        System.out.println(treeNode);
        assertThat(treeNode).isEqualTo(new TreeNode(1,
                new TreeNode(2),
                null));
    }

    @Test
    public void test7() {
        TreeNode treeNode = solution.buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1});
        System.out.println(treeNode);
        assertThat(treeNode).isEqualTo(new TreeNode(1,
                new TreeNode(2, new TreeNode(3), null),
                null));
    }

    /**
     * [1,null,2,null,4,3]
     */
    @Test
    public void test15() {
        TreeNode treeNode = solution.buildTree(new int[]{1, 2, 4, 3}, new int[]{1, 2, 3, 4});
        System.out.println(treeNode);
        assertThat(treeNode).isEqualTo(new TreeNode(1,
                null,
                new TreeNode(2,
                        null,
                        new TreeNode(4, new TreeNode(3), null)
                )));
    }

    @Test
    public void test17() {
        TreeNode treeNode = solution.buildTree(new int[]{1, 3, 2, 4}, new int[]{1, 2, 3, 4});
        System.out.println(treeNode); // [1,2,null,null,3]
        assertThat(treeNode).isEqualTo(new TreeNode(1,
                null,
                new TreeNode(3, new TreeNode(2), new TreeNode(4))));
    }


    @Test
    public void test19() {
        TreeNode treeNode = solution.buildTree(new int[]{1, 2, 3}, new int[]{2, 3, 1});
        System.out.println(treeNode); // [1,2,null,null,3]
        assertThat(treeNode).isEqualTo(new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                null));
    }

    @Test
    public void test30() {
        TreeNode treeNode = solution.buildTree(new int[]{1, 2, 3}, new int[]{1, 3, 2});
        System.out.println(treeNode); // [1,2,null,null,3]
        assertThat(treeNode).isEqualTo(new TreeNode(1,
                null,
                new TreeNode(2, new TreeNode(3), null)));
    }

    @Test
    public void test53() {
        TreeNode treeNode = solution.buildTree(new int[]{1, 4, 3, 2}, new int[]{1, 2, 3, 4});
        System.out.println(treeNode); // [1,2,null,null,3]
        assertThat(treeNode).isEqualTo(new TreeNode(1,
                null,
                new TreeNode(4,
                        new TreeNode(3, new TreeNode(2), null),
                        null)));
    }

    @Test
    public void test59() {
        TreeNode treeNode = solution.buildTree(new int[]{2, 1, 3, 4}, new int[]{1, 2, 3, 4});
        System.out.println(treeNode); // [1,2,null,null,3]
        assertThat(treeNode).isEqualTo(new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3, null,
                        new TreeNode(4))));
    }

    @Test
    public void test66() {
        TreeNode treeNode = solution.buildTree(new int[]{3, 1, 2, 4}, new int[]{1, 2, 3, 4});
        System.out.println(treeNode); // [1,2,null,null,3]
        assertThat(treeNode).isEqualTo(new TreeNode(3,
                new TreeNode(1, null, new TreeNode(2)),
                new TreeNode(4)));
    }

    /**
     * 4,1,null,null,3,2
     */
    @Test
    public void test88() {
        TreeNode treeNode = solution.buildTree(new int[]{4,1,3,2}, new int[]{1,2,3,4});
        System.out.println(treeNode); // [1,2,null,null,3]
        assertThat(treeNode).isEqualTo(new TreeNode(4,
                new TreeNode(1, null, new TreeNode(3, new TreeNode(2), null)),
                null));
    }

    @Test
    public void test128() {
        TreeNode treeNode = solution.buildTree(new int[]{1, 2, 3}, new int[]{1, 2, 3});
        System.out.println(treeNode); // [1,2,null,null,3]
        assertThat(treeNode).isEqualTo(new TreeNode(1,
                null,
                new TreeNode(2, null, new TreeNode(3))));
    }
}