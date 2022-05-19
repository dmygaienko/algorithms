package com.mygaienko.common.algorithms.leetcode.find_median_from_data_stream;

import org.junit.Test;

import static org.junit.Assert.*;

public class MedianFinderTest {

    @Test
    public void test() {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        finder.addNum(3);
        assertEquals(2.0d, finder.findMedian(), 0.00001d);
    }
}