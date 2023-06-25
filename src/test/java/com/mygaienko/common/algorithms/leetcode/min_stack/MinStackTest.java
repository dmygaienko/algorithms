package com.mygaienko.common.algorithms.leetcode.min_stack;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class MinStackTest {

    /**
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin(); // return -3
     * minStack.pop();
     * minStack.top();    // return 0
     * minStack.getMin(); // return -2
     */
    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertThat(minStack.getMin()).isEqualTo(-3);
        minStack.pop();
        assertThat(minStack.top()).isEqualTo(0);
        assertThat(minStack.getMin()).isEqualTo(-2);
    }

    /**
     * ["MinStack","push","push","push",    "getMin","top","pop","getMin"]
     * [[],         [-2],[0],[-1],          [],[],[],[]]
     *
     * Expected
     * [null,null,null,null,-2,-1,null,-2]
     */
    @Test
    public void test3() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        assertThat(minStack.getMin()).isEqualTo(-2);
        assertThat(minStack.top()).isEqualTo(-1);
        minStack.pop();
        assertThat(minStack.getMin()).isEqualTo(-2);
    }

    /**
     * ["MinStack", "push","push","push",   "getMin","pop","getMin"]
     * [[],         [0],[1],[0],            [],[],[]]
     *
     * [null,       null,null,null,         0,null,0]
     */
    @Test
    public void test4() {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        assertThat(minStack.getMin()).isEqualTo(0);
        minStack.pop();
        assertThat(minStack.getMin()).isEqualTo(0);
    }

}