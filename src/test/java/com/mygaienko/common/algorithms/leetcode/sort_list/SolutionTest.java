package com.mygaienko.common.algorithms.leetcode.sort_list;


import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    /**
     * [4,2,1,3]
     */
    @Test
    public void test() {
        ListNode actual = solution.sortList(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3)))));
        assertThat(actual).isEqualTo(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
    }

    /**
     * [-1,5,3,4,0]
     */
    @Test
    public void test__1_5_3_4_0() {
        ListNode actual = solution.sortList(new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0))))));
        assertThat(actual).isEqualTo(new ListNode(-1, new ListNode(0, new ListNode(3, new ListNode(4, new ListNode(5))))));
    }

    /**
     * [3, 2, 4]
     */
    @Test
    public void test_3_2_4() {
        ListNode actual = solution.sortList(new ListNode(3, new ListNode(2, new ListNode(4))));
        assertThat(actual).isEqualTo(new ListNode(2, new ListNode(3, new ListNode(4))));
    }

    /**
     * [4,19,14,5,-3,
     * 1,8,5,11,15]
     */
    @Test
    public void test_10() {
        ListNode actual = solution.sortList(
                new ListNode(4, new ListNode(19, new ListNode(14, new ListNode(5, new ListNode(-3,
                        new ListNode(1, new ListNode(8, new ListNode(5, new ListNode(11, new ListNode(15)))))))))));
        assertThat(actual).isEqualTo(new ListNode(-3, new ListNode(1, new ListNode(4, new ListNode(5, new ListNode(5,
                new ListNode(8, new ListNode(11, new ListNode(14, new ListNode(15, new ListNode(19)))))))))));
    }


}