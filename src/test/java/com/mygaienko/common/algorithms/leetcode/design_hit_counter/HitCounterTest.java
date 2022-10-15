package com.mygaienko.common.algorithms.leetcode.design_hit_counter;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class HitCounterTest {

    @Test
    public void test() {
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(1);
        hitCounter.hit(2);
        hitCounter.hit(3);
        assertThat(hitCounter.getHits(4)).isEqualTo(3);
        hitCounter.hit(300);
        assertThat(hitCounter.getHits(300)).isEqualTo(4);
        assertThat(hitCounter.getHits(301)).isEqualTo(3);
    }

    @Test
    public void test2() {
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(1);
        hitCounter.hit(1);
        hitCounter.hit(1);
        hitCounter.hit(300);
        assertThat(hitCounter.getHits(300)).isEqualTo(4);
    }

    @Test
    public void test3() {
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(2);
        hitCounter.hit(3);
        hitCounter.hit(4);
        assertThat(hitCounter.getHits(300)).isEqualTo(3);
        assertThat(hitCounter.getHits(301)).isEqualTo(3);
        assertThat(hitCounter.getHits(302)).isEqualTo(2);
        assertThat(hitCounter.getHits(303)).isEqualTo(1);
        assertThat(hitCounter.getHits(304)).isEqualTo(0);
        hitCounter.hit(501);
        assertThat(hitCounter.getHits(600)).isEqualTo(1);
    }

    @Test
    public void test4() {
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(100);
        hitCounter.hit(282);
        hitCounter.hit(411);
        hitCounter.hit(609);
        hitCounter.hit(620);
        hitCounter.hit(744);
        assertThat(hitCounter.getHits(879)).isEqualTo(3);
        hitCounter.hit(956);
        assertThat(hitCounter.getHits(976)).isEqualTo(2);
        hitCounter.hit(998);
        assertThat(hitCounter.getHits(1055)).isEqualTo(2);
    }
}