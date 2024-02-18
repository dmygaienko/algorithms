package com.mygaienko.common.algorithms.leetcode.range_sum_query_mutable;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class NumArrayTest {

    @Test
    public void test() {
        var numArray = new NumArrayV2(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        assertThat(numArray.sumRange(0, 0)).isEqualTo(1);
        assertThat(numArray.sumRange(0, 1)).isEqualTo(3);
        assertThat(numArray.sumRange(1, 1)).isEqualTo(2);
        assertThat(numArray.sumRange(0, 2)).isEqualTo(6);
        assertThat(numArray.sumRange(0, 3)).isEqualTo(10);
        assertThat(numArray.sumRange(0, 4)).isEqualTo(15);
        assertThat(numArray.sumRange(0, 5)).isEqualTo(21);
        assertThat(numArray.sumRange(0, 6)).isEqualTo(28);
        assertThat(numArray.sumRange(0, 7)).isEqualTo(36);
        assertThat(numArray.sumRange(5, 7)).isEqualTo(21);
    }

    @Test
    public void test1() {
        var numArray = new NumArrayV2(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        assertThat(numArray.sumRange(0, 0)).isEqualTo(1);
        assertThat(numArray.sumRange(0, 1)).isEqualTo(3);
        assertThat(numArray.sumRange(1, 1)).isEqualTo(2);
        assertThat(numArray.sumRange(0, 2)).isEqualTo(6);
        assertThat(numArray.sumRange(0, 3)).isEqualTo(10);
        assertThat(numArray.sumRange(0, 4)).isEqualTo(15);
        assertThat(numArray.sumRange(0, 5)).isEqualTo(21);
        assertThat(numArray.sumRange(0, 6)).isEqualTo(28);
        assertThat(numArray.sumRange(0, 7)).isEqualTo(36);
        assertThat(numArray.sumRange(5, 7)).isEqualTo(21);
        numArray.update(5, -3);
        assertThat(numArray.sumRange(0, 7)).isEqualTo(27);
    }

    @Test
    public void test2() {
        var numArray = new NumArrayV2(new int[]{-1});
        assertThat(numArray.sumRange(0, 0)).isEqualTo(-1);
        numArray.update(0, 1);
        assertThat(numArray.sumRange(0, 0)).isEqualTo(1);
    }
}