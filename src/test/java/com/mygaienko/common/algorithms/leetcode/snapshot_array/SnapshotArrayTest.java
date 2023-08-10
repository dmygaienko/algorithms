package com.mygaienko.common.algorithms.leetcode.snapshot_array;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class SnapshotArrayTest {



    /**
     * ["SnapshotArray","set","snap","snap","snap","get","snap","snap","get"]
     * [[1],[0,15],[],[],[],[0,2],[],[],[0,0]]
     */
    @Test
    public void test() {
        SnapshotArray snapshotArray = new SnapshotArray(1);
        snapshotArray.set(0, 15);
        snapshotArray.snap();
        snapshotArray.snap();
        snapshotArray.snap();
        assertThat(snapshotArray.get(0,2)).isEqualTo(15);
        snapshotArray.snap();
        snapshotArray.snap();
        assertThat(snapshotArray.get(0,0)).isEqualTo(15);
    }
}