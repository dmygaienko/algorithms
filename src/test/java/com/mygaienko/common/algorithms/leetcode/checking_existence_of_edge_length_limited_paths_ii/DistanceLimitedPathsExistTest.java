package com.mygaienko.common.algorithms.leetcode.checking_existence_of_edge_length_limited_paths_ii;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DistanceLimitedPathsExistTest {

    @Test
    public void test() {
        var exist = new DistanceLimitedPathsExist(6, new int[][]{
                {0, 2, 4}, {0, 3, 2}, {1, 2, 3}, {2, 3, 1}, {4, 5, 5}
        });

        assertTrue(exist.query(2, 3, 2));
        assertFalse(exist.query(1, 3, 3));
        assertTrue(exist.query(2, 0, 3));
        assertFalse(exist.query(0, 5, 6));
    }
}