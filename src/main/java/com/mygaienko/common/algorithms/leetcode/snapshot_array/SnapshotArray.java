 package com.mygaienko.common.algorithms.leetcode.snapshot_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

class SnapshotArray {

    int SNAP_OPT = 10000;
    int snap_id = 0;
    Map<Integer, int[]> snapshots = new HashMap<>();
    Map<Integer, TreeMap<Integer, Integer>> compactSnapshots = new HashMap<>();

    public SnapshotArray(int length) {
        snapshots.put(snap_id, new int[length]);
    }

    public void set(int index, int val) {
        if (isOriginal(snap_id)) {
            snapshots.get(snap_id)[index] = val;
        } else {
            compactSnapshots.putIfAbsent(index, new TreeMap<>());
            compactSnapshots.get(index).put(snap_id, val);
        }
    }

    public int snap() {
        ++snap_id;
        if (isOriginal(snap_id)) {
            buildSnapshot();
        }
        return snap_id - 1;
    }

    public boolean isOriginal(int snapId) {
        return snapId % SNAP_OPT == 0;
    }

    public int get(int index, int snap_id) {
        if (isOriginal(snap_id)) {
            return snapshots.get(snap_id)[index];
        } else {
            int left = snap_id - (snap_id % SNAP_OPT);

            TreeMap<Integer, Integer> snapshotsValues = compactSnapshots.get(index);
            if (snapshotsValues == null
                    || snapshotsValues.isEmpty()
                    || snapshotsValues.floorEntry(snap_id) == null) return snapshots.get(left)[index];

            return snapshotsValues.floorEntry(snap_id).getValue();
        }
    }

    private void buildSnapshot() {
        int prevSnapId = snap_id - SNAP_OPT;
        int[] prevOriginalArray = snapshots.get(prevSnapId);
        int[] newArray = Arrays.copyOf(prevOriginalArray, prevOriginalArray.length);
        snapshots.put(snap_id, newArray);

        for (int i = 0; i < newArray.length; i++) {
            TreeMap<Integer, Integer> compactSnapshot = compactSnapshots.get(i);
            if (compactSnapshot != null && !compactSnapshot.isEmpty()) {
                Entry<Integer, Integer> entry = compactSnapshot.lastEntry();
                if (entry.getValue() >= prevSnapId) {
                    newArray[i] = entry.getValue();
                }
            }
        }
    }

}
