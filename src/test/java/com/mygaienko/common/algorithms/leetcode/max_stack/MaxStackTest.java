package com.mygaienko.common.algorithms.leetcode.max_stack;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class MaxStackTest {

    /**
     * ["MaxStack","push","popMax","push","push","push","pop","peekMax","push",
     * "pop","pop","push","peekMax","peekMax","push","peekMax","push","peekMax"]
     *
     * [[],         [-2],   [],     [-45], [-82], [29],   [],    [],     [40],
     * [],    [],   [66],     [],      [],     [-61],   [],      [98],   []]
     *
     *
     * [null,       null,   -2,     null,   null,  null,   29,   -45,     null,
     * 40,    -82,  null,     66,      66,      null,  66,       null,    98]
     */
    @Test
    public void test_46() {
        MaxStack maxStack = new MaxStack();
        maxStack.push(-2);
        assertThat(maxStack.popMax()).isEqualTo(-2);
        maxStack.push(-45);
        maxStack.push(-82);
        maxStack.push(29);
        assertThat(maxStack.pop()).isEqualTo(29);
        assertThat(maxStack.peekMax()).isEqualTo(-45);
    }
}