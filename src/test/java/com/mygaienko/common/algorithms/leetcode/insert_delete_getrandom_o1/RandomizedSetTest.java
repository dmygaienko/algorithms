package com.mygaienko.common.algorithms.leetcode.insert_delete_getrandom_o1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RandomizedSetTest {

    @Test
    public void test() {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1);
        assertThat(randomizedSet.getRandom()).isEqualTo(1);
    }

    @Test
    public void test1() {
        RandomizedSet randomizedSet = new RandomizedSet();
        List<Integer> testList = new ArrayList<>();
        randomizedSet.insert(1);
        randomizedSet.insert(2);
        testList.add(randomizedSet.getRandom());
        testList.add(randomizedSet.getRandom());
        assertThat(testList).containsExactlyInAnyOrder(1, 2);
    }

    @Test
    public void test2() {
        RandomizedSet randomizedSet = new RandomizedSet();
        List<Integer> testList = new ArrayList<>();
        randomizedSet.insert(1);
        randomizedSet.insert(2);
        testList.add(randomizedSet.getRandom());
        testList.add(randomizedSet.getRandom());
        testList.add(randomizedSet.getRandom());
        testList.add(randomizedSet.getRandom());
        assertThat(testList).containsExactlyInAnyOrder(1, 2, 1, 2);
    }

    @Test
    public void test3() {
        RandomizedSet randomizedSet = new RandomizedSet();
        List<Integer> testList = new ArrayList<>();
        randomizedSet.insert(1);
        randomizedSet.insert(2);
        randomizedSet.remove(2);
        randomizedSet.insert(3);
        testList.add(randomizedSet.getRandom());
        testList.add(randomizedSet.getRandom());
        assertThat(testList).containsExactlyInAnyOrder(1, 3);
    }

    /**
     * ["RandomizedSet",  "insert",   "remove",   "insert",   "getRandom",    "remove",   "insert",   "getRandom"]
     * [[],               [1],        [2],        [2],        [],             [1],        [2],        []]
     */
    @Test
    public void test4() {
        RandomizedSet randomizedSet = new RandomizedSet();
        assertThat(randomizedSet.insert(1)).isTrue();
        assertThat(randomizedSet.remove(2)).isFalse();
        assertThat(randomizedSet.insert(2)).isTrue();
        assertThat(List.of(randomizedSet.getRandom())).containsAnyOf(1, 2);
        assertThat(randomizedSet.remove(1)).isTrue();
        assertThat(randomizedSet.insert(2)).isFalse();
        assertThat(randomizedSet.getRandom()).isEqualTo(2);
    }
}