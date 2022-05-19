package com.mygaienko.common.algorithms.leetcode.merge_k_sorted_lists;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        ListNode actual = solution.mergeKLists(new ListNode[]{
                new ListNode(0),
                new ListNode(1)
        });
        assertThat(actual).isEqualTo(new ListNode(0, new ListNode(1)));
        System.out.println(actual);
    }

    @Test
    public void test1() {
        ListNode actual = solution.mergeKLists(new ListNode[]{
                new ListNode(0, new ListNode(2)),
                new ListNode(1, new ListNode(3))
        });
        assertThat(actual).isEqualTo(new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3)))));
        System.out.println(actual);
    }

    @Test
    public void test11() {
        ListNode actual = solution.mergeKLists(new ListNode[]{
                new ListNode(0, new ListNode(2)),
                new ListNode(1, new ListNode(1, new ListNode(3)))
        });
        assertThat(actual).isEqualTo(new ListNode(0, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3))))));
        System.out.println(actual);
    }

    @Test
    public void test22() {
        ListNode actual = solution.mergeKLists(new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        });
        assertThat(actual).isEqualTo(new ListNode(1, new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5, new ListNode(6)))))))));
        System.out.println(actual);
    }

    /**
     *
     * [[1,2,2],[1,1,2]]
     */
    @Test
    public void test122_112() {
        ListNode actual = solution.mergeKLists(new ListNode[]{
                new ListNode(1, new ListNode(2, new ListNode(2))),
                new ListNode(1, new ListNode(1, new ListNode(2)))
        });
        assertThat(actual).isEqualTo(new ListNode(1, new ListNode(1, new ListNode(1,
                new ListNode(2, new ListNode(2, new ListNode(2)))))));
        System.out.println(actual);
    }
}