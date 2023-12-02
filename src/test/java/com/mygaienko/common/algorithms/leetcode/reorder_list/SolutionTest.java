package com.mygaienko.common.algorithms.leetcode.reorder_list;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        solution.reorderList(head);
        assertThat(head).usingRecursiveComparison().isEqualTo(new ListNode(1, new ListNode(4, new ListNode(2, new ListNode(3)))));
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        solution.reorderList(head);
        assertThat(head).usingRecursiveComparison().isEqualTo(new ListNode(1, new ListNode(5, new ListNode(2, new ListNode(4, new ListNode(3))))));
    }

    // 1 2 1 2 1 2

    // 1 2 2

    // node 2
    // next 1

    // 1 2 2 1 1
    // node 1
    // next 2
    @Test
    public void test3() {
        var head = new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(2))))));
        var expected = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1, new ListNode(1, new ListNode(2))))));
        solution.reorderList(head);
        assertThat(head).usingRecursiveComparison().isEqualTo(expected);
    }
}