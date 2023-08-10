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

    /**
     * ["SnapshotArray","snap","snap","set","snap","get","set","get","snap","get"]
     * [[1],            [],     [],   [0,4], [],  [0,1],[0,12],[0,1],[],[0,3]]
     */
    @Test
    public void test1() {
        SnapshotArray snapshotArray = new SnapshotArray(1);
        snapshotArray.snap();
        snapshotArray.snap();
        snapshotArray.set(0, 4);
        snapshotArray.snap();
        assertThat(snapshotArray.get(0,1)).isEqualTo(4);
        snapshotArray.set(0, 12);
        assertThat(snapshotArray.get(0,1)).isEqualTo(4);
        snapshotArray.snap();
        assertThat(snapshotArray.get(0,3)).isEqualTo(12);
    }

    /**
     * ["SnapshotArray","set","snap","snap","set","set","get","get","get"]
     * [[3],            [1,6],[],    [],    [1,19],[0,4],[2,1],[2,0],[0,1]]
     */
    @Test
    public void test3() {
        SnapshotArray snapshotArray = new SnapshotArray(3);
        snapshotArray.set(1, 6);
        snapshotArray.snap();
        snapshotArray.snap();
        snapshotArray.set(1, 19);
        snapshotArray.set(0, 4);
        assertThat(snapshotArray.get(2,1)).isEqualTo(0);
        assertThat(snapshotArray.get(2,0)).isEqualTo(0);
        assertThat(snapshotArray.get(0,1)).isEqualTo(0);
    }

    /**
     * ["SnapshotArray","set",  "set","snap","get", "set","snap","set","set","get","get"]
     * [[3],            [1,18], [1,4],[]    ,[0,0], [0,20],[],   [0,2],[1,1],[1,1],[1,0]]
     */
    @Test
    public void test57() {
        SnapshotArray snapshotArray = new SnapshotArray(3);
        snapshotArray.set(1, 18);
        snapshotArray.set(1, 4);
        snapshotArray.snap();
        snapshotArray.snap();
        assertThat(snapshotArray.get(0,0)).isEqualTo(0);

        snapshotArray.set(0, 20);
        snapshotArray.snap();
        snapshotArray.set(0, 2);
        snapshotArray.set(1, 1);
        assertThat(snapshotArray.get(1,1)).isEqualTo(4);
        assertThat(snapshotArray.get(1,0)).isEqualTo(4);
    }
}