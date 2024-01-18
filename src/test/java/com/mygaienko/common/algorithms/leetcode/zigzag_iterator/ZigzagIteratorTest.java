package com.mygaienko.common.algorithms.leetcode.zigzag_iterator;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ZigzagIteratorTest {

    @Test
    public void test() {
        var iterator = new ZigzagIterator(
                List.of(),
                List.of(1)
        );
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    public void test2() {
        var iterator = new ZigzagIterator(
                List.of(1),
                List.of()
        );
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    public void test1() {
        var iterator = new ZigzagIterator(
                List.of(1, 2),
                List.of(3, 4, 5, 6)
        );
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(4);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(5);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(6);
        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    public void test67() {
        var iterator = new ZigzagIterator(
                List.of(1, 2),
                List.of()
        );
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.hasNext()).isFalse();
    }

}