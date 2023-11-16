package com.mygaienko.common.algorithms.leetcode.k_th_symbol_in_grammar;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 *     //  0
 *     //  01
 *     //  0110
 *     //  01101001
 *
 *     //  0110100110010110
 */
public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.kthGrammar(1, 1);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void test21() {
        int actual = solution.kthGrammar(2, 1);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void test22() {
        int actual = solution.kthGrammar(2, 2);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test31() {
        int actual = solution.kthGrammar(3, 1);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void test32() {
        int actual = solution.kthGrammar(3, 2);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test33() {
        int actual = solution.kthGrammar(3, 3);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test34() {
        int actual = solution.kthGrammar(3, 4);
        assertThat(actual).isEqualTo(0);
    }

    //  01101001

    @Test
    public void test41() {
        int actual = solution.kthGrammar(4, 1);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void test42() {
        int actual = solution.kthGrammar(4, 2);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test43() {
        int actual = solution.kthGrammar(4, 3);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test44() {
        int actual = solution.kthGrammar(4, 4);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void test45() {
        int actual = solution.kthGrammar(4, 5);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test46() {
        int actual = solution.kthGrammar(4, 6);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void test47() {
        int actual = solution.kthGrammar(4, 7);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void test48() {
        int actual = solution.kthGrammar(4, 8);
        assertThat(actual).isEqualTo(1);
    }

}