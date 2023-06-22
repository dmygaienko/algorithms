package com.mygaienko.common.algorithms.leetcode.flatten_nested_list_iterator;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class NestedIteratorTest {

    /**
     * [
     *  [1,1]
     *  ,2,
     *  [1,1]
     * ]
     *
     * [1,1,2,1,1]
     */
    @Test
    public void test0() {
        NestedIterator nestedIterator = new NestedIterator(
                List.of(
                        new NestedInteger(List.of(new NestedInteger(1), new NestedInteger(1))),
                        new NestedInteger(2),
                        new NestedInteger(List.of(new NestedInteger(1), new NestedInteger(1)))
                ));
        assertThat(nestedIterator.next()).isEqualTo(1);
        assertThat(nestedIterator.next()).isEqualTo(1);
        assertThat(nestedIterator.next()).isEqualTo(2);
        assertThat(nestedIterator.next()).isEqualTo(1);
        assertThat(nestedIterator.next()).isEqualTo(1);
    }
}