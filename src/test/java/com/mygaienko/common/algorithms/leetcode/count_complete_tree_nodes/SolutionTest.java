package com.mygaienko.common.algorithms.leetcode.count_complete_tree_nodes;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    Solution solution = new Solution();
    private TreeNode root = new TreeNode(1,
            new TreeNode(2,
                    new TreeNode(4),
                    new TreeNode(5)),
            new TreeNode(3,
                    new TreeNode(6),
                    null));

    @Test
    public void test_countNodes_root() {
        int countNodes = solution.countNodes(root);
        assertThat(countNodes).isEqualTo(6);
    }

    @Test
    public void test_countNodes_3() {
        int countNodes = solution.countNodes(
                new TreeNode(1,
                        new TreeNode(2),
                        new TreeNode(3)));
        assertThat(countNodes).isEqualTo(3);
    }

    @Test
    public void test_countNodes_4() {
        int countNodes = solution.countNodes(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                null),
                        new TreeNode(3)));
        assertThat(countNodes).isEqualTo(4);
    }

    @Test
    public void test_null() {
        int countNodes = solution.countNodes(null);
        assertThat(countNodes).isEqualTo(0);
    }

    @Test
    public void tes2() {
        int countNodes = solution.countNodes(new TreeNode(1));
        assertThat(countNodes).isEqualTo(1);
    }

    @Test
    public void testCountFull() {
        assertThat(solution.countComplete(0, 1)).isEqualTo(1);
        assertThat(solution.countComplete(0, 2)).isEqualTo(3);
        assertThat(solution.countComplete(0, 3)).isEqualTo(7);
        assertThat(solution.countComplete(0, 4)).isEqualTo(15);
        assertThat(solution.countComplete(0, 5)).isEqualTo(31);
    }

    @Test
    public void testCountHeight() {
        assertThat(solution.countHeight(root)).isEqualTo(2);
    }

    @Test
    public void testExist() {
        assertThat(solution.isExist(root, 0, 2, 0, 3)).isTrue();
        assertThat(solution.isExist(root, 1, 2, 0, 3)).isTrue();
        assertThat(solution.isExist(root, 2, 2, 0, 3)).isTrue();
        assertThat(solution.isExist(root, 3, 2, 0, 3)).isFalse();
    }

}