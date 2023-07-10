package com.mygaienko.common.algorithms.leetcode.flatten_2d_vector;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Vector2DTest {

    @Test
    public void test_1() {
        Vector2D vector = new Vector2D(new int[][]{{1, 2}, {3}, {4}});
        assertThat(vector.next()).isEqualTo(1);
        assertThat(vector.next()).isEqualTo(2);
        assertThat(vector.next()).isEqualTo(3);
        assertThat(vector.hasNext()).isTrue();
        assertThat(vector.hasNext()).isTrue();
        assertThat(vector.next()).isEqualTo(4);
        assertThat(vector.hasNext()).isFalse();
    }

}