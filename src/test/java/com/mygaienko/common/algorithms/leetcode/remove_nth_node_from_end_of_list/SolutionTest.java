package com.mygaienko.common.algorithms.leetcode.remove_nth_node_from_end_of_list;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test_1() {
        ListNode actual = solution.removeNthFromEnd(new ListNode(1, new ListNode(2)), 1);
        assertThat(actual).isEqualTo(new ListNode(1));
    }

    @Test
    public void test_2() {
        ListNode actual = solution.removeNthFromEnd(new ListNode(1, new ListNode(2)), 2);
        assertThat(actual).isEqualTo(new ListNode(2));
    }

}