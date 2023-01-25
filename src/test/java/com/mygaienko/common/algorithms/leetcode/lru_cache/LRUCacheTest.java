package com.mygaienko.common.algorithms.leetcode.lru_cache;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LRUCacheTest {


    @Test
    public void test() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertThat(cache.get(1)).isEqualTo(1);
        cache.put(3, 3);
        assertThat(cache.get(2)).isEqualTo(-1);
        cache.put(4, 4);
        assertThat(cache.get(1)).isEqualTo(-1);
    }

    /**
     * ["LRUCache", "get",      "put",  "get",  "put",  "put",  "get",  "get"]
     * [[2],        [2],        [2,6],  [1],    [1,5],  [1,2],  [1],    [2]]
     * [null,       -1,         null,   -1,     null,   null,   2,      6]
     */
    @Test
    public void test2() {
        LRUCache cache = new LRUCache(2);
        assertThat(cache.get(2)).isEqualTo(-1);
        cache.put(2, 6);
        assertThat(cache.get(1)).isEqualTo(-1);
        cache.put(1, 5);
        cache.put(1, 2);
        assertThat(cache.get(1)).isEqualTo(2);
        assertThat(cache.get(2)).isEqualTo(6);
    }

    /**
     * ["LRUCache", "put",  "put",  "get",  "get"," put",   "get",  "get",  "get"]
     * [[2],        [2,1],  [3,2],  [3],    [2],    [4,3],  [2],    [3],    [4]]
     * [null,       null,   null,   2,      1,      null,   1,      -1,     3]
     */
    @Test
    public void test13() {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(3, 2);
        assertThat(cache.get(3)).isEqualTo(2);
        assertThat(cache.get(2)).isEqualTo(1);
        cache.put(4, 3);
        assertThat(cache.get(2)).isEqualTo(1);
        assertThat(cache.get(3)).isEqualTo(-1);
        assertThat(cache.get(4)).isEqualTo(3);
    }
}
