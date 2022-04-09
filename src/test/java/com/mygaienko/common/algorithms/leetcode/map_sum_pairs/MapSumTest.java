package com.mygaienko.common.algorithms.leetcode.map_sum_pairs;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class MapSumTest {

    MapSum mapSum;

    /**
     * ["apple", 3], ["ap"], ["app", 2], ["ap"]]
     */
    @Test
    public void test() {
        mapSum = new MapSum();
        mapSum.insert("apple", 3);
        assertThat(mapSum.sum("ap")).isEqualTo(3);
        mapSum.insert("app", 2);
        assertThat(mapSum.sum("ap")).isEqualTo(5);
    }

    /**
     * ["MapSum","insert","sum","insert","sum","insert","insert","sum"]
     * [[],["apple",3],["ap"],["app",2],["ap"],["apple",5],["apple",1],["apple"]]
     *
     * [null,null,3,null,5,null,null,1]
     */
    @Test
    public void test0() {
        mapSum = new MapSum();
        mapSum.insert("apple", 3);
        assertThat(mapSum.sum("ap")).isEqualTo(3);
        mapSum.insert("app", 2);
        assertThat(mapSum.sum("ap")).isEqualTo(5);
        mapSum.insert("apple", 5);
        assertThat(mapSum.sum("apple")).isEqualTo(5);
        mapSum.insert("apple", 1);
        assertThat(mapSum.sum("apple")).isEqualTo(1);
    }

}