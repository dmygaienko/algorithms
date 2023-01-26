package com.mygaienko.common.algorithms.leetcode.lfu_cache;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LFUCacheTest {

    /**
     * "LFUCache",  "put",  "put",  "get",  "put",  "get",  "get",  "put",  "get",  "get",  "get"]
     * [[2],        [1,1],  [2,2],  [1],    [3,3],  [2],    [3],    [4,4],  [1],    [3],    [4]]
     * [null,       null,   null,   1,      null,   -1,     3,      null,   -1,     3,      4]
     */
    @Test
    public void test() {
        LFUCache cache = new LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        assertThat(cache.get(1)).isEqualTo(1);
        cache.put(3, 3);
        assertThat(cache.get(2)).isEqualTo(-1);
        assertThat(cache.get(3)).isEqualTo(3);
        cache.put(4, 4);
        assertThat(cache.get(1)).isEqualTo(-1);
        assertThat(cache.get(3)).isEqualTo(3);
        assertThat(cache.get(4)).isEqualTo(4);
    }

    @Test
    public void test0() {
        LFUCache cache = new LFUCache(0);

        cache.put(0, 0);
        assertThat(cache.get(0)).isEqualTo(-1);
    }
}