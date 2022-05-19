package com.mygaienko.common.algorithms.leetcode.add_two_numbers;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    /**
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     */
    @Test
    public void test() {
        ListNode actual = solution.addTwoNumbers(
                new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4)))
                );
        assertThat(actual).isEqualTo(
                new ListNode(7, new ListNode(0, new ListNode(8))));
    }

}